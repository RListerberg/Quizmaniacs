package se.quizmaniacs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import se.quizmaniacs.Controller.Controller;

public class MainMenu extends AppCompatActivity {

    Button mainMenuPlayBtn;
    EditText mainMenuNickField;
    Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            controller = new Controller();
            new Thread(Controller.getConnectionHandler()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mainMenuPlayBtn = (Button) findViewById(R.id.mainMenuPlayBtn);
        mainMenuNickField = (EditText) findViewById(R.id.mainMenuNickField);

        mainMenuPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User.setNickname(mainMenuNickField.getText().toString());
                try {
                    Controller.getDataHandler().startThreads(Controller.getConnectionHandler().getSocket());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Controller.getDataHandler().send(Controller.getCommandMaker().makeSetNickCommand(User.nickname));
                Controller.getDataHandler().send(Controller.getCommandMaker().makeGetLobbyAct());

                Intent mainMenuIntent = new Intent(MainMenu.this, LobbyMenu.class);
                MainMenu.this.startActivity(mainMenuIntent);

            }
        });

    }
}
