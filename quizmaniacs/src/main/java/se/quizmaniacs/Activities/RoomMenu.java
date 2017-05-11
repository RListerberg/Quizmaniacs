package se.quizmaniacs.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import se.quizmaniacs.Adapters.PlayerAdapter;
import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.Data.DataBank;
import se.quizmaniacs.R;

public class RoomMenu extends AppCompatActivity {

    Button leaveBut;
    Button sendBtn;
    ToggleButton readyToggle;
    TextView roomNameTextView;
    EditText roomMenuEditText;

    ListView roomMenuPlayerListView;

    public ArrayAdapter playerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBank.roomMenu = this;

        setContentView(R.layout.activity_room_menu);


        leaveBut = (Button) findViewById(R.id.roomMenuLeaveBtn);
        sendBtn = (Button) findViewById(R.id.roomMenuSendBtn);
        readyToggle = (ToggleButton) findViewById(R.id.roomMenuReadyToggle);
        roomNameTextView = (TextView) findViewById(R.id.roomMenuTitleName);
        roomMenuPlayerListView = (ListView) findViewById(R.id.roomMenuPlayerListView);
        roomMenuEditText = (EditText) findViewById(R.id.roomMenuEditText);
        populatePlayerList();


        leaveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitConfirmDialog();
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

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = roomMenuEditText.getText().toString();
                Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerSendMessageCommand(message));
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showExitConfirmDialog();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void populatePlayerList() {
        // Create the adapter to convert the array to views
        playerAdapter = new PlayerAdapter(this, DataBank.players);
        // Attach the adapter to a ListView
        roomMenuPlayerListView.setAdapter(playerAdapter);
    }

    public void addMessageToView(String message){
        roomMenuEditText.append(message);
    }

    public void showExitConfirmDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Leave?"); // set title
        dialog.setMessage("Are you sure you want to leave?");
        dialog.setPositiveButton("Leave",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            for (int i = 0; i < DataBank.rooms.size(); i++) {
                                for (int j = 0; j < DataBank.rooms.get(i).getUsers().size(); j++) {
                                    if (DataBank.rooms.get(i).getUsers().get(j).getPortNr() == DataBank.portNr) {
                                        Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerLeaveCommand(DataBank.rooms.get(i)));
                                        finish();
                                        Toast.makeText(getBaseContext(), "You have left the room", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        } catch (IndexOutOfBoundsException e) {
                            Log.e("Couldn't get any rooms", e.getMessage(), e);
                        }
                    }
                });
        dialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("inRoom", "user choose to stay");
                    }
                });
        dialog.create().show();
    }


}
