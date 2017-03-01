package se.quizmaniacs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.R;

public class MainMenu extends AppCompatActivity {

    Button mainMenuPlayBtn;
    EditText mainMenuNickField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        new Thread(Controller.getConnectionHandler()).start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mainMenuPlayBtn = (Button) findViewById(R.id.mainMenuPlayBtn);
        mainMenuNickField = (EditText) findViewById(R.id.mainMenuNickField);

        mainMenuPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nick = mainMenuNickField.getText().toString();

                try {
                    Controller.getDataHandler().startThreads(Controller.getConnectionHandler().getSocket());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Controller.getDataHandler().send(Controller.getCommandMaker().makeSetNickCommand(nick));
                Controller.getDataHandler().send(Controller.getCommandMaker().makeGetLobbyList());
                startActivity(new Intent(MainMenu.this, LobbyMenu.class));
            }
        });

    }
}
