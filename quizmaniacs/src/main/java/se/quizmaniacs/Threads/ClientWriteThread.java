package se.quizmaniacs.Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import se.quizmaniacs.Controller.Controller;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ClientWriteThread implements Runnable {
    Controller controller;
    private boolean running = true;
    private PrintWriter out;
    private List<String> queuedMessages;

    public ClientWriteThread(Controller controller, Socket socket) throws IOException {
        this.controller = controller;
        queuedMessages = new ArrayList<>();
        out = new PrintWriter(socket.getOutputStream(), true);
    }


    public void send(String message) {
        queuedMessages.add(message);
    }

    @Override
    public void run() {
        while (running) {
            while (queuedMessages.size() != 0) {
                out.println(queuedMessages.get(0));
                System.out.println("SENT: " + queuedMessages.get(0));
                queuedMessages.remove(0);
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
