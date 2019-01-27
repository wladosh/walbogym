package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trainignsplanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainignsplan);

        confiureButtons();
    }

    private void confiureButtons(){
        Button selbsterstellen = (Button)findViewById(R.id.trainingsplanbtn);
        selbsterstellen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(trainignsplanActivity.this, selbsterstellen.class));
            }
        });
    }
}
