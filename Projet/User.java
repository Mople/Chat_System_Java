import java.net.*;
import java.util.*;
import java.io.*;

public class User{
    //private String userID;
    private String userLogin;
    private InetAddress addr;
    private ManagerNetwork manager;
    private Controller contr;

    public User(String login, InetAddress addr){
        //this.userID=id;
        this.userLogin=login;
        this.addr=addr;
    }
        

    /*
    Get Methods
    */
    public String getLogin(){
        return this.userLogin;
    }

    public InetAddress getInetAddress(){
        return this.addr;
    }

    /*
    Set Methods
    */
    public void setManagerNetwork(ManagerNetwork man){
        this.manager=man;
    }

    public void setController(Controller contr){
        this.contr=contr;
    }

}