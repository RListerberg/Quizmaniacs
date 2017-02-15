package se.quizmaniacs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import se.quizmaniacs.Adapters.RoomAdapter;
import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.Jdo.SimpleRoom;

public class LobbyMenu extends AppCompatActivity {

    TextView lobbyMenuNickTxt;
    String nickname;

    Button lobbyMenuCreateBtn;
    Button lobbyMenuBackBtn;
    Button lobbyMenuJoinBtn;

    SwipeRefreshLayout lobbyMenuSwipeRefresh;
    SimpleRoom selectedRoom;
    ListView listViewRooms;
    public ArrayAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBank.lobbyMenu = this;

        setContentView(R.layout.activity_lobby_menu);

        lobbyMenuNickTxt = (TextView) findViewById(R.id.lobbyMenuNickTxt);
        lobbyMenuNickTxt.setText(nickname);

        listViewRooms = (ListView) findViewById(R.id.lobbyMenuRoomListView);


        lobbyMenuCreateBtn = (Button) findViewById(R.id.lobbyMenuCreateBtn);

        populateRoomList();

        lobbyMenuCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LobbyMenu.this, CreateMenu.class);
                startActivity(myIntent);
            }
        });

        lobbyMenuJoinBtn = (Button) findViewById(R.id.lobbyMenuJoinBtn);
        lobbyMenuJoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerJoinCommand(selectedRoom));
                System.out.println("PLAYER JOINED: " + selectedRoom.getName());
            }
        });


        lobbyMenuBackBtn = (Button) findViewById(R.id.lobbyMenuBackBtn);
        lobbyMenuBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        listViewRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedRoom = (SimpleRoom) parent.getItemAtPosition(position);
            }
        });

        lobbyMenuSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.lobbyMenuSwipeRefresh);
        lobbyMenuSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Controller.getDataHandler().send(Controller.getCommandMaker().makeGetLobbyList());
                refreshRoomList();
                lobbyMenuSwipeRefresh.setRefreshing(false);
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

    public void refreshRoomList() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                populateRoomList();
                roomAdapter.notifyDataSetChanged();
            }
        });

    }
}
