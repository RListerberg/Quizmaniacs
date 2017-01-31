package se.quizmaniacs.Commands;

/**
 * Created by LeoAsp on 2017-01-30.
 */

public class Command {
    CommandType type;
    String data;

    public Command(CommandType type, String data) {
        this.type = type;
        this.data = data;
    }
}
