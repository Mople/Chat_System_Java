import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPSender{

    

    public UDPSender(String login){
        sendFirstMessage(login);
    }

    public void sendFirstMessage(String login) {
        System.out.println("SEND");
        String msg = "New User : "+login;

        
        DatagramSocket dgramSocket = null;
        DatagramPacket outPacket = null;
        try{
            dgramSocket = new DatagramSocket();
        }catch(SocketException e){
            System.out.println("Error create diagram socket sender");
        }
        try{
            outPacket = new DatagramPacket(msg.getBytes(), msg.length(),InetAddress.getByName("255.255.255.255"),3500);
        }catch(UnknownHostException e){
            System.out.println("Error create dgram packet");
        }
        try{
            dgramSocket.send(outPacket);
        }
        catch(IOException e){
            System.out.println("Error dgram send");
        }
        dgramSocket.close();
    }



    public void sendReply(String login, InetAddress address) {
        String msg = "User on network : "+login;

        DatagramSocket dgramSocket = null;
        DatagramPacket outPacket = null;
        try{
            dgramSocket = new DatagramSocket();
        }catch(SocketException e){
            System.out.println("Error create diagram socket sender");
        }
        outPacket = new DatagramPacket(msg.getBytes(), msg.length(),address,3500);
        try{
            dgramSocket.send(outPacket);
        }
        catch(IOException e){
            System.out.println("Error send dgram packet");
        }
            dgramSocket.close();
    }
}