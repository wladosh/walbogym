package com.walbogym.walbo.walbogym;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class activityMotivation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);

        setrandonimage();
    }

    private void setrandonimage(){
        ImageView motivationImage = (ImageView)findViewById(R.id.motivationimage);

        SharedPreferences prefs = getSharedPreferences("motivation", MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int Day = calendar.get(Calendar.DATE);
        int Month = calendar.get(Calendar.MONTH)+1;

        String Datum = Day+"/"+Month;

        if (!prefs.contains("lastdate") || !prefs.getString("lastdate","").equals(Datum)){
            editor.putString("lastdate", Datum);

            int random = new Random().nextInt(16) + 0; // [0, 60] + 20 => [20, 80]
            editor.putInt("lastmotivationimg", random);
            editor.apply();

        }

        int random = prefs.getInt("lastmotivationimg", 0);
        switch (random){
            case 0:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation0));
                break;
            case 1:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation1));
                break;
            case 2:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation2));
                break;
            case 3:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation3));
                break;
            case 4:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation4));
                break;
            case 5:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation5));
                break;
            case 6:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation6));
                break;
            case 7:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation7));
                break;
            case 8:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation8));
                break;
            case 9:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation9));
                break;
            case 10:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation10));
                break;
            case 11:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation11));
                break;
            case 12:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation12));
                break;
            case 13:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation13));
                break;
            case 14:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation14));
                break;
            case 15:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation15));
                break;
            case 16:
                motivationImage.setImageDrawable(getDrawable(R.drawable.motivation16));
                break;
        }

    }
}
