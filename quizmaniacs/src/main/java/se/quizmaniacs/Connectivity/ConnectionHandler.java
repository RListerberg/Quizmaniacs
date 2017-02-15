package se.quizmaniacs.Connectivity;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ConnectionHandler implements Runnable {
    private Socket socket;
    boolean connected = false;
    private String host = "10.8.1.119";
    private int port = 8008;


    public ConnectionHandler() {
    }


    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (!connected) {
            try {
                socket = new Socket(host, port);
                System.out.println("Connected to: " + host + ":" + port);
                connected = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
