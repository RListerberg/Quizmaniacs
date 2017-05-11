package se.quizmaniacs.Connectivity;

import java.io.IOException;
import java.net.Socket;

import se.quizmaniacs.Data.DataBank;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ConnectionHandler implements Runnable {
    private Socket socket;
    boolean connected = false;
    private String host = "172.18.4.102";
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
                DataBank.portNr = socket.getLocalPort();
                connected = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
