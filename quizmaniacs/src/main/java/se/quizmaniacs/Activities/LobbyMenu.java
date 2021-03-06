package se.quizmaniacs.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import se.quizmaniacs.Data.DataBank;
import se.quizmaniacs.Jdo.SimpleRoom;
import se.quizmaniacs.R;

public class LobbyMenu extends AppCompatActivity {

    TextView lobbyMenuNickTxt;

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
                Controller.getDataHandler().send(Controller.getCommandMaker().makeGetLobbyList());
                if (selectedRoom != null) {
                    if (DataBank.rooms.size() > 0) {
                        if (selectedRoom.getUsers().size() < selectedRoom.getMaxPlayers()) {
                            startActivity(new Intent(LobbyMenu.this, RoomMenu.class));
                            Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerJoinCommand(selectedRoom));
                            Controller.getDataHandler().send(Controller.getCommandMaker().makeGetRoom(selectedRoom.getId()));
                            System.out.println("PLAYER JOINED: " + selectedRoom.getName());
                            selectedRoom = null;
                        }
                    }
                }
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
                view.setSelected(true);
            }
        });

        lobbyMenuSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.lobbyMenuSwipeRefresh);
        lobbyMenuSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshRoomList();
                new Handler().postDelayed(new Runnable(
                ) {
                    @Override
                    public void run() {
                        lobbyMenuSwipeRefresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        lobbyMenuNickTxt.setText(DataBank.nickname);
    }


    public void populateRoomList() {
        // Create the adapter to convert the array to views
        roomAdapter = new RoomAdapter(this, DataBank.rooms);
        // Attach the adapter to a ListView
        listViewRooms.setAdapter(roomAdapter);
    }

    public void refreshRoomList() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Controller.getDataHandler().send(Controller.getCommandMaker().makeGetLobbyList());
            }

        });
    }
}
