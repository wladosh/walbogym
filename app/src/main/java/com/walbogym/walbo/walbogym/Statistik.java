package com.walbogym.walbo.walbogym;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static com.walbogym.walbo.walbogym.R.drawable.texboxstatistik;

public class Statistik extends AppCompatActivity {

    public boolean itemselected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);

        configurecombobox();
    }

    private void configurecombobox(){

        Spinner plancombobox = (Spinner)findViewById(R.id.plancombobox);

        final SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);

        final String trainingsplan1 = myprefs.getString("Trainingsplan1name", "");
        String trainingsplan2 = myprefs.getString("Trainingsplan2name", "");
        String trainingsplan3 = myprefs.getString("Trainingsplan3name", "");
        String trainingsplan4 = myprefs.getString("Trainingsplan4name", "");
        String trainingsplan5 = myprefs.getString("Trainingsplan5name", "");

        List<String> trainingsplanarray =  new ArrayList<String>();
        if (myprefs.contains("Trainingsplan1name"))
            trainingsplanarray.add(myprefs.getString("Trainingsplan1name", ""));
        if (myprefs.contains("Trainingsplan2name"))
            trainingsplanarray.add(myprefs.getString("Trainingsplan2name", ""));
        if (myprefs.contains("Trainingsplan3name"))
            trainingsplanarray.add(myprefs.getString("Trainingsplan3name", ""));
        if (myprefs.contains("Trainingsplan4name"))
            trainingsplanarray.add(myprefs.getString("Trainingsplan4name", ""));
        if (myprefs.contains("Trainingsplan5name"))
            trainingsplanarray.add(myprefs.getString("Trainingsplan5name", ""));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, trainingsplanarray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plancombobox.setAdapter(adapter);

        final String selectedTP = plancombobox.getSelectedItem().toString();

        plancombobox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //itemselected = true;
                Spinner einheitcombobox = (Spinner)findViewById(R.id.einheitcombobox);
                einheitcombobox.setBackground(getDrawable(R.drawable.texboxstatistik));
                int trainingsplan = 0;
                for (int i = 1; i < 6; i++){ //bekomme den aktuellen trainingsplan als nummer, da die Einheiten auch als nummer gespeichert sind
                    if (selectedTP.equals(myprefs.getString("Trainingsplan"+i+"name", ""))) {
                        trainingsplan = i;
                        break;
                    }
                }

                ArrayList<String> einheitenarray =  new ArrayList<String>();
                if(myprefs.contains("Trainingsplan"+trainingsplan+"Einheit1"))
                    einheitenarray.add(myprefs.getString("Trainingsplan"+trainingsplan+"Einheit1", ""));
                if(myprefs.contains("Trainingsplan"+trainingsplan+"Einheit2"))
                    einheitenarray.add(myprefs.getString("Trainingsplan"+trainingsplan+"Einheit2", ""));
                if(myprefs.contains("Trainingsplan"+trainingsplan+"Einheit3"))
                    einheitenarray.add(myprefs.getString("Trainingsplan"+trainingsplan+"Einheit3", ""));
                if(myprefs.contains("Trainingsplan"+trainingsplan+"Einheit4"))
                    einheitenarray.add(myprefs.getString("Trainingsplan"+trainingsplan+"Einheit4", ""));

                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Statistik.this, R.layout.spinner_item, einheitenarray);
                einheitcombobox.setAdapter(adapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                return;
            }
        });
    }
}
