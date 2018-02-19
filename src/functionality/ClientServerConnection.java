package functionality;

import models.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientServerConnection {

    private String host = "localhost";
    private int port = 4000;
    private Socket clientSocket;

    public ClientServerConnection(){

    }

    /*
    * This method will start the client, initialize the ObjectOutputStream and the ObjectInputStream
    * ObjectOutputStream will send a login request object to the server
    * ObjectInputStream will take in the response for the server
    * */
    public void startClientLoginRequest(LoginRequest userInformation){

        User authenticatedUser = null;

        try{
            clientSocket = new Socket(host, port);

            ObjectOutputStream ouputToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream inputFromServer = new ObjectInputStream(clientSocket.getInputStream());

            ouputToServer.writeObject(userInformation);
            authenticatedUser = (User) inputFromServer.readObject();
            System.out.println(authenticatedUser.getfName());

            System.out.println("Login Request Sent");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    
}
