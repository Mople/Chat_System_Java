import java.io.*;
import java.net.*;
import java.util.*;

public class ManagerNetwork{

    private UDPSender udpSend;
    private User user;
    private String userLogin;
    private List<User> userList;

    public ManagerNetwork(User user){
        this.userLogin = user.getLogin();
        this.udpSend = new UDPSender(this.userLogin);
        new UDPListener(this);

        this.user=user;

        this.userList= new ArrayList<>();
        userList.add(user);
        new Server();
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
        udpSend.sendReply(this.userLogin,address);
    }
    
  

    public void sendMessage(String userName, String msg){
        //Iterator<User> iteUser = userList.iterator();
        Boolean stop = false;
        User destUser= new User(null, null);
        int i=0;
        while (i<this.userList.size() && !stop){
            destUser = this.userList.get(i);
            System.out.println(destUser.getLogin());
            if (destUser.getLogin()==userName){
                System.out.println("found");
                stop=true;
            }
            i++;
        }
        //if (!stop){System.out.println("User Not found in sendMessage");}
        //else{
            System.out.println(destUser.getLogin());
            new Client(destUser, 3600, msg);
        //}
    }




    public void printUserList(){
        Iterator<User> iteUser = userList.iterator();
        while (iteUser.hasNext()){
            User currentUser = iteUser.next();
            if (currentUser.getLogin()==this.userLogin){
                System.out.println("(You) "+currentUser.getLogin());
            }else{
            System.out.println(currentUser.getLogin());
            }
        }        
    }
    /*
    Get Methods
    */
    public List<User> getUserList(){
        return userList;
    }



    




}