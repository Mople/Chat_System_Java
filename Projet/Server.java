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
            link = servSocket.accept();
        }
        catch (Exception IOException){
            System.out.println("IO2");
        }
        try{
        while (i<10){
            

            //BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(),true);
            
            out.println("Message "+i+" from "+this.user.getLogin());
            //System.out.println("Client "+this.user.getLogin()+input);
            sleep(1000);
            
            i++;
            
        }
        
        }
        catch (Exception IOException){
            System.out.println("IO");
        }
        try{
            servSocket.close();
            link.close();
        }catch (Exception IOException){System.out.println("IO3");}
        
    }

}