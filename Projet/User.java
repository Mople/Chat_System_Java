public class User{
    private String userID;
    private String userLogin;
    private Client userClient;
    private Server userServer;
    private int servPort;
    private int clientPort;

    public User(String id, String login, int servPort, int clientPort){
        this.userID=id;
        this.userLogin=login;
        this.clientPort=clientPort;
        this.servPort=servPort;

    }
        
        

    public void startServer(){
        try{this.userServer = new Server(this,servPort);}catch(Exception IOException){}
    }
        
    public void startClient(){
        try{this.userClient = new Client(this,clientPort);}catch(Exception IOException ){}
    }


    public String getLogin(){
        return this.userLogin;
    }
}