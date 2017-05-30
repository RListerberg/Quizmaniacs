package se.quizmaniacs.Data;

import com.google.gson.Gson;

import se.quizmaniacs.Commands.Command;


public class Parser {
    Gson gson = new Gson();

    public Command parse(String message) {
        Command command = gson.fromJson(message, Command.class);
        return command;
    }
}
