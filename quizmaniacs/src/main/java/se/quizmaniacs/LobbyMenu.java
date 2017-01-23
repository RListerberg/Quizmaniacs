package se.quizmaniacs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LobbyMenu extends AppCompatActivity {

    TextView lobbyMenuNickTxt;
    String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        nickname = intent.getExtras().get("nickname").toString();
        setContentView(R.layout.activity_lobby_menu);
        lobbyMenuNickTxt = (TextView) findViewById(R.id.lobbyMenuNickTxt);
        lobbyMenuNickTxt.setText(nickname);
    }
}
