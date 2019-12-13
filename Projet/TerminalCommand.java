import java.lang.*;
import java.util.*;

public class TerminalCommand extends Thread{

    private Scanner sc;

    public TerminalCommand(Scanner sc){
        this.sc=sc;
        start();
    }

    public void run(){
        while(true){
            System.out.println("Next action ?");
            String commande = sc.nextLine();
            if (commande.startsWith("START CHAT")){
                System.out.println("With who?");
                String userName = sc.nextLine();
                System.out.println("Starting chat with "+userName);
            }
            else if(commande.startsWith("CLOSE")){
                System.out.println("Closing application");
            }
            else{
                System.out.println("Unknown command");
            }
        }
    }





}