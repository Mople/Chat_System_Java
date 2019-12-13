import java.io.IOException;
import java.net.*;
import java.util.*;
import java.lang.*;

public class Controller{

    private User user;
    private ManagerNetwork manager;
    private Scanner sc;

    public Controller(){
        this.sc=new Scanner(System.in);
        String name= askPseudo(sc);
        InetAddress addr = findUserAddr();
        if (addr==null){System.out.println("addr =null");}
        this.user=new User(name, addr);
        System.out.println(addr);
        sc.close();
        this.manager=new ManagerNetwork(user);
        makeCommand(sc);
    }



    private InetAddress findUserAddr(){
        InetAddress result =null;
        Enumeration<NetworkInterface> inter = null;
        try{
        inter = NetworkInterface.getNetworkInterfaces();
        }
        catch(SocketException e){
            System.out.println("SocketException in findUserAddr");
        }
        while ((result==null)&&(inter.hasMoreElements())){
            NetworkInterface currentInter = inter.nextElement();
            List<InterfaceAddress> listAddr = currentInter.getInterfaceAddresses();
            Iterator<InterfaceAddress> iteAddr = listAddr.iterator();
            while ((result==null) && iteAddr.hasNext()){
                InterfaceAddress currentAddr = iteAddr.next();
                if (currentAddr.getNetworkPrefixLength()==16){
                    result = currentAddr.getAddress();
                }
            }
        }
        return result;
    }

    private String askPseudo(Scanner sc){
        System.out.println("Enter your pseudo :");
        String data = sc.nextLine();
        return data;
    }

    
    private void makeCommand(Scanner sc){
        System.out.println("Next action ?");
        String commande = sc.nextLine();
        if (commande.startsWith("START CHAT")){
            System.out.println("With who?");
            String user = sc.nextLine();
            //manager.startCommunication(user);
        }
    }


}