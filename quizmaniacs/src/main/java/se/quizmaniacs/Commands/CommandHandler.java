package se.quizmaniacs.Commands;

import com.google.gson.Gson;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class CommandHandler {


    public String makeSetNickCommand(String nick) {
        Command command = new Command(CommandType.SETNICK, nick);
        String stringCommand = ("@" + new Gson().toJson(command));
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

}
