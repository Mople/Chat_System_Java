import java.io.IOException;
import java.net.*;

public class UDPListener{

    public UDPListener(){

    }

    public UDPPacket receiveMessage() throws IOException {
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
        
        dgramSocket.close();
        
        return packet;
    }

}