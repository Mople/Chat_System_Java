import java.io.IOException;
import java.net.*;
import java.util.*;

public class Controller{

    private User user;
    private ManagerNetwork manager;
    private Scanner sc;

    public Controller(){
        this.sc=new Scanner(System.in);
        String name= askPseudo(sc);
        try{
            this.user=new User(name, InetAddress.getLocalHost());
            System.out.println(InetAddress.getLocalHost());
        }catch(UnknownHostException e){
            System.out.println("Error init addr user in controller");
        }
        sc.close();
        this.manager=new ManagerNetwork(user);
        makeCommand(sc);
    }



    public String askPseudo(Scanner sc){
        System.out.println("Enter your pseudo :");
        String data = sc.nextLine();
        return data;
    }

    
    public void makeCommand(Scanner sc){
        System.out.println("Next action ?");
        String commande = sc.nextLine();
        if (commande.startsWith("START CHAT")){
            System.out.println("With who?");
            String user = sc.nextLine();
            //manager.startCommunication(user);
        }
    }


}