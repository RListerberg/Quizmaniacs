package se.quizmaniacs.Connectivity;

import android.util.Log;

import java.io.IOException;
import java.net.Socket;

import se.quizmaniacs.Data.DataBank;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ConnectionHandler implements Runnable {
    private Socket socket;
    boolean connected = false;
    private String host = "192.168.1.127";
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
                Log.i("SUCCESS", "Connected to: " + host + ":" + port);
                DataBank.portNr = socket.getLocalPort();
                connected = true;
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("FAILED", host);
            }
        }
    }

    public void setHost(String host) {
        Log.i("Info", "Host set to" + host);
        this.host = host;
    }
}
