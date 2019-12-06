import java.io.IOException;
import java.net.*;
import java.lang.*;

public class UDPListener extends Thread{

    private ManagerNetwork manager;

    public UDPListener(ManagerNetwork man){
        this.manager=man;
        this.start();
    }

    public void start() {
        while(true){
            DatagramSocket dgramSocket = null;
            try{
                dgramSocket = new DatagramSocket(3500);
            }
            catch(SocketException e){
                System.out.println("Error create DatagramSocket");
            }

            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            try{
                dgramSocket.receive(inPacket);
            }catch(IOException e){
                System.out.println("Error IO udplist");
            }

            UDPPacket packet = new UDPPacket(inPacket);        
            manager.readPacket(packet);
            dgramSocket.close();
        }
    }

}