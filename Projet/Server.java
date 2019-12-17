import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Server {


    public Server() {
        waitConnection();
        
    }

    public void waitConnection() {
        ServerSocket servSocket=null;
        try{
            servSocket= new ServerSocket(3600);
            Boolean stop=false;
            while(!stop){
            new TCPListenerThread(servSocket.accept());
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