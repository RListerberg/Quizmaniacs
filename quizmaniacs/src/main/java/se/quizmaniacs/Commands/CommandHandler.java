package se.quizmaniacs.Commands;

import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import se.quizmaniacs.Data.Parser;
import se.quizmaniacs.DataBank;
import se.quizmaniacs.Jdo.SimpleRoom;
import se.quizmaniacs.R;

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
            case UPDATELOBBYLIST:
                System.out.println("RECIEVIED: " + command.type);
                Type roomArrayListToken = new TypeToken<ArrayList<SimpleRoom>>() {
                }.getType();
                System.out.println(command.data);
                DataBank.rooms = new Gson().fromJson(command.data, roomArrayListToken);
                break;
            case UPDATENICK:
                System.out.println("RECIEVED: " + command.type);
                DataBank.nickname = command.data;
                DataBank.lobbyMenu.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView nick = (TextView) DataBank.lobbyMenu.findViewById(R.id.lobbyMenuNickTxt);
                        nick.setText(DataBank.nickname);
                    }
                });

                System.out.println("Nickname = " + command.data);
                break;

            default:
                System.out.println("Command Type Could Not Be Resolved");
                break;
        }
    }


}
