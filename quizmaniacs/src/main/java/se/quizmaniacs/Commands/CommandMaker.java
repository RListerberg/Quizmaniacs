package se.quizmaniacs.Commands;

import com.google.gson.Gson;

import se.quizmaniacs.Room;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class CommandMaker {
    Gson gson = new Gson();

    public CommandMaker() {
    }

    public String makeSetNickCommand(String nick) {
        Command command = new Command(CommandType.SETNICK, nick);
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makeGetLobbyAct() {
        Command command = new Command(CommandType.GETLOBBYACT, "");
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makeGetCategoriesCommand() {
        Command command = new Command(CommandType.GETCATEGORIES, "");
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makeCreateRoomCommand(Room room) {
        Command command = new Command(CommandType.CREATEROOM, room.toString());
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

}
