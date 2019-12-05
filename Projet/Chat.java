import java.net.*;
import java.io.*;

public class Chat{
    public static void main(String[] args) throws IOException{
        if (Integer.parseInt(args[0])==1){
            User user1 = new User("Pseudo1",InetAddress.getLocalHost());
            user1.startManagerListen();
        } else if (Integer.parseInt(args[0])==2) {
            User user2 = new User("Pseudo2",InetAddress.getLocalHost());
            user2.startManagerSend();
        }
        
        /*if (Integer.parseInt(args[0])==1){
            UDPListener udplist = new UDPListener();
            UDPPacket packet = udplist.receiveMessage();
            String msg = packet.getData();
            System.out.println(msg);
        }
        else if (Integer.parseInt(args[0])==2){
            UDPSender udpsend = new UDPSender();
            udpsend.sendMessage();
        }
        */
        
    }
}