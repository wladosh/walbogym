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
        if(myprefs.contains("Trainingsplan1name")){
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

                SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);
                SharedPreferences.Editor editor = myprefs.edit();
                editor.putString("Trainingsplan1name", trainignsplanName);

                editor.apply();

                startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
            }
        });
    }


    private void Trainingspläne() {
        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);

            LinearLayout TrainingsplanLayout = (LinearLayout) findViewById(R.id.LayoutTrainingsplänebearbeiten);
            TextView text = (TextView) findViewById(R.id.Trainingsplantxt);

            TextView infotext = new TextView(this);
            infotext.setText("Deine Trainingspläne:");
            TrainingsplanLayout.addView(infotext);

            Button trainingsplan1 = new Button(this);
            trainingsplan1.setText(myprefs.getString("Trainingsplan1name", "default"));
            TrainingsplanLayout.addView(trainingsplan1);

            trainingsplan1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                }
            });

    }
}
