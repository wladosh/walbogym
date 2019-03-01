package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class activity_trainingubung extends AppCompatActivity {

    public static String aktuelleübung;

    private TextView countdowntxt;

    private EditText gewichtetxb;
    private EditText wiederholungentxb;
    private EditText saetzetxb;
    private EditText pausenzeittxb;

    private Button startbtn;
    private ProgressBar timerProgressbar;
    private CountDownTimer countdowntimer;

    private boolean timerrunning;

    private long timeleftinmillis;
    private long countdowntime;
    private long endTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingubung);

        SetButton();
        IntializeTextListeners();

        TextView übungname = (TextView)findViewById(R.id.ubungtxt); //setzt überschrift
        übungname.setText(aktuelleübung);
    }


    private void SetButton(){
        countdowntxt = findViewById(R.id.timertxt);
        startbtn = findViewById(R.id.timerstartbtn);

        startbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    startActivity(new Intent(activity_trainingubung.this, activity_trainingsstart.class));
                    activity_trainingsstart.aktuelleübung=aktuelleübung;
            }
        });

    }

    private void IntializeTextListeners(){
        gewichtetxb = findViewById(R.id.gewichttxb);
        wiederholungentxb = findViewById(R.id.wiederholungentxb);
        saetzetxb = findViewById(R.id.saetzetxb);

        SharedPreferences prefs = getSharedPreferences("übungseigenschaften", MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        //fülle die Werte
            gewichtetxb.setText(prefs.getString("gewicht"+aktuelleübung, ""));
            wiederholungentxb.setText(prefs.getString("wiederholungen"+aktuelleübung, ""));
            saetzetxb.setText(prefs.getString("saetze"+aktuelleübung, ""));
        //setzte die prefs
        gewichtetxb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("gewicht"+aktuelleübung, s.toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        wiederholungentxb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("wiederholungen"+aktuelleübung, s.toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        saetzetxb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("saetze"+aktuelleübung, s.toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
