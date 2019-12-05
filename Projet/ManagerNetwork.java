import java.io.*;
import java.net.*;
import java.util.*;

public class ManagerNetwork{

    private UDPListener udpListen;
    private UDPSender udpSend;
    private User user;
    private List<User> userList;

    public ManagerNetwork(User user){
        this.udpListen = new UDPListener();
        this.udpSend = new UDPSender();
        this.user=user;
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

    public void startTCPServer() throws IOException{
        new Server(this.user, 3550);
    }

    public void startTCPClient() throws IOException{
        new Client(this.userList.get(0), 3550);
    }

    public List<User> getUserList(){
        return userList;
    }


    




}