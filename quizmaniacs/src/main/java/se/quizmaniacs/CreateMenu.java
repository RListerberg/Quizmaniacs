package se.quizmaniacs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import se.quizmaniacs.Controller.Controller;

public class CreateMenu extends AppCompatActivity {

    private Integer[] arraySpinner;
    private Button createMenuCreateBtn;
    private Button createMenuCancelBtn;
    private EditText createMenuEditTxt;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_menu);

        this.arraySpinner = new Integer[]{
                4, 5, 6
        };

        createMenuCreateBtn = (Button) findViewById(R.id.createMenuCreateBtn);
        createMenuCreateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            createRoom();
            }
        });

        createMenuCancelBtn = (Button) findViewById(R.id.createMenuCancelBtn);
        createMenuCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        createMenuEditTxt = (EditText) findViewById(R.id.createMenuRoomNameField);

        spinner = (Spinner) findViewById(R.id.createMenuMaxPlayersSpinner);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);

    }

    private void createRoom() {

        int maxPlayers = Integer.parseInt(spinner.getSelectedItem().toString());



        Controller.getDataHandler().send(Controller.getCommandMaker().makeCreateRoomCommand(new Room(createMenuEditTxt.getText().toString(), maxPlayers)));



        Intent voteCategoryIntent = new Intent(CreateMenu.this, VoteCategory.class);
        CreateMenu.this.startActivity(voteCategoryIntent);

    }

}
