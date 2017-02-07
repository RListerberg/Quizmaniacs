package se.quizmaniacs.Controller;

import java.io.IOException;

import se.quizmaniacs.Commands.CommandHandler;
import se.quizmaniacs.Commands.CommandMaker;
import se.quizmaniacs.Connectivity.ConnectionHandler;
import se.quizmaniacs.Data.DataHandler;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class Controller {
    private DataHandler dataHandler;
    private ConnectionHandler connectionHandler;
    private CommandMaker commandMaker;
    private CommandHandler commandHandler;

    public Controller() throws IOException {
        this.connectionHandler = new ConnectionHandler(this);
        this.dataHandler = new DataHandler(this);
        this.commandMaker = new CommandMaker(this);
        this.commandHandler = new CommandHandler(this);
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

    public CommandMaker getCommandMaker() {
        return commandMaker;
    }
}
