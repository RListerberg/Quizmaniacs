package se.quizmaniacs.Controller;

import java.io.IOException;

import se.quizmaniacs.Commands.CommandHandler;
import se.quizmaniacs.Connectivity.ConnectionHandler;
import se.quizmaniacs.Data.DataHandler;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class Controller {
    private DataHandler dataHandler;
    private ConnectionHandler connectionHandler;
    private CommandHandler commandHandler;

    public Controller() throws IOException {
        this.connectionHandler = new ConnectionHandler();
        this.dataHandler = new DataHandler();
        this.commandHandler = new CommandHandler();
    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }
}
