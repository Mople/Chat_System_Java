import java.io.*;
import java.net.*;
import java.util.*;

public class ManagerNetwork{

    private UDPListener udpListen;
    private UDPSender udpSend;
    private User user;
    private List<User> userList;
    //private Controller contr;

    public ManagerNetwork(User user){
        this.udpSend = new UDPSender(user.getLogin());
        this.user=user;
        this.userList= new ArrayList<>();
        userList.add(user);
        this.udpListen = new UDPListener(this);
    }

    //Thread listening for UDP packet on local network 
    /*public void listenConnection() {
        this.udpListen = new UDPListener(this);
    }*/

    //Read the packet received and do something depending on the message
    public void readPacket(UDPPacket packet) {
        String data = packet.getData();
        System.out.println("Packet received");
        if (data.startsWith("New User : ")){
            String pseudoUser = data.replaceFirst("New User : ", "");
            User newUser = new User(pseudoUser, packet.getInetAddress());
            userList.add(newUser);
            System.out.println("New user on network " + pseudoUser);
            System.out.println("Size of userList : "+userList.size());
        }
        else if (data.startsWith("User on network : ")){
            String pseudoUser = data.replaceFirst("User on network : ", "");
            User newUser = new User(pseudoUser, packet.getInetAddress());
            userList.add(newUser);
            System.out.println("User already on network " + pseudoUser);
            System.out.println("Size of userList : " + userList.size());
        }
        
    } 

    //Broadcast on network a connection message
    public void sendUDPConnectionBroadcast() {
        udpSend.sendFirstMessage(this.user.getLogin());
    }

    //Reply to a broadcast
    public void sendUDPConnectionReply(InetAddress address){
        udpSend.sendReply(this.user.getLogin(),address);
    }
    


    //Launch a TCP Server on port 3600
    /*public void startTCPServer() throws IOException{
        new Server(this.user, 3600);
    }

    //Launch a TCP Client connected with another user(on his port 3600)
    public void startTCPClient() throws IOException{
        new Client(this.userList.get(0), 3600);
    }*/


    /*
    Get Methods
    */
    public List<User> getUserList(){
        return userList;
    }

    /*
    Set Methods
    */
   /* public void setController(Controller contr){
        this.contr=contr;
    }*/

    




}