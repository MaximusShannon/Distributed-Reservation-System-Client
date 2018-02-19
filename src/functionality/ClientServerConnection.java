package functionality;

import models.ResponseMessage;
import models.Session;
import models.User;

import java.io.ObjectInput;
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
    public User startClientLoginRequest(LoginRequest userInformation){

        User authenticatedUser = null;

        try{
            clientSocket = new Socket(host, port);

            ObjectOutputStream ouputToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream inputFromServer = new ObjectInputStream(clientSocket.getInputStream());

            ouputToServer.writeObject(userInformation);

            authenticatedUser = (User) inputFromServer.readObject();


        }catch (Exception e){
            e.printStackTrace();
        }

        return authenticatedUser;

    }

    public String startRegisterRequest(User userInformation){

        String response = "";

        try{
            clientSocket = new Socket(host, 4045);

            ObjectOutputStream outputToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream inputFromServer = new ObjectInputStream(clientSocket.getInputStream());

            outputToServer.writeObject(userInformation);

            ResponseMessage message = (ResponseMessage) inputFromServer.readObject();
            response = message.getMessage();

        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }
}
