package se.quizmaniacs.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import se.quizmaniacs.Fragments.VoteCategoryFragment;
import se.quizmaniacs.R;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        VoteCategoryFragment voteCat = new VoteCategoryFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.activity_game_menu,voteCat,"voteCat");
        ft.commit();

    }
}
