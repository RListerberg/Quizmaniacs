package se.quizmaniacs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static se.quizmaniacs.R.id.mainMenuNickField;

public class MainMenu extends AppCompatActivity {

    Button mainMenuPlayBtn;
    EditText mainMenuNickField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mainMenuPlayBtn = (Button) findViewById(R.id.mainMenuPlayBtn);
        mainMenuNickField = (EditText) findViewById(R.id.mainMenuNickField);

        mainMenuPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainMenu.this, LobbyMenu.class);
                MainMenu.this.startActivity(myIntent);

                User.setNickname(mainMenuNickField.getText().toString());
            }
        });
    }
}
