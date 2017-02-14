package se.quizmaniacs;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import se.quizmaniacs.Adapters.RoomAdapter;

public class LobbyMenu extends AppCompatActivity {

    TextView lobbyMenuNickTxt;
    String nickname;

    Button lobbyMenuCreateBtn;
    Button lobbyMenuBackBtn;
    Button lobbyMenuJoinBtn;

    ArrayAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_lobby_menu);

        lobbyMenuNickTxt = (TextView) findViewById(R.id.lobbyMenuNickTxt);
        lobbyMenuNickTxt.setText(nickname);


        lobbyMenuCreateBtn = (Button) findViewById(R.id.lobbyMenuCreateBtn);

        populateRoomList();

        lobbyMenuCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


    public void populateRoomList() {
// Create the adapter to convert the array to views
        roomAdapter = new RoomAdapter(this, DataBank.rooms);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lobbyMenuRoomListView);
        listView.setAdapter(roomAdapter);
    }
}
