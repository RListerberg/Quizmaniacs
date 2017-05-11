package se.quizmaniacs.Commands;

import com.google.gson.Gson;

import se.quizmaniacs.Jdo.SimpleRoom;


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

    public String makeGetLobbyList() {
        Command command = new Command(CommandType.GETLOBBYLIST, "");
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

    public String makeGetRoom(int roomId) {
        Command command = new Command(CommandType.GETROOM, roomId + "");
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makeCreateRoomCommand(SimpleRoom room) {
        String jsonData = gson.toJson(room);
        Command command = new Command(CommandType.CREATEROOM, jsonData);
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makePlayerReadyCommand() {
        Command command = new Command(CommandType.PLAYERREADY, "");
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makePlayerNotReadyCommand() {
        Command command = new Command(CommandType.PLAYERNOTREADY, "");
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makePlayerLeaveCommand(SimpleRoom room) {
        String jsonData = gson.toJson(room);
        Command command = new Command(CommandType.PLAYERLEAVE, jsonData);
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makePlayerJoinCommand(SimpleRoom room) {
        String jsonData = gson.toJson(room);
        Command command = new Command(CommandType.PLAYERJOIN, jsonData);
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

    public String makePlayerSendMessageCommand(String message) {
        Command command = new Command(CommandType.PLAYERSENDMESSAGE, message);
        String stringCommand = gson.toJson(command);
        System.out.println("MADE: " + stringCommand);
        return stringCommand;
    }

}
