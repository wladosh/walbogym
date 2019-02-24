package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Training_Trainingsplanauswahl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training__trainingsplanauswahl);

        Trainingspläne();
    }

    private void Trainingspläne(){
    LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayoutTrainingsplan);

    SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);
    Button Trainingsplan1 = new Button(this);
    Trainingsplan1.setText(myprefs.getString("Trainingsplan1name", "default"));
    layout.addView(Trainingsplan1);

    Trainingsplan1.setOnClickListener(new View.OnClickListener(){@Override
    public void onClick(View view){
        Einheiten();
    }
    });

    TextView EinheitenText = (TextView)findViewById(R.id.einheittxt);
    EinheitenText.setText("");
}

    private void Einheiten(){
        LinearLayout layoutEinheit = (LinearLayout)findViewById(R.id.linearLayoutEinheiten);

        TextView EinheitenText = (TextView)findViewById(R.id.einheittxt);
        EinheitenText.setText("Wähle eine Einheit aus, die du heute machen möchtest.");

        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);

        if (myprefs.contains("Trainingsplan1Einheit1")){
            Button Einheit1 = new Button(this);
            Einheit1.setText(myprefs.getString("Trainingsplan1Einheit1", "default"));
            layoutEinheit.addView(Einheit1);

            Einheit1.setOnClickListener(new View.OnClickListener(){@Override
                public void onClick(View view){
                activity_trainieren.Einheit = 1;
                startActivity(new Intent(Training_Trainingsplanauswahl.this, activity_trainieren.class));
                }
            });
        }
        else{
            TextView Einheiterstellentext = new TextView(this);
            Einheiterstellentext.setText("Du musst erst eine Einheit erstellen.");
            layoutEinheit.addView(Einheiterstellentext);

        }

        if (myprefs.contains("Trainingsplan1Einheit2")){
            Button Einheit2 = new Button(this);
            Einheit2.setText(myprefs.getString("Trainingsplan1Einheit2", "default"));
            layoutEinheit.addView(Einheit2);

            Einheit2.setOnClickListener(new View.OnClickListener(){@Override
            public void onClick(View view){
                activity_trainieren.Einheit = 2;
                startActivity(new Intent(Training_Trainingsplanauswahl.this, activity_trainieren.class));
            }
            });
        }
        if (myprefs.contains("Trainingsplan1Einheit3")){
            Button Einheit3 = new Button(this);
            Einheit3.setText(myprefs.getString("Trainingsplan1Einheit3", "default"));
            layoutEinheit.addView(Einheit3);
            Einheit3.setOnClickListener(new View.OnClickListener(){@Override
            public void onClick(View view){
                activity_trainieren.Einheit = 3;
                startActivity(new Intent(Training_Trainingsplanauswahl.this, activity_trainieren.class));
            }
            });
        }
        if (myprefs.contains("Trainingsplan1Einheit4")){
            Button Einheit4 = new Button(this);
            Einheit4.setText(myprefs.getString("Trainingsplan1Einheit4", "default"));
            layoutEinheit.addView(Einheit4);
            Einheit4.setOnClickListener(new View.OnClickListener(){@Override
            public void onClick(View view){
                activity_trainieren.Einheit = 4;
                startActivity(new Intent(Training_Trainingsplanauswahl.this, activity_trainieren.class));
            }
            });
        }
    }
}
