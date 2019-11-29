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
		try {
			link = new Socket("127.0.0.1",this.port);
			int u=0;
			while (u<10){
				
				BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
				//PrintWriter out = new PrintWriter(link.getOutputStream(),true);

				String input = in.readLine();
				System.out.println("Client "+this.user.getLogin()+input);

				u++;
			}
			link.close();
		}
		catch (Exception IOException){
			System.out.println("IO");
		}
		
    }

}