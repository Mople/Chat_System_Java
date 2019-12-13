import java.lang.*;
import java.net.*;
import java.io.*;


public class TCPServerThread extends Thread{

    private Socket link;
    private User user;

    public TCPServerThread(Socket s, User user){
        this.link=s;
        this.user=user;
        start();
    }

    public void run(){
        try{
            Boolean stop=false;
            while (!stop){
                //BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
                PrintWriter out = new PrintWriter(link.getOutputStream(),true);
                out.println("Message from "+this.user.getLogin());
                sleep(1000);
            }
            this.link.close();
        }
        catch (Exception IOException){
            System.out.println("IO1");
        }
    }


}