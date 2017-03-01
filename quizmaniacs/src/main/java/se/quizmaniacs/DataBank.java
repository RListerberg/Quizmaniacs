package se.quizmaniacs;

import java.util.ArrayList;

import se.quizmaniacs.Jdo.SimpleRoom;
import se.quizmaniacs.Jdo.SimpleUser;

/**
 * Created by LeoAsp on 2017-02-13.
 */

public class DataBank {
    public static ArrayList<SimpleRoom> rooms = new ArrayList<>();
    public static ArrayList<SimpleUser> players = new ArrayList<>();
    public static String nickname = "";
    public static String roomName = "";
    public static LobbyMenu lobbyMenu;
    public static RoomMenu roomMenu;

}
