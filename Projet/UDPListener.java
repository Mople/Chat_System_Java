import java.io.IOException;
import java.net.*;

public class UDPListener{

    public UDPListener(){

    }

    public String receiveMessage() throws IOException {
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
        String msg = new String(inPacket.getData(),0,inPacket.getLength());
        
        dgramSocket.close();
        
        return msg;
    }

}