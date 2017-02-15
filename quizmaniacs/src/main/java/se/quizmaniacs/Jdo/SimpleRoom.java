package se.quizmaniacs.Jdo;

import java.util.List;

/**
 * Created by LeoAsp on 2017-02-13.
 */

public class SimpleRoom {
    int id;
    String name;
    int connectedPlayers;
    int maxPlayers;
    List<String> categories;

    public SimpleRoom(String name, int maxPlayers) {
        this.name = name;
        this.connectedPlayers = 0;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConnectedPlayers() {
        return connectedPlayers;
    }

    public void setConnectedPlayers(int connectedPlayers) {
        this.connectedPlayers = connectedPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
