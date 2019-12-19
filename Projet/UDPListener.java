import java.io.IOException;
import java.net.*;
import java.lang.*;

public class UDPListener extends Thread{

    private ManagerNetwork manager;

    public UDPListener(ManagerNetwork man){
        this.manager=man;
        start();
    }

    public void run() {
        DatagramSocket dgramSocket = null;
        Boolean stop=false;
            try{
                dgramSocket = new DatagramSocket(3500);
            }
            catch(SocketException e){
                System.out.println("Error create DatagramSocket");
            }
        while(!stop){
            

            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            try{
                dgramSocket.receive(inPacket);            
                UDPPacket packet = new UDPPacket(inPacket);        
                new ReadUDPPacket(packet,this.manager);
            }catch(IOException e){
                System.out.println("Error IO udplist");
            }
        }
        
        dgramSocket.close();
        

    }

}