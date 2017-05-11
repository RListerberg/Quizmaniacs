package se.quizmaniacs.Commands;

import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import se.quizmaniacs.Data.DataBank;
import se.quizmaniacs.Data.Parser;
import se.quizmaniacs.Jdo.SimpleRoom;
import se.quizmaniacs.Jdo.SimpleUser;
import se.quizmaniacs.R;

/**
 * Created by LeoAsp on 2017-02-07.
 */


public class CommandHandler {
    Parser parser;
    Gson gson = new Gson();

    public CommandHandler() {
        parser = new Parser();
    }

    public void handle(String message) {
        Command command = parser.parse(message);
        switch (command.type) {
            case UPDATELOBBYLIST:
                System.out.println("RECEIVED: " + command.type);
                Type roomArrayListToken = new TypeToken<ArrayList<SimpleRoom>>() {
                }.getType();
                System.out.println(command.data);
                DataBank.rooms = gson.fromJson(command.data, roomArrayListToken);
                refreshLobbyList();
                break;
            case UPDATEROOMPLAYERLIST:
                System.out.println("RECEIVED: " + command.type);
                Type playerArrayListToken = new TypeToken<ArrayList<SimpleUser>>() {
                }.getType();
                System.out.println(command.data);
                DataBank.players = gson.fromJson(command.data, playerArrayListToken);
                refreshRoomPlayerList();
            case UPDATENICK:
                System.out.println("RECEIVED: " + command.type);
                DataBank.nickname = command.data;
                refreshNickName();
                System.out.println("Nickname = " + command.data);
                break;
            case UPDATEROOM:
                System.out.println("RECEIVED: " + command.type);
                System.out.println("Nickname = " + command.data);
                SimpleRoom room = gson.fromJson(command.data, SimpleRoom.class);
                DataBank.roomName = room.getName();
                refreshRoomName();
                break;
            case UPDATEROOMNAME:
                System.out.println("RECEIVED: " + command.type);
                DataBank.roomName = command.data;
                Log.d("UPDATEROOMNAME: ", command.data);
                refreshRoomName();
                break;
            case PLAYERJOIN:
                System.out.println("RECEIVED: " + command.type);
                break;
            case SENDMESSAGE:
                System.out.println("RECEIVED: " + command.type);
                addMessageToPlayerChat(command.data);
            default:
                System.out.println("Command Type Could Not Be Resolved");
                break;
        }
    }

    public void refreshNickName() {
        DataBank.lobbyMenu.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView lobbymenuNickTxt = (TextView) DataBank.lobbyMenu.findViewById(R.id.lobbyMenuNickTxt);
                lobbymenuNickTxt.setText(DataBank.nickname);
            }
        });
    }

    public void refreshLobbyList() {
        DataBank.lobbyMenu.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DataBank.lobbyMenu.roomAdapter.clear();
                DataBank.lobbyMenu.roomAdapter.addAll(DataBank.rooms);
                DataBank.lobbyMenu.roomAdapter.notifyDataSetChanged();
            }
        });
    }

    public void refreshRoomPlayerList() {
        DataBank.roomMenu.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DataBank.roomMenu.playerAdapter.clear();
                DataBank.roomMenu.playerAdapter.addAll(DataBank.players);
                DataBank.roomMenu.playerAdapter.notifyDataSetChanged();
            }
        });

    }

    public void refreshRoomName() {
        DataBank.roomMenu.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView roomName = (TextView) DataBank.roomMenu.findViewById(R.id.roomMenuTitleName);
                roomName.setText(DataBank.roomName);
            }
        });
    }

    public void addMessageToPlayerChat(final String message) {
        DataBank.roomMenu.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DataBank.roomMenu.addMessageToView(message);
            }
        });

    }


}
