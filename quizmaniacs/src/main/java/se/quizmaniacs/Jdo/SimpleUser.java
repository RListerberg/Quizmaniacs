package se.quizmaniacs.Jdo;

/**
 * Created by LeoAsp on 2017-02-13.
 */

public class SimpleUser {
    private String nickname;

    public SimpleUser(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}