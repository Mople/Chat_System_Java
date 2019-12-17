import java.lang.*;
import java.net.*;
import java.io.*;


public class TCPListenerThread extends Thread{

    private Socket link;

    public TCPListenerThread(Socket s){
        this.link=s;
        start();
    }

    public void run(){
        String input;
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            input = in.readLine();
            System.out.println("Received from: "+input);
            this.link.close();
        }
        catch (Exception IOException){
            System.out.println("IO1");
        }
    }


}