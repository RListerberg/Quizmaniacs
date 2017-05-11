package se.quizmaniacs.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import se.quizmaniacs.Fragments.InGameAnswersFragment;
import se.quizmaniacs.Fragments.InGameQuestionFragment;
import se.quizmaniacs.R;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        InGameQuestionFragment f1 = new InGameQuestionFragment();
        InGameAnswersFragment f2 = new InGameAnswersFragment();


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.inGameFrameTop, f1);
        ft.add(R.id.inGameFrameBot, f2);

        ft.commit();
    }


    public void changeToQuestionView() {
        InGameQuestionFragment f1 = new InGameQuestionFragment();
        InGameAnswersFragment f2 = new InGameAnswersFragment();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
    }
}
