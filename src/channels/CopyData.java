package channels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class CopyData {
    public static void main(String args[]) throws IOException {
        FileInputStream input = new FileInputStream("E:\\workspace\\input.txt");
        ReadableByteChannel source = input.getChannel();

        FileOutputStream output = new FileOutputStream("E:\\workspace\\output.txt");
        WritableByteChannel destination = output.getChannel();

        copyData(source,destination);
        source.close();
        destination.close();

    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
        while (src.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            buffer.clear();
        }
    }

}
