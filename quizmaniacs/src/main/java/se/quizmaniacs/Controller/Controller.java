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
    private static DataHandler dataHandler;
    private static ConnectionHandler connectionHandler;
    private static CommandMaker commandMaker;
    private static CommandHandler commandHandler;

    public Controller() throws IOException {
        connectionHandler = new ConnectionHandler(this);
        dataHandler = new DataHandler(this);
        commandMaker = new CommandMaker(this);
        commandHandler = new CommandHandler(this);
    }

    public static DataHandler getDataHandler() {
        return dataHandler;
    }

    public static ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public static CommandHandler getCommandHandler() {return commandHandler;}

    public static CommandMaker getCommandMaker() {
        return commandMaker;
    }
}
