import java.net.*;
import java.io.*;
import java.lang.*;

public class Server extends Thread{

    private User user;
    private int port;

    public Server(User user,int port) throws IOException {
        this.user=user;
        this.port=port;
        this.start();
        
    }

    public void run() {
        int i=0;
        ServerSocket servSocket=null;
        Socket link = null;
        try{
            servSocket= new ServerSocket(port);
            
        }
        catch (Exception IOException){
            System.out.println("IO2");
        }
        try{
        while (i<5){
            link = servSocket.accept();

            //BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(),true);
            
            out.println("Message "+i+" from "+this.user.getLogin());
            System.out.println("send");
            //System.out.println("Client "+this.user.getLogin()+input);
            link.close();
            sleep(1000);
            
            i++;
            
        }
        
        }
        catch (Exception IOException){
            System.out.println("IO1");
        }
        try{
            servSocket.close();
            
        }catch (Exception IOException){System.out.println("IO3");}
        
    }

}