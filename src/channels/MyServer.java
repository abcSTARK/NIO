package channels;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String args[]){
        try{
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server started");
            Socket client = server.accept();

            DataInputStream din = new DataInputStream(client.getInputStream());
            String message = din.readUTF();
            System.out.println("Client message : "+message);
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
