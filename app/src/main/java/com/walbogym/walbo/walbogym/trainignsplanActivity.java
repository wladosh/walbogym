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

        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);
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
        final SharedPreferences.Editor editor = myprefs.edit();

        final LinearLayout TrainingsplanLayout = (LinearLayout) findViewById(R.id.LayoutTrainingsplänebearbeiten);
            final LinearLayout minusbtnlayout = (LinearLayout) findViewById(R.id.minusbtnlayout);
            TextView text = (TextView) findViewById(R.id.Trainingsplantxt);

            TextView infotext = new TextView(this);
            infotext.setText("Deine Trainingspläne:");
            infotext.setHeight(10);
            TrainingsplanLayout.addView(infotext);

            if (myprefs.contains("Trainingsplan1name")){
                final Button trainingsplan1 = new Button(this);
                trainingsplan1.setText(myprefs.getString("Trainingsplan1name", "default"));
                TrainingsplanLayout.addView(trainingsplan1);

                final Button trainingsplan1delete = new Button(this);
                trainingsplan1delete.setText("-");
                minusbtnlayout.addView(trainingsplan1delete);

                trainingsplan1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                        Trainingsplan_Einheiten.aktuellerTrainingsplan = 1;
                    }
                });
                trainingsplan1delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TrainingsplanLayout.removeView(trainingsplan1);
                        minusbtnlayout.removeView(trainingsplan1delete);
                        editor.remove("Trainingsplan1name");
                        editor.apply();
                        deleteprefs(1);
                    }
                });
            }
        if (myprefs.contains("Trainingsplan2name")){
            final Button trainingsplan2 = new Button(this);
            trainingsplan2.setText(myprefs.getString("Trainingsplan2name", "default"));
            TrainingsplanLayout.addView(trainingsplan2);

            final Button trainingsplan2delete = new Button(this);
            trainingsplan2delete.setText("-");
            minusbtnlayout.addView(trainingsplan2delete);

            trainingsplan2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 2;
                }
            });
            trainingsplan2delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TrainingsplanLayout.removeView(trainingsplan2);
                    minusbtnlayout.removeView(trainingsplan2delete);
                    editor.remove("Trainingsplan2name");
                    editor.apply();
                    deleteprefs(2);
                }
            });
        }
        if (myprefs.contains("Trainingsplan3name")){
            final Button trainingsplan3 = new Button(this);
            trainingsplan3.setText(myprefs.getString("Trainingsplan3name", "default"));
            TrainingsplanLayout.addView(trainingsplan3);

            final Button trainingsplan3delete = new Button(this);
            trainingsplan3delete.setText("-");
            minusbtnlayout.addView(trainingsplan3delete);

            trainingsplan3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 3;
                }
            });
            trainingsplan3delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TrainingsplanLayout.removeView(trainingsplan3);
                    minusbtnlayout.removeView(trainingsplan3delete);
                    editor.remove("Trainingsplan3name");
                    editor.apply();
                    deleteprefs(3);
                }
            });
        }
        if (myprefs.contains("Trainingsplan4name")){
            final Button trainingsplan4 = new Button(this);
            trainingsplan4.setText(myprefs.getString("Trainingsplan4name", "default"));
            TrainingsplanLayout.addView(trainingsplan4);

            final Button trainingsplan4delete = new Button(this);
            trainingsplan4delete.setText("-");
            minusbtnlayout.addView(trainingsplan4delete);

            trainingsplan4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 4;
                }
            });
            trainingsplan4delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TrainingsplanLayout.removeView(trainingsplan4);
                    minusbtnlayout.removeView(trainingsplan4delete);
                    editor.remove("Trainingsplan4name");
                    editor.apply();
                    deleteprefs(4);
                }
            });
        }
        if (myprefs.contains("Trainingsplan5name")){
            final Button trainingsplan5 = new Button(this);
            trainingsplan5.setText(myprefs.getString("Trainingsplan5name", "default"));
            TrainingsplanLayout.addView(trainingsplan5);

            final Button trainingsplan5delete = new Button(this);
            trainingsplan5delete.setText("-");
            minusbtnlayout.addView(trainingsplan5delete);

            trainingsplan5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(trainignsplanActivity.this, Trainingsplan_Einheiten.class));
                    Trainingsplan_Einheiten.aktuellerTrainingsplan = 5;
                }
            });
            trainingsplan5delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TrainingsplanLayout.removeView(trainingsplan5);
                    minusbtnlayout.removeView(trainingsplan5delete);
                    editor.remove("Trainingsplan5name");
                    editor.apply();
                    deleteprefs(5);
                }
            });
        }

    }
    private void deleteprefs(int aktuellerTrainingsplan){
        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);
        final SharedPreferences.Editor editor = myprefs.edit();

        for(int i = 1; i<5; i++){
            String Trainingsplan = "Trainingsplan"+aktuellerTrainingsplan+"Einheit"+i;

            editor.remove(Trainingsplan+"Bankdrücken");
            editor.remove(Trainingsplan+"Liegestütze");
            editor.remove(Trainingsplan+"Butterfly");
            editor.remove(Trainingsplan+"Schulterdrücken");
            editor.remove(Trainingsplan+"Seitheben");
            editor.remove(Trainingsplan+"Frontheben");
            editor.remove(Trainingsplan+"Seithebenkabelzug");
            editor.remove(Trainingsplan+"Facepulls");
            editor.remove(Trainingsplan+"Trizepspushdowns");
            editor.remove(Trainingsplan+"Trizepsüberkopf");
            editor.remove(Trainingsplan+"Bizepscurlskurzhantel");
            editor.remove(Trainingsplan+"Bizepscurlskabel");
            editor.remove(Trainingsplan+"Bizepscurlslanghantel");
            editor.remove(Trainingsplan+"Latziehen");
            editor.remove(Trainingsplan+"Klimmzüge");
            editor.remove(Trainingsplan+"Rudernkurz");
            editor.remove(Trainingsplan+"Rudernlang");
            editor.remove(Trainingsplan+"Kniebeugen");
            editor.remove(Trainingsplan+"Beinpresse");
            editor.remove(Trainingsplan+"Kreuzheben");
            editor.remove(Trainingsplan+"Beinbeuger");
            editor.remove(Trainingsplan+"Beincurls");
            editor.remove(Trainingsplan+"Wadendrücken");

            editor.remove("Trainingsplan"+aktuellerTrainingsplan+"Einheit"+i);
            editor.apply();
        }
    }
}
