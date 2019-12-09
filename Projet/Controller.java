import java.io.IOException;
import java.net.*;
import java.util.*;

public class Controller{

    private User user;
    private ManagerNetwork manager;
    private Scanner sc;

    public Controller(){
        this.sc=new Scanner(System.in);
        //String id = askID(sc);
        String name= askPseudo(sc);
        try{
            this.user=new User(name, InetAddress.getLocalHost());
        }catch(UnknownHostException e){
            System.out.println("Error init addr user in controller");
        }
        sc.close();
        //this.user.setController(this);
        this.manager=new ManagerNetwork(user);
        //manager.sendUDPConnectionBroadcast();
        //this.user.setManagerNetwork(manager);
    }


    public String askID(Scanner sc){
        System.out.println("Enter your ID :");
        String data = sc.nextLine();
        return data;
    }

    public String askPseudo(Scanner sc){
        System.out.println("Enter your pseudo :");
        String data = sc.nextLine();
        return data;
    }

    


}