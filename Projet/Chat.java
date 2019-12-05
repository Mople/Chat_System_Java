import java.net.*;
import java.io.*;

public class Chat{
    public static void main(String[] args) throws IOException{
        /*if (Integer.parseInt(args[0])==1){
            User user1 = new User("1","User1", 1250, 1260);
            user1.startClient();
        } else if (Integer.parseInt(args[0])==2) {
            User user2 = new User("2","User2", 1260, 1250);
            user2.startServer();
        }
        */
        if (Integer.parseInt(args[0])==1){
            UDPListener udplist = new UDPListener();
            UDPPacket packet = udplist.receiveMessage();
            String msg = packet.getData();
            System.out.println(msg);
        }
        else if (Integer.parseInt(args[0])==2){
            UDPSender udpsend = new UDPSender();
            udpsend.sendMessage();
        }
    }
}