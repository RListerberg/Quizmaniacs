package se.quizmaniacs.Data;

import java.util.ArrayList;

import se.quizmaniacs.Activities.LobbyMenu;
import se.quizmaniacs.Activities.RoomMenu;
import se.quizmaniacs.Jdo.SimpleRoom;
import se.quizmaniacs.Jdo.SimpleUser;


public class DataBank {
    public static ArrayList<SimpleRoom> rooms = new ArrayList<>();
    public static ArrayList<SimpleUser> players = new ArrayList<>();
    public static String nickname = "";
    public static String roomName = "";
    public static LobbyMenu lobbyMenu;
    public static RoomMenu roomMenu;
    public static int portNr;

}
