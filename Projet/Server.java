import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Server extends Thread{


    public Server() {
        start();
        
    }

    public void run() {
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