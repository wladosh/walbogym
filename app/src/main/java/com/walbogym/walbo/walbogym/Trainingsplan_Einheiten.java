package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Trainingsplan_Einheiten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan__einheiten);

        confiureButtons();

        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);
        String trainingsplanName = myprefs.getString("Trainingsplan1name", "Default");
        ((TextView)findViewById(R.id.Trainingsplannametxt)).setText(trainingsplanName); //Name des Trainingsplans

        //Benennung der Einheiten, sofern sie vergeben wurden
        if(myprefs.contains("Trainingsplan1Einheit1")){
            EditText einheit1name = (EditText)findViewById(R.id.einheit1txb);
            einheit1name.setText(myprefs.getString("Trainingsplan1Einheit1", "name"));
        }
        if(myprefs.contains("Trainingsplan1Einheit2")){
            EditText einheit2name = (EditText)findViewById(R.id.einheit2txb);
            einheit2name.setText(myprefs.getString("Trainingsplan1Einheit2", "name"));
        }
        if(myprefs.contains("Trainingsplan1Einheit3")){
            EditText einheit3name = (EditText)findViewById(R.id.einheit3txb);
            einheit3name.setText(myprefs.getString("Trainingsplan1Einheit3", "name"));
        }
        if(myprefs.contains("Trainingsplan1Einheit4")){
            EditText einheit4name = (EditText)findViewById(R.id.einheit4txb);
            einheit4name.setText(myprefs.getString("Trainingsplan1Einheit4", "name"));
        }

    }

    private void confiureButtons(){
        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);
        final SharedPreferences.Editor editor = myprefs.edit();


        final EditText einheit1name = (EditText)findViewById(R.id.einheit1txb);
        final EditText einheit2name = (EditText)findViewById(R.id.einheit2txb);
        final EditText einheit3name = (EditText)findViewById(R.id.einheit3txb);
        final EditText einheit4name = (EditText)findViewById(R.id.einheit4txb);

        Button einheit1 = (Button)findViewById(R.id.einheit1add);
        Button einheit2 = (Button)findViewById(R.id.einheit2add);
        Button einheit3 = (Button)findViewById(R.id.einheit3add);
        Button einheit4 = (Button)findViewById(R.id.einheit4add);
        einheit1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selbsterstellen.Einheit = 1;
                startActivity(new Intent(Trainingsplan_Einheiten.this, selbsterstellen.class));
                editor.putString("Trainingsplan1Einheit1", einheit1name.getText().toString());
                editor.apply();
            }
        });
        einheit2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selbsterstellen.Einheit = 2;
                startActivity(new Intent(Trainingsplan_Einheiten.this, selbsterstellen.class));
                editor.putString("Trainingsplan1Einheit2", einheit2name.getText().toString());
                editor.apply();
            }
        });
        einheit3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selbsterstellen.Einheit = 3;
                startActivity(new Intent(Trainingsplan_Einheiten.this, selbsterstellen.class));
                editor.putString("Trainingsplan1Einheit3", einheit3name.getText().toString());
                editor.apply();
            }
        });
        einheit4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selbsterstellen.Einheit = 3;
                startActivity(new Intent(Trainingsplan_Einheiten.this, selbsterstellen.class));
                editor.putString("Trainingsplan1Einheit4", einheit4name.getText().toString());
                editor.apply();
            }
        });
    }
}
