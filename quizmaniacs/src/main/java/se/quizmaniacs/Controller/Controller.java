package se.quizmaniacs.Controller;

import se.quizmaniacs.Commands.CommandHandler;
import se.quizmaniacs.Commands.CommandMaker;
import se.quizmaniacs.Connectivity.ConnectionHandler;
import se.quizmaniacs.Data.DataHandler;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class Controller {

    private static DataHandler dataHandler = new DataHandler();
    private static ConnectionHandler connectionHandler = new ConnectionHandler();
    private static CommandMaker commandMaker = new CommandMaker();
    private static CommandHandler commandHandler = new CommandHandler();


    public static DataHandler getDataHandler() {
        return dataHandler;
    }

    public static ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public static CommandHandler getCommandHandler() {
        return commandHandler;
    }


    public static CommandMaker getCommandMaker() {
        return commandMaker;
    }
}
