package se.quizmaniacs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class LobbyMenu extends AppCompatActivity {

    TextView lobbyMenuNickTxt;
    String nickname;

    ScrollView lobbyMenuRoomsScrollView;

    Button lobbyMenuCreateBtn;
    Button lobbyMenuBackBtn;
    Button lobbyMenuJoinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nickname = User.nickname;
        setContentView(R.layout.activity_lobby_menu);

        lobbyMenuNickTxt = (TextView) findViewById(R.id.lobbyMenuNickTxt);
        lobbyMenuNickTxt.setText(nickname);


        lobbyMenuRoomsScrollView = (ScrollView) findViewById(R.id.lobbyMenuRoomsScrollView);


        lobbyMenuCreateBtn = (Button) findViewById(R.id.lobbyMenuCreateBtn);
        lobbyMenuCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lobbyCreateIntent = new Intent(LobbyMenu.this, CreateMenu.class);
                LobbyMenu.this.startActivity(lobbyCreateIntent);
            }
        });

        lobbyMenuJoinBtn = (Button) findViewById(R.id.lobbyMenuJoinBtn);
        lobbyMenuJoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lobbyMenuBackBtn = (Button) findViewById(R.id.lobbyMenuBackBtn);
        lobbyMenuBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
