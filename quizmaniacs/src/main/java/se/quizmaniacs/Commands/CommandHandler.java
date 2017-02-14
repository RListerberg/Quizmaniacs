package se.quizmaniacs.Commands;

import com.google.gson.Gson;

import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.Data.Parser;

/**
 * Created by LeoAsp on 2017-02-07.
 */


public class CommandHandler {
    Controller controller;
    Parser parser;

    public CommandHandler(Controller controller) {
        this.controller = controller;
        parser = new Parser();
    }

    public void handle(String message) {
        Command command = parser.parse(message);
        switch (command.type) {
            case DRAWLOBBYACT:
                System.out.println("RECIEVED " + command.type);
                break;

            default:
                System.out.println("Command Type Could Not Be Resolved");
                break;
        }
    }


}
