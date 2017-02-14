package se.quizmaniacs.Commands;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import se.quizmaniacs.Data.Parser;
import se.quizmaniacs.DataBank;
import se.quizmaniacs.Jdo.Room;

/**
 * Created by LeoAsp on 2017-02-07.
 */


public class CommandHandler {
    Parser parser;

    public CommandHandler() {
        parser = new Parser();
    }

    public void handle(String message) {
        Command command = parser.parse(message);
        switch (command.type) {
            case DRAWLOBBYACT:
                System.out.println("RECIEVIED " + command.type);
                Type roomArrayListToken = new TypeToken<ArrayList<Room>>() {}.getType();
                System.out.println(command.data);
                DataBank.rooms = new Gson().fromJson(command.data, roomArrayListToken);
                break;

            default:
                System.out.println("Command Type Could Not Be Resolved");
                break;
        }
    }


}
