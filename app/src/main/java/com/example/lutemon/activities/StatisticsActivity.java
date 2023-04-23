package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.axes.Linear;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScaleStackMode;
import com.example.lutemon.BattleField;
import com.example.lutemon.R;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

import com.anychart.AnyChart;

import java.util.ArrayList;
import java.util.List;


public class StatisticsActivity extends AppCompatActivity {

    private TextView battles;
    private TextView mostWins;

    private TextView mostDefeats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Cartesian barChart = AnyChart.bar();
        barChart.title("Kilpailijoiden voitot ja häviöt");
        barChart.yScale().stackMode(ScaleStackMode.VALUE);

        Linear xAxis = barChart.xAxis(0);
        xAxis.enabled(true);
        xAxis.orientation(Orientation.RIGHT);

        List<DataEntry> barChartData = new ArrayList<>();
        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            barChartData.add(new CustomDataEntry(lutemon.getName(), lutemon.getWins(), -(lutemon.getDefeats())));
        });

        Set set = Set.instantiate();
        set.data(barChartData);
        Mapping winsData = set.mapAs("{ x: 'x', value: 'wins' }");
        Mapping defeatsData = set.mapAs("{ x: 'x', value: 'defeats' }");

        Bar winsBar = barChart.bar(winsData);
        winsBar.name("Voitot");
        winsBar.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER);

        Bar defectsBar = barChart.bar(defeatsData);
        defectsBar.name("Häviöt");
        defectsBar.tooltip()
                .position("left")
                .anchor(Anchor.RIGHT_CENTER);

        barChart.legend().enabled(true);
        barChart.legend().inverted(true);
        barChart.legend().fontSize(13d);


        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.acwDefeatsWins);
        anyChartView.setChart(barChart);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuHome){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, int wins, int defeats) {
            super(x, wins);
            setValue("defeats", defeats);
    }
}

}