import java.io.*;
import java.net.*;
import java.util.*;

public class ManagerNetwork{

    private UDPListener udpListen;
    private UDPSender udpSend;
    private List<User> userList;

    public ManagerNetwork(){
        this.udpListen = new UDPListener();
        this.udpSend = new UDPSender();
        this.userList= new ArrayList<>();
    }

    public void listenConnection() throws IOException{
        UDPPacket packet = udpListen.receiveMessage();
        User newUser = new User(packet.getData(),packet.getInetAddress());
        userList.add(newUser);;
    }

    public void sendUDPConnection() throws IOException{
        udpSend.sendMessage();
    }

    public List<User> getUserList(){
        return userList;
    }


    




}