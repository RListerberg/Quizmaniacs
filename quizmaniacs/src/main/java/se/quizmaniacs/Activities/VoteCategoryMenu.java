package se.quizmaniacs.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.quizmaniacs.Controller.Controller;
import se.quizmaniacs.R;

public class VoteCategoryMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_category);

        final GridView gridView = (GridView) findViewById(R.id.VoteCategoryGridView);
        Button voteBtn = (Button) findViewById(R.id.voteBtn);

        List<String> databaseCategories = new ArrayList();

// String that populates our gridview
        final String[] categories = new String[]{
                "Geography",
                "DC comics",
                "Marvel",
                "Philosophy",
                "Crime",
                "Harry Potter"
        };


        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1);
        try {

            new Thread(Controller.getConnectionHandler()).start();
            // Sends command to the server
            Controller.getDataHandler().startThreads(Controller.getConnectionHandler().getSocket());
            Controller.getDataHandler().send(Controller.getCommandMaker().makeGetCategoriesCommand());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("makeGetCategoriesCommand, failed!");
        }

        gridViewArrayAdapter.addAll(categories);

        gridView.setAdapter(gridViewArrayAdapter);

        voteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Sending votes to counter!");
            }
        });


    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            System.out.println("Position: " + position);
            System.out.println("ID: " + id);
            System.out.println("CategoryName: " + parent.getItemAtPosition(position));

        }
    });

    }
}