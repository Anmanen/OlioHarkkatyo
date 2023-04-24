package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.example.lutemon.R;
import com.example.lutemon.domain.Storage;

import java.util.ArrayList;
import java.util.List;

public class ColumnGraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_graph);

        AnyChartView anyChartView = findViewById(R.id.acwExperience);

        Cartesian columnChart = AnyChart.column();

        List<DataEntry> columnChartData = new ArrayList<>();

        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            columnChartData.add(new ValueDataEntry(lutemon.getName(), lutemon.getExperience()));
        });

        Column column = columnChart.column(columnChartData);

        columnChart.title("Kilpailijoiden kokemus");
        columnChart.xAxis(0).title("Kilpailija");
        columnChart.yAxis(0).title("Kokemus");

        anyChartView.setChart(columnChart);

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
}