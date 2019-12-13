import java.io.*;
import java.net.*;
import java.util.*;

public class ManagerNetwork{

    private UDPSender udpSend;
    private User user;
    private List<User> userList;

    public ManagerNetwork(User user){
        this.udpSend = new UDPSender(user.getLogin());
        new UDPListener(this);
        this.user=user;
        this.userList= new ArrayList<>();
        userList.add(user);
        startTCPClient(user);
    }


    //Read the packet received and do something depending on the message
    public void readPacket(UDPPacket packet) {
        String data = packet.getData();
        System.out.println("Packet received");
        if (data.startsWith("New User : ")){
            String pseudoUser = data.replaceFirst("New User : ", "");
            User newUser = new User(pseudoUser, packet.getInetAddress());
            userList.add(newUser);
            sendUDPConnectionReply(newUser.getInetAddress());
            System.out.println("New user on network " + pseudoUser);
            System.out.println("New userList :");
            printUserList();
            System.out.println("Size of userList : "+userList.size());
        }
        else if (data.startsWith("User on network : ")){
            String pseudoUser = data.replaceFirst("User on network : ", "");
            User newUser = new User(pseudoUser, packet.getInetAddress());
            userList.add(newUser);
            System.out.println("User already on network " + pseudoUser);
            System.out.println("New userList :");
            printUserList();
            System.out.println("Size of userList : " + userList.size());
        }
        
    } 

    

    //Reply to a broadcast
    public void sendUDPConnectionReply(InetAddress address){
        udpSend.sendReply(this.user.getLogin(),address);
    }
    
  
    

    //Launch a TCP Server on port 3600
    public void startTCPServer(){
        new Server(this);
    }

    //Launch a TCP Client connected with another user(on his port 3600)
    public void startTCPClient(User user){
        new Client(user, 3600);
    }




    public void printUserList(){
        Iterator<User> iteUser = userList.iterator();
        while (iteUser.hasNext()){
            User currentUSer = iteUser.next();
            if (currentUSer.getLogin()==this.user.getLogin()){
                System.out.println("(You) "+currentUSer.getLogin());
            }else{
            System.out.println(currentUSer.getLogin());
            }
        }        
    }
    /*
    Get Methods
    */
    public List<User> getUserList(){
        return userList;
    }

    public User getUser(){
        return this.user;
    }


    




}