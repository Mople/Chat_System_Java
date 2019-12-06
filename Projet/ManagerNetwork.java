import java.io.*;
import java.net.*;
import java.util.*;

public class ManagerNetwork{

    private UDPListener udpListen;
    private UDPSender udpSend;
    private User user;
    private List<User> userList;
    private Controller contr;

    public ManagerNetwork(User user){
        this.udpSend = new UDPSender();
        this.user=user;
        this.userList= new ArrayList<>();
        //this.udpListen = new UDPListener(this);
    }

    //Thread listening for UDP packet on local network 
    public void listenConnection() throws IOException{
        this.udpListen = new UDPListener(this);
    }

    //Read the packet received and do something depending on the message
    public void readPacket(UDPPacket packet) throws IOException{
        User newUser = new User(null,packet.getData(),packet.getInetAddress());
        userList.add(newUser);
        startTCPClient();
    } 

    //Broadcast on network a connection message
    public void sendUDPConnection() throws IOException{
        udpSend.sendFirstMessage();
    }
    
    //Launch a TCP Server on port 3600
    public void startTCPServer() throws IOException{
        new Server(this.user, 3600);
    }

    //Launch a TCP Client connected with another user(on his port 3600)
    public void startTCPClient() throws IOException{
        new Client(this.userList.get(0), 3600);
    }


    /*
    Get Methods
    */
    public List<User> getUserList(){
        return userList;
    }

    /*
    Set Methods
    */
    public void setController(Controller contr){
        this.contr=contr;
    }

    




}