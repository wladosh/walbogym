package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class trainignsplanActivity extends AppCompatActivity {

    String trainignsplanName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainignsplan);

        confiureButtons();

        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);
        TextView text = (TextView)findViewById(R.id.Trainingsplantxt);
        if(myprefs.contains("Trainingsplan1name") || myprefs.contains("Trainingsplan2name") || myprefs.contains("Trainingsplan3name")|| myprefs.contains("Trainingsplan4name")|| myprefs.contains("Trainingsplan5name")){
            text.setText("Wähle einen von den unten stehenden Trainingsplänen aus, oder erstelle einen neuen.");
            Trainingspläne();
        }
        else{
            text.setText("Du musst erst einmal einen Trainingsplan erstellen");
        }
    }

    private void confiureButtons() {
        Button selbsterstellen = (Button) findViewById(R.id.erstellenbtn);

        selbsterstellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txbName = (EditText) findViewById(R.id.nametxb);
                trainignsplanName = txbName.getText().toString(); //Name vom Traingsplan

                SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);
                SharedPreferences.Editor editor = myprefs.edit();

                if (myprefs.contains("Trainingsplan1name") && myprefs.contains("Trainingsplan2name") && myprefs.contains("Trainingsplan3name") && myprefs.contains("Trainingsplan4name") && myprefs.contains("Trainingsplan5name"))
                {
                    Toast.makeText(trainignsplanActivity.this, "Du kannst nur maximal 5 Trainingspläne haben.", Toast.LENGTH_SHORT).show();
                }

                    for(int i=1; i<6; i++) {
                    if(!myprefs.contains("Trainingsplan"+i+"name")){
                        editor.putString("Trainingsplan"+i+"name", trainignsplanName);
                        Trainingsplan_Einheiten.aktuellerTrainingsplan = i;
                        editor.apply();
                        break;
                    }
                }

                editor.apply();

                startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
            }
        });
    }


    private void Trainingspläne() {
        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);

            LinearLayout TrainingsplanLayout = (LinearLayout) findViewById(R.id.LayoutTrainingsplänebearbeiten);
            TextView text = (TextView) findViewById(R.id.Trainingsplantxt);

            TextView infotext = new TextView(this);
            infotext.setText("Deine Trainingspläne:");
            infotext.setHeight(10);
            TrainingsplanLayout.addView(infotext);

            if (myprefs.contains("Trainingsplan1name")){
                Button trainingsplan1 = new Button(this);
                trainingsplan1.setText(myprefs.getString("Trainingsplan1name", "default"));
                TrainingsplanLayout.addView(trainingsplan1);

                trainingsplan1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                        Trainingsplan_Einheiten.aktuellerTrainingsplan = 1;
                    }
                });
            }
        if (myprefs.contains("Trainingsplan2name")){
            Button trainingsplan2 = new Button(this);
            trainingsplan2.setText(myprefs.getString("Trainingsplan2name", "default"));
            TrainingsplanLayout.addView(trainingsplan2);

            trainingsplan2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 2;
                }
            });
        }
        if (myprefs.contains("Trainingsplan3name")){
            Button trainingsplan3 = new Button(this);
            trainingsplan3.setText(myprefs.getString("Trainingsplan3name", "default"));
            TrainingsplanLayout.addView(trainingsplan3);

            trainingsplan3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 3;
                }
            });
        }
        if (myprefs.contains("Trainingsplan4name")){
            Button trainingsplan4 = new Button(this);
            trainingsplan4.setText(myprefs.getString("Trainingsplan4name", "default"));
            TrainingsplanLayout.addView(trainingsplan4);

            trainingsplan4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 4;
                }
            });
        }
        if (myprefs.contains("Trainingsplan5name")){
            Button trainingsplan5 = new Button(this);
            trainingsplan5.setText(myprefs.getString("Trainingsplan5name", "default"));
            TrainingsplanLayout.addView(trainingsplan5);

            trainingsplan5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 5;
                }
            });
        }


    }
}
