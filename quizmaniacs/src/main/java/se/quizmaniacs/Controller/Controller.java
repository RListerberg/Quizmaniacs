package se.quizmaniacs.Controller;

import java.io.IOException;

import se.quizmaniacs.Commands.CommandCreator;
import se.quizmaniacs.Connectivity.ConnectionHandler;
import se.quizmaniacs.Data.DataHandler;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class Controller {
    private DataHandler dataHandler;
    private ConnectionHandler connectionHandler;
    private CommandCreator commandCreator;

    public Controller() throws IOException {
        this.connectionHandler = new ConnectionHandler();
        this.dataHandler = new DataHandler();
        this.commandCreator = new CommandCreator();
    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public CommandCreator getCommandCreator() {
        return commandCreator;
    }
}
