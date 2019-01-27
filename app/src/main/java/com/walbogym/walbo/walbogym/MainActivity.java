package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ServiceConfigurationError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureNextButton();
    }

    private void configureNextButton(){
        Button activityTrainingsplan = (Button)findViewById(R.id.trainingsplanbtn);
        Button activityStatistik = (Button)findViewById(R.id.statistikbtn);
        Button activityMotivation = (Button)findViewById(R.id.motivationbtn);

        activityTrainingsplan.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                startActivity(new Intent(MainActivity.this, trainignsplanActivity.class));
            }
        });
        activityStatistik.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, Statistik.class));
            }
        });
        activityMotivation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, activityMotivation.class));
            }
        });

    }
}
