package socket;

import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class nio4_selector_client {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("welcome");
        InetSocketAddress hA = new InetSocketAddress("localhost", 6666);
        SocketChannel client = SocketChannel.open(hA);
        System.out.println("The Client is sending messages to server...");
        // Sending messages to the server
        String[] msg = new String[] { "Time goes fast.", "What next?", "Bye Bye" };
        for (int j = 0; j < msg.length; j++) {
            byte[] message = new String(msg[j]).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);
            System.out.println(msg[j]);
            buffer.clear();
            Thread.sleep(3000);
        }
        client.close();
    }
}
