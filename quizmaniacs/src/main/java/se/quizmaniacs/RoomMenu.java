package se.quizmaniacs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import se.quizmaniacs.Controller.Controller;

public class RoomMenu extends AppCompatActivity {

    Button leaveBut;
    Button readyBut;
    RadioGroup radioButGroup;
    RadioButton radioButton;
    TextView roomNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBank.roomMenu = this;
        setContentView(R.layout.activity_room_menu);



        leaveBut = (Button) findViewById(R.id.roomMenuLeaveBtn);
        readyBut = (Button) findViewById(R.id.roomMenuReadyBtn);
        radioButGroup = (RadioGroup) findViewById(R.id.roomMenuRadioGroup);
        radioButton = (RadioButton) findViewById(R.id.roomMenuRadioBut);
        roomNameTextView = (TextView) findViewById(R.id.roomMenuTitleName);




        leaveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerLeaveCommand(DataBank.rooms.get(0)));

                }catch (IndexOutOfBoundsException e){
                    Log.e("Couldn't get any rooms", e.getMessage(), e);
                }
                finish();
            }
        });

        readyBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Controller.getDataHandler().send(Controller.getCommandMaker().makePlayerReadyCommand());

            }
        });


    }


}
