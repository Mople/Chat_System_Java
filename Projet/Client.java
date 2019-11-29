import java.net.*;
import java.io.*;
import java.lang.*;


public class Client extends Thread{

	private User user;
	private int port;

    public Client (User user, int port) throws IOException {
		this.user=user;
		this.port=port;
		this.start();
		
    }

    public void run() {
		Socket link=null;
		String input;
		//BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
		
			
		while (true){
			try{link = new Socket("127.0.0.1",this.port);}catch(Exception e){break;}
			
			try {
				
				//PrintWriter out = new PrintWriter(link.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
				try{input = in.readLine();}catch(Exception IOException){break;}
				
				System.out.println("Client "+this.user.getLogin()+input);
				link.close();
			}
			catch (Exception IOException){
				System.out.println("IO");
			}

			
		}
	}
		
		
    

}