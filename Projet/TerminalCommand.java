import java.lang.*;
import java.util.*;

public class TerminalCommand extends Thread{

    private Scanner sc;
    private Controller control;

    public TerminalCommand(Controller c, Scanner sc){
        this.sc=sc;
        this.control = c;
        start();
    }

    public void run(){
        Boolean stop=false;
        while(!stop){
            System.out.println("Next action ? (START CHAT/CLOSE)");
            String commande = this.sc.nextLine();
            if (commande.startsWith("START CHAT")){
                System.out.println("With who?");
                String userName = this.sc.nextLine();
                System.out.println("Starting chat with "+userName);
                System.out.println("What's your message?");
                String msg = this.sc.nextLine();
                this.control.send(userName,msg);
            }
            else if(commande.startsWith("CLOSE")){
                System.out.println("Closing application");
                stop= true;
            }
            else{
                System.out.println("Unknown command");
            }
        }
    }





}