package se.quizmaniacs.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ClientReadThread implements Runnable {
    private boolean running = true;
    BufferedReader clientReader;


    public ClientReadThread(Socket socket) throws IOException {
        clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        while (running) {

        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
