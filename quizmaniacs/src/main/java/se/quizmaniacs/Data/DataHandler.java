package se.quizmaniacs.Data;

import java.io.IOException;
import java.net.Socket;

import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.Threads.ClientReadThread;
import se.quizmaniacs.Threads.ClientWriteThread;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class DataHandler {
    Controller controller;
    ClientReadThread readThread;
    ClientWriteThread writeThread;

    public DataHandler(Controller controller) {
        this.controller = controller;
    }

    public void send(String message) {
        writeThread.send(message);
    }

    public void startThreads(Socket socket) throws IOException {
        readThread = new ClientReadThread(controller, socket);
        writeThread = new ClientWriteThread(controller, socket);

        new Thread(readThread).start();
        new Thread(writeThread).start();
    }
}
