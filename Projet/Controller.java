import java.net.*;
import java.util.*;

public class Controller{

    private User user;
    private ManagerNetwork manager;
    private Scanner sc;

    public Controller(){
        this.sc=new Scanner(System.in);
        String id = askID(sc);
        String name= askPseudo(sc);
        try{
            this.user=new User(id, name, InetAddress.getLocalHost());
        }catch(UnknownHostException e){
            System.out.println("Error init addr user in controller");
        }
        this.user.setController(this);
        this.manager=new ManagerNetwork(user);
        this.user.setManagerNetwork(manager);
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