package se.quizmaniacs.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import se.quizmaniacs.Jdo.SimpleCategory;
import se.quizmaniacs.R;

public class QuestionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_menu);

        PieChart pieChart = (PieChart) findViewById(R.id.questionMenuPieChart);


        List<PieEntry> pieSizes = new ArrayList<PieEntry>();
        pieSizes.add(new PieEntry(20f, "Marvel"));
        pieSizes.add(new PieEntry(20f, "Harry potter"));
        pieSizes.add(new PieEntry(20f, "1945"));
        pieSizes.add(new PieEntry(20f, "Asgard"));
        pieSizes.add(new PieEntry(20f, "Penguins"));
        pieSizes.add(new PieEntry(20f, "Underground"));


        PieDataSet set = new PieDataSet(pieSizes, "Categories");

        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData data = new PieData(set);
        data.setDrawValues(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.setData(data);
        pieChart.invalidate();
    }

}
