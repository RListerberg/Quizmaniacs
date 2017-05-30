package se.quizmaniacs.Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientWriteThread implements Runnable {
    private boolean running = true;
    private PrintWriter out;
    private List<String> queuedMessages;

    public ClientWriteThread(Socket socket) throws IOException {
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
