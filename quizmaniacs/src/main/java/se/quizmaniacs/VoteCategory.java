package se.quizmaniacs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VoteCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_category);

        final GridView gridView = (GridView) findViewById(R.id.VoteCategoryGridView);
        Button voteBtn = (Button) findViewById(R.id.voteBtn);

        final String[] categories = new String[]{
                "Geography",
                "DC comics",
                "Marvel",
                "Philosophy",
                "Crime",
                "Harry Potter"
        };

        final List<String> categoryList = new ArrayList<String>(Arrays.asList(categories));

        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1);

        gridViewArrayAdapter.addAll(categories);

        gridView.setAdapter(gridViewArrayAdapter);

        voteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("Sending votes to counter!");
            }
        });

//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                System.out.println(gridView.getSelectedItem());
//
//            }
//        });

    }
}