package se.quizmaniacs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import se.quizmaniacs.Adapters.RoomAdapter;
import se.quizmaniacs.Controller.Controller;

public class RoomMenu extends AppCompatActivity {

    Button leaveBut;
    ToggleButton readyToggle;
    TextView roomNameTextView;

    ListView roomMenuPlayerListView;

    public ArrayAdapter playerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBank.roomMenu = this;
        setContentView(R.layout.activity_room_menu);


        leaveBut = (Button) findViewById(R.id.roomMenuLeaveBtn);
        readyToggle = (ToggleButton) findViewById(R.id.roomMenuReadyToggle);
        roomNameTextView = (TextView) findViewById(R.id.roomMenuTitleName);
        roomMenuPlayerListView = (ListView) findViewById(R.id.roomMenuPlayerListView);


        leaveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerLeaveCommand(DataBank.rooms.get(0)));

                } catch (IndexOutOfBoundsException e) {
                    Log.e("Couldn't get any rooms", e.getMessage(), e);
                }
                finish();
            }
        });

        readyToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isReady) {
                if (isReady) {
                    Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerReadyCommand());
                } else {
                    Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerNotReadyCommand());
                }
            }
        });


    }

    public void populatePlayerList() {
        // Create the adapter to convert the array to views
        playerAdapter = new RoomAdapter(this, DataBank.rooms);
        // Attach the adapter to a ListView
        roomMenuPlayerListView.setAdapter(playerAdapter);
    }


}
