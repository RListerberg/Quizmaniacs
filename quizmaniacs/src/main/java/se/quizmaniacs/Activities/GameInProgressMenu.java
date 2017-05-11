package se.quizmaniacs.Activities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import se.quizmaniacs.Adapters.PlayerInGameAdapter;
import se.quizmaniacs.ColorTemplateBasic;
import se.quizmaniacs.Data.DataBank;
import se.quizmaniacs.Jdo.SimpleUser;
import se.quizmaniacs.R;
import se.quizmaniacs.RectangleView;

public class GameInProgressMenu extends AppCompatActivity {

    public static float startSpin = 0f;
    final int nrOfCategories = 5;
    Paint curPaint;
    RectangleView rectView;
    PlayerInGameAdapter playerAdapter;
    GridView playerGrid;
    ArrayList<Rect> rectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameinprogress_menu);
        rectList = new ArrayList<>();
        playerGrid = (GridView) findViewById(R.id.playerGridView);
        rectView = new RectangleView(getBaseContext());
        curPaint = new Paint();

        populatePlayerList();


        final PieChart pieChart = (PieChart) findViewById(R.id.questionMenuPieChart);
        Legend pieChartLegend = pieChart.getLegend();


        float purpleSixth = 1 / 6f;
        float greenSixth = 1 / 6f;
        float yellowSixth = 1 / 6f;
        float orangeSixth = 1 / 6f;
        float redSixth = 1 / 6f;
        float blueSixth = 1 / 6f;


        final List<PieEntry> pieSizes = new ArrayList<PieEntry>();
        pieSizes.add(new PieEntry(greenSixth, "Marvel"));
        pieSizes.add(new PieEntry(yellowSixth, "Harry potter"));
        pieSizes.add(new PieEntry(orangeSixth, "1945"));
        pieSizes.add(new PieEntry(blueSixth, "Asgard"));
        pieSizes.add(new PieEntry(redSixth, "Penguins"));
        pieSizes.add(new PieEntry(purpleSixth, "Underground"));


        PieDataSet set = new PieDataSet(pieSizes, "");


        set.setColors(ColorTemplateBasic.VORDIPLOM_COLORS);

        final PieData pieData = new PieData(set);

        pieChartLegend.setWordWrapEnabled(true);
        pieChart.getDescription().setEnabled(false);
        pieData.setDrawValues(false);

        pieChart.setRotationEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.setData(pieData);
        pieChart.invalidate();


        Button spinBut = (Button) findViewById(R.id.spinBut);
        spinBut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                System.out.println("StartSpin before minus: " + startSpin);

                if (startSpin >= 360f) {
                    startSpin = startSpin - 360f;
                }

                int randomPie = pieData.getDataSet().getEntryIndex(pieSizes.get(new Random().nextInt(5)));

                float changeSpin = (60f * randomPie);
                float endSpin = 360f;

                System.out.println("StartSpin after minus:  " + startSpin);


                pieChart.spin(3000, startSpin, changeSpin, Easing.EasingOption.EaseOutBack);


                int currentPiece = Math.round(changeSpin / 60f);

                System.out.println("Math.round: " + currentPiece);

                System.out.println("CurrentPieceLBL: " + pieSizes.get(currentPiece).getLabel());

//              startSpin = changeSpin;

                System.out.println("StartSpin after plus:  " + startSpin);

            }
        });
    }

    private void populatePlayerList() {


        DataBank.players.add(0, new SimpleUser("Player 1"));
        DataBank.players.add(1, new SimpleUser("Player 2"));
        DataBank.players.add(2, new SimpleUser("Player 3"));
        DataBank.players.add(3, new SimpleUser("Player 4"));
        DataBank.players.add(4, new SimpleUser("Player 5"));
        DataBank.players.add(5, new SimpleUser("Player 6"));
        // Create the adapter to convert the array to views
        playerAdapter = new PlayerInGameAdapter(this, DataBank.players);
        // Attach the adapter to a ListView
        playerGrid.setAdapter(playerAdapter);
    }


    private void drawCategoryRects(){

        for (int i = 0; i < rectView.getCategoryRectList().size() ; i++) {
            for (int j = 0; j < rectView.getColorIntList().size(); j++) {

                curPaint.setColor(rectView.getColorIntList().get(j));
                new Canvas().drawRect(rectView.getCategoryRectList().get(i), curPaint);

            }
        }
    }

}
