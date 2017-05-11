package se.quizmaniacs.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import se.quizmaniacs.Adapters.PlayerAdapter;
import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.Data.DataBank;
import se.quizmaniacs.R;

public class ChatRoom extends AppCompatActivity {

    public ArrayAdapter playerAdapter;

    Button sendButton;
    EditText messageSendEditText;
    TextView chatRoomTextView;
    ListView chatRoomPlayerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);


        sendButton = (Button) findViewById(R.id.sendButton);
        messageSendEditText = (EditText) findViewById(R.id.messageSendEditText);
        chatRoomTextView = (TextView) findViewById(R.id.chatRoomTextView);
        chatRoomPlayerListView = (ListView) findViewById(R.id.chatRoomListView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageSendEditText.getText().toString();
                Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerSendMessageCommand(message));
            }
        });

    }


    public void populatePlayerList() {
        // Create the adapter to convert the array to views
        playerAdapter = new PlayerAdapter(this, DataBank.players);
        // Attach the adapter to a ListView
        chatRoomPlayerListView.setAdapter(playerAdapter);
    }


}
