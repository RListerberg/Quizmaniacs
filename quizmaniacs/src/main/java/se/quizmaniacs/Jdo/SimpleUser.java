package se.quizmaniacs.Jdo;


public class SimpleUser {
    private String nickname;
    private int portNr;
    private PlayerData playerData;

    public SimpleUser(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPortNr() {
        return portNr;
    }

    public void setPortNr(int portNr) {
        this.portNr = portNr;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public void setPlayerData(PlayerData playerData) {
        this.playerData = playerData;
    }
}
