package se.quizmaniacs.Data;

import java.io.IOException;
import java.net.Socket;

import se.quizmaniacs.Threads.ClientReadThread;
import se.quizmaniacs.Threads.ClientWriteThread;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class DataHandler {
    ClientReadThread readThread;
    ClientWriteThread writeThread;


    public DataHandler() {

    }

    public void send(String message) {
        writeThread.send(message);
    }

    public void startThreads(Socket socket) throws IOException {
        readThread = new ClientReadThread(socket);
        writeThread = new ClientWriteThread(socket);

        new Thread(readThread).start();
    }
}
