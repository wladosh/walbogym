package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class activity_trainingsstart extends AppCompatActivity {

    public static String aktuelleübung;
    //public static Integer Einheit;

    public Integer SatzInt = 1;
    private Integer Progessbarmax = 1;

    private TextView countdowntxt;

    private EditText gewichtetxb;
    private EditText wiederholungentxb;
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
        setContentView(R.layout.activity_trainingsstart);

        SharedPreferences prefs = getSharedPreferences("übungseigenschaften", MODE_PRIVATE);
        setButtons();
        IntializeTextListeners();

        TextView Übung = (TextView)findViewById(R.id.ubungtxtimsatz);
        Übung.setText(aktuelleübung);

        TextView Satz = (TextView)findViewById(R.id.aktuellersatztxt);
        Integer angegenbensätze = Integer.parseInt(prefs.getString("saetze"+aktuelleübung, "3"));
        Satz.setText(("Satz ") + SatzInt.toString()+"/"+angegenbensätze);
    }

    private void setButtons(){
        final Button startbtn = findViewById(R.id.timerstartbtn);
        Button nächsterSatzbtn = findViewById(R.id.nächstersatzbtn);

        startbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(timerrunning){
                    resetTimer();
                }
                else{
                    convertTime();
                    timerProgressbar.setMax((int)timeleftinmillis/1000); //set Progressbar max
                    Progessbarmax = timerProgressbar.getMax();
                    startbtn.setAlpha(0);
                }
            }
        });
        nächsterSatzbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences prefs = getSharedPreferences("übungseigenschaften", MODE_PRIVATE);
                //final SharedPreferences.Editor editor = prefs.edit();

                Integer angegenbensätze = Integer.parseInt(prefs.getString("saetze"+aktuelleübung, "3"));//Integer.parseInt(prefs.getString("saetze"+aktuelleübung,"1"));
                if (angegenbensätze == SatzInt){
                    startActivity(new Intent(activity_trainingsstart.this, activity_trainieren.class));
                    return;
                }

                if (angegenbensätze == SatzInt +1){
                    Button nächsterSatzbtn = (Button)findViewById(R.id.nächstersatzbtn);
                    nächsterSatzbtn.setText("Übung abschließen");
                }
                SatzInt += 1;
                TextView Satz = (TextView)findViewById(R.id.aktuellersatztxt);
                Satz.setText(("Satz ") + SatzInt.toString() + "/"+angegenbensätze.toString());
                resetTimer();
                IntializeTextListeners();
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

            if (!timeleft.contains(":") && timeleft.length() == 1) { //Wenn z.B. nur 2 eingegeben wird, soll noch ein :00 dazu, sonst kann der nächste Schritt nicht laufen
                timeleft = timeleft + ":00";
            }
            if (!timeleft.contains(":") && timeleft.length() == 2) { //Wenn kein : dabei ist und zwei Zahlen angegeben sind, sind es mehr als 10 minuten, also error
                Toast.makeText(activity_trainingsstart.this, "Pause muss unter 10 min sein", Toast.LENGTH_SHORT).show();
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
        startbtn = findViewById(R.id.timerstartbtn);

        countdowntimer = new CountDownTimer(timeleftinmillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timerrunning = false;
                startbtn.setAlpha(1);
            }
        }.start();
        timerrunning = true;
    }

    private void updateCountdownText(){
        timerProgressbar = findViewById(R.id.timerprogressbar);
        countdowntxt = findViewById(R.id.countowntxt);
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
        if (timerrunning == true){
            countdowntimer.cancel();
            timerrunning = false;
            startbtn.setAlpha(1);
        }
    }

    private void resetCountdownText(){
        timerProgressbar = findViewById(R.id.timerprogressbar);
        countdowntxt = findViewById(R.id.countowntxt);

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

        timerProgressbar = findViewById(R.id.timerprogressbar);

        SharedPreferences prefs = getSharedPreferences("timer"+aktuelleübung, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", timeleftinmillis);
        editor.putLong("progressbarProgress", timerProgressbar.getProgress());
        editor.putBoolean("timerrunning", timerrunning);
        editor.putLong("endTime", endTime);
        editor.putInt("maxtimeseconds", Progessbarmax);
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
            final Integer progressbarprogress = (int)(prefs.getLong("progressbarProgress", 0) - System.currentTimeMillis() /1000);

            if (timeleftinmillis < 0){
                timeleftinmillis = 0;
                timerrunning = false;
                updateCountdownText();
            }
            else{
                startTimer();
                timerProgressbar = findViewById(R.id.timerprogressbar);
                timerProgressbar.setMax(prefs.getInt("maxtimeseconds", 100));
                timerProgressbar.setProgress(progressbarprogress);
                Progessbarmax = prefs.getInt("maxtimeseconds", 0);
            }
        }
    }

    private void IntializeTextListeners(){
        gewichtetxb = findViewById(R.id.gewichtimsatztxb);
        wiederholungentxb = findViewById(R.id.wiederholungenimsatztxb);
        pausenzeittxb = findViewById(R.id.timertxb);


        SharedPreferences prefs = getSharedPreferences("übungseigenschaften", MODE_PRIVATE);
        SharedPreferences prefsStatistik = getSharedPreferences("statistik", MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        final SharedPreferences.Editor editorstatistik = prefsStatistik.edit();
        //fülle die Werte
        if(!prefs.contains("gewicht"+aktuelleübung+SatzInt)) //wenn es für diesen Satz noch nichts gibt, nimmt er das vom vorher Eingegebenen
            gewichtetxb.setText(prefs.getString("gewicht"+aktuelleübung, ""));
        else
        gewichtetxb.setText(prefs.getString("gewicht"+aktuelleübung+SatzInt, ""));

        if(!prefs.contains("wiederholungen"+aktuelleübung+SatzInt))
        wiederholungentxb.setText(prefs.getString("wiederholungen"+aktuelleübung, ""));
        else
            wiederholungentxb.setText(prefs.getString("wiederholungen"+aktuelleübung+SatzInt, ""));

        if(!prefs.contains("pause"+aktuelleübung+SatzInt))
            pausenzeittxb.setText(prefs.getString("pause"+aktuelleübung, ""));
        else
        pausenzeittxb.setText(prefs.getString("pause"+aktuelleübung+SatzInt, ""));

        final Calendar cal = Calendar.getInstance();

        //setze die prefs
        gewichtetxb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("gewicht"+aktuelleübung+SatzInt, s.toString());
                editor.apply();

                editorstatistik.putString("gewicht"+aktuelleübung+cal, s.toString());
                editorstatistik.apply();
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
                editor.putString("wiederholungen"+aktuelleübung+SatzInt, s.toString());
                editor.apply();

                editorstatistik.putString("wiederholungen"+aktuelleübung+cal, s.toString());
                editorstatistik.apply();
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
                editor.putString("pause"+aktuelleübung+SatzInt, s.toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
