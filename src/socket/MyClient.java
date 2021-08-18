package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClient {
    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost",6666);
            System.out.println("Server started");

            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            dout.writeUTF("hello from client");
            //ObjectOutputStream we can use to send objects also
            //Also use Scanner Interface
            dout.flush();
            dout.close();
            dout.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
