package se.quizmaniacs.Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ClientWriteThread {
    private boolean running = true;
    PrintWriter clientWriter;

    public ClientWriteThread(Socket socket) throws IOException {
        clientWriter = new PrintWriter(socket.getOutputStream(), true);
    }


    public void send(String message) {
        clientWriter.println();
        clientWriter.flush();
    }

}
