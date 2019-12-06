import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPSender{


    public UDPSender(){

    }

    public void sendFirstMessage() throws IOException{
        System.out.println("Entrer pseudo : ");
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        DatagramSocket dgramSocket = null;
        try{
            dgramSocket = new DatagramSocket();
        }catch(SocketException e){
            System.out.println("Error create diagram socket sender");
        }
        DatagramPacket outPacket = new DatagramPacket(msg.getBytes(), msg.length(),InetAddress.getByName("255.255.255.255"),3500);
        
        sc.close();
        dgramSocket.send(outPacket);
        dgramSocket.close();
    }

}