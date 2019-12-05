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
        //this.clientPort=clientPort;
        //this.servPort=servPort;

    }
        

    public void startUser1()throws IOException{
        manager.listenConnection();
        List<User> userList = manager.getUserList();
        manager.startTCPClient();

    }

    public void startUser2()throws IOException{
        manager.sendUDPConnection();
        manager.startTCPServer();
    }



    public String getLogin(){
        return this.userLogin;
    }
}