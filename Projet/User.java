import java.net.*;
import java.util.*;
import java.io.*;

public class User{
    //private String userID;
    private String userLogin;
    private InetAddress addr;
    private ManagerNetwork manager;
    private Client userClient;
    private Server userServer;
    private int servPort;
    private int clientPort;

    public User(String login, InetAddress addr){
        //this.userID=id;
        this.userLogin=login;
        this.addr=addr;
        this.manager=new ManagerNetwork();
        //this.clientPort=clientPort;
        //this.servPort=servPort;

    }
        
        

    public void startServer(){
        try{this.userServer = new Server(this,servPort);}catch(Exception IOException){}
    }
        
    public void startClient(){
        try{this.userClient = new Client(this,clientPort);}catch(Exception IOException ){}
    }

    public void startManagerListen()throws IOException{
        manager.listenConnection();
        List<User> userList = manager.getUserList();
    }

    public void startManagerSend()throws IOException{
        manager.sendUDPConnection();
    }

    public String getLogin(){
        return this.userLogin;
    }
}