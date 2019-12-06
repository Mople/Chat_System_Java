import java.net.*;
import java.util.*;
import java.io.*;

public class User{
    //private String userID;
    private String userLogin;
    private InetAddress addr;
    private ManagerNetwork manager;

    public User(String login, InetAddress addr){
        //this.userID=id;
        this.userLogin=login;
        this.addr=addr;
        this.manager=new ManagerNetwork(this);
    }
        

    public void startUser1()throws IOException{
        manager.listenConnection();

    }

    public void startUser2()throws IOException{
        manager.sendUDPConnection();
        manager.startTCPServer();
    }



    public String getLogin(){
        return this.userLogin;
    }

    public InetAddress getInetAddress(){
        return this.addr;
    }
}