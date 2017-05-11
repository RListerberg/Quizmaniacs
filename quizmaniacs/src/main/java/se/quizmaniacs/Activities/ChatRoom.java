package se.quizmaniacs.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import se.quizmaniacs.R;

public class ChatRoom extends AppCompatActivity {

    Button sendButton;
    EditText messageSendEditText;
    TextView chatRoomTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);


        sendButton = (Button) findViewById(R.id.sendButton);
        messageSendEditText = (EditText) findViewById(R.id.messageSendEditText);
        chatRoomTextView = (TextView) findViewById(R.id.chatRoomTextView);


    }





}
