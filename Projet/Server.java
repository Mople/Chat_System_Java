import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Server {

    private ManagerNetwork manager;

    public Server(ManagerNetwork man) {
        this.manager=man;
        waitConnection();
        
    }

    public void waitConnection() {
        ServerSocket servSocket=null;
        try{
            servSocket= new ServerSocket(3600);
            Boolean stop=false;
            while(!stop){
            new TCPServerThread(servSocket.accept(),this.manager.getUser());
            }  
            
        }
        catch (Exception IOException){
            System.out.println("IO2");
        }
         

        try{
            servSocket.close();
            
        }catch (Exception IOException){System.out.println("IO3");}
        
    }

}