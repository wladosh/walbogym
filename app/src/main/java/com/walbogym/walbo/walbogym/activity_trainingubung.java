package com.walbogym.walbo.walbogym;

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
                if(timerrunning){
                    resetTimer();
                }
                else{
                    convertTime();
                    timerProgressbar.setMax((int)timeleftinmillis/1000); //set Progressbar max
                }
            }
        });

    }
    private void convertTime() {
        pausenzeittxb = findViewById(R.id.timertxb);
        String pausenzeittext = pausenzeittxb.getText().toString().trim();
        if (pausenzeittext.isEmpty()) { //Wenn pausenzeit leer ist wird der hint genommen
            String timeleft = pausenzeittxb.getHint().toString();

            String[] split = timeleft.split(":");
            if (split.length == 2) {
                long seconds = TimeUnit.MINUTES.toSeconds(Integer.parseInt(split[0])) +
                        Integer.parseInt(split[1]);
                timeleftinmillis = seconds * 1000;
                countdowntime = timeleftinmillis;

                startTimer();
            }
        } else {
            String timeleft = pausenzeittxb.getText().toString();

            if (!timeleft.contains(":") && timeleft.length() == 1){ //Wenn z.B. nur 2 eingegeben wird, soll noch ein :00 dazu, sonst kann der nächste Schritt nicht laufen
                timeleft = timeleft + ":00";
            }
            if (!timeleft.contains(":") && timeleft.length() == 2){ //Wenn kein : dabei ist und zwei Zahlen angegeben sind, sind es mehr als 10 minuten, also error
                Toast.makeText(activity_trainingubung.this, "Pause muss unter 10 min sein", Toast.LENGTH_SHORT).show();
                return;
            }
             String[] split = timeleft.split(":");
            if (split.length == 2) {
                long seconds = TimeUnit.MINUTES.toSeconds(Integer.parseInt(split[0])) +
                        Integer.parseInt(split[1]);
                timeleftinmillis = seconds * 1000;
                countdowntime = timeleftinmillis;

                startTimer();
            }
        }

    }

    private void startTimer(){
        endTime = System.currentTimeMillis()+timeleftinmillis;

        countdowntimer = new CountDownTimer(timeleftinmillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timerrunning = false;
                startbtn.setText("Start");
            }
        }.start();
        timerrunning = true;
        startbtn.setText("Reset");
    }

    private void updateCountdownText(){
        timerProgressbar = findViewById(R.id.timerprogressbar);

        int minutes = (int)(timeleftinmillis/1000) / 60;
        int seconds = (int)(timeleftinmillis/1000) % 60;

        String timeleftFormatted = String.format(Locale.getDefault(),"%01d:%02d", minutes, seconds);

        countdowntxt.setText(timeleftFormatted);
        timerProgressbar.setProgress((int)timeleftinmillis/1000);
    }
    private void resetTimer(){

        SharedPreferences prefs = getSharedPreferences("timer"+aktuelleübung, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.clear();// setzt die prefs zurück, da sonst timer wie gespeichert läuft nach dem resetten
        editor.commit();

        resetCountdownText();
        countdowntimer.cancel();
        timerrunning = false;
        startbtn.setText("Start");

    }
    private void resetCountdownText(){
        timerProgressbar = findViewById(R.id.timerprogressbar);

        int minutes = (int)(countdowntime/1000) / 60;
        int seconds = (int)(countdowntime/1000) % 60;

        String timeleftFormatted = String.format(Locale.getDefault(),"%01d:%02d", minutes, seconds);

        countdowntxt.setText(timeleftFormatted);
        timerProgressbar.setMax(100);
        timerProgressbar.setProgress(100);
    }

    @Override
    protected void onStop(){ //wenn die app geschlossen wird
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("timer"+aktuelleübung, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", timeleftinmillis);
        editor.putBoolean("timerrunning", timerrunning);
        editor.putLong("endTime", endTime);
        editor.apply();

        //countdowntimer.cancel();
    }
    @Override
    protected void onStart(){ //wenn die app wieder startet
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("timer"+aktuelleübung, MODE_PRIVATE);

        timeleftinmillis = prefs.getLong("millisLeft", countdowntime);
        timerrunning = prefs.getBoolean("timerrunning", false);

        updateCountdownText();

        if (timerrunning){
            endTime = prefs.getLong("endTime", 0);
            timeleftinmillis = endTime - System.currentTimeMillis();

            if (timeleftinmillis < 0){
                timeleftinmillis = 0;
                timerrunning = false;
                updateCountdownText();
            }
            else{
                startTimer();
            }
        }
    }

    private void IntializeTextListeners(){
        gewichtetxb = findViewById(R.id.gewichttxb);
        wiederholungentxb = findViewById(R.id.wiederholungentxb);
        saetzetxb = findViewById(R.id.saetzetxb);
        pausenzeittxb = findViewById(R.id.timertxb);

        SharedPreferences prefs = getSharedPreferences("übungseigenschaften", MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        //fülle die Werte
            gewichtetxb.setText(prefs.getString("gewicht"+aktuelleübung, ""));
            wiederholungentxb.setText(prefs.getString("wiederholungen"+aktuelleübung, ""));
            saetzetxb.setText(prefs.getString("saetze"+aktuelleübung, ""));
            pausenzeittxb.setText(prefs.getString("pause"+aktuelleübung, ""));
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
        pausenzeittxb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("pause"+aktuelleübung, s.toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
