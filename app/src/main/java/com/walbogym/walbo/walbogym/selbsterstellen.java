package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selbsterstellen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selbsterstellen);

        confiureButtons();
        coloractiveButtons();
    }

    public static Integer Einheit;
    public static Integer aktuellerTrainingsplan;


    Boolean Bankdrückenbool = false;
    Boolean Liegestützebool = false;
    Boolean Butterflybool = false;
    Boolean Schulterdrückenbool = false;
    Boolean Seithebenbool = false;
    Boolean Fronthebenbool = false;
    Boolean Seithebenkabelbool = false;
    Boolean Facepullsbool = false;
    Boolean Trizepspushdownsbool = false;
    Boolean Trizepsüberkopfbool = false;
    Boolean Bizepscurlskurzhantelbool = false;
    Boolean Bizepscurlskabelbool = false;
    Boolean Bizepscurlslanghantelbool = false;
    Boolean Bizepscurlslanghantelkabelbool = false;
    Boolean Latziehenbool = false;
    Boolean Klimmzügebool = false;
    Boolean Rudernkurzbool = false;
    Boolean Rudernlangbool = false;
    Boolean Kniebeugenbool = false;
    Boolean Beinpressebool = false;
    Boolean Kreuzhebenbool = false;
    Boolean Beinbeugerbool = false;
    Boolean Beincurlsbool = false;
    Boolean Wadendrückenbool = false;

    private void confiureButtons(){
        //fnish btn
        final Button Finish = (Button)findViewById(R.id.btnfinish);
        //brust
        final Button Bankdrücken = (Button)findViewById(R.id.bankdrücken);
        final Button Liegestütze = (Button)findViewById(R.id.liegestütze);
        final Button Butterfly = (Button)findViewById(R.id.butterfly);
        //Schulter
        final Button Schulterdrücken = (Button)findViewById(R.id.schulterdrücken);
        final Button Seitheben = (Button)findViewById(R.id.seitheben);
        final Button Frontheben = (Button)findViewById(R.id.frontheben);
        final Button SeithebenKabel = (Button)findViewById(R.id.seithebenkabel);
        final Button Facepulls = (Button)findViewById(R.id.facepulls);
        //Trizeps
        final Button Trizepspushdowns = (Button)findViewById(R.id.trizepspushdowns);
        final Button Trizepsüberkopf = (Button)findViewById(R.id.trizepsüberkopf);
        //Bizeps
        final Button Bizepscurlskurzhantel = (Button)findViewById(R.id.bizepscurlskurzhantel);
        final Button Bizepscurlskabel = (Button)findViewById(R.id.bizepscurlskabelzug);
        final Button Bizepscurlslanghantel = (Button)findViewById(R.id.bizepscurlslanghantel);
        final Button Bizepscurlslanghantelkabel = (Button)findViewById(R.id.bizepscurlslanghantelKabel);
        //Rücken
        final Button Latziehen = (Button)findViewById(R.id.latziehen);
        final Button Klimmzüge = (Button)findViewById(R.id.klimmzüge);
        final Button Rudernkurz = (Button)findViewById(R.id.rudernkurzgriff);
        final Button Rudernlang = (Button)findViewById(R.id.rudernlanggriff);
        //Beine
        final Button Kniebeugen = (Button)findViewById(R.id.kniebeugen);
        final Button Beinpresse = (Button)findViewById(R.id.beinpresse);
        final Button Kreuzheben = (Button)findViewById(R.id.kreuzheben);
        final Button Beinbeuger = (Button)findViewById(R.id.beinbeuger);
        final Button Beincurls = (Button)findViewById(R.id.Beincurls);
        final Button Wadendrücken = (Button)findViewById(R.id.wadendrücken);

        Finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(selbsterstellen.this, Trainingsplan_Einheiten.class));

                SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);
                SharedPreferences.Editor editor = myprefs.edit();

                String Trainingsplan = "Trainingsplan"+aktuellerTrainingsplan+"Einheit"+ Einheit;
                if(Bankdrückenbool == true)
                    editor.putString(Trainingsplan+"Bankdrücken", "true");
                else editor.putString(Trainingsplan+"Bankdrücken", "false");
                if(Liegestützebool == true)
                    editor.putString(Trainingsplan+"Liegestütze", "true");
                else editor.putString(Trainingsplan+"Liegestütze", "false");
                if(Butterflybool == true)
                    editor.putString(Trainingsplan+"Butterfly", "true");
                else editor.putString(Trainingsplan+"Butterfly", "false");
                if(Schulterdrückenbool == true)
                    editor.putString(Trainingsplan+"Schulterdrücken", "true");
                else editor.putString(Trainingsplan+"Schulterdrücken", "false");
                if(Seithebenbool == true)
                    editor.putString(Trainingsplan+"Seitheben", "true");
                else editor.putString(Trainingsplan+"Seitheben", "false");
                if(Fronthebenbool == true)
                    editor.putString(Trainingsplan+"Frontheben", "true");
                else editor.putString(Trainingsplan+"Frontheben", "false");
                if(Seithebenkabelbool == true)
                    editor.putString(Trainingsplan+"Seithebenkabelzug", "true");
                else editor.putString(Trainingsplan+"Seithebenkabelzug", "false");
                if(Facepullsbool == true)
                    editor.putString(Trainingsplan+"Facepulls", "true");
                else editor.putString(Trainingsplan+"Facepulls", "false");
                if(Trizepspushdownsbool == true)
                    editor.putString(Trainingsplan+"Trizepspushdowns", "true");
                else editor.putString(Trainingsplan+"Trizepspushdowns", "false");
                if(Trizepsüberkopfbool == true)
                    editor.putString(Trainingsplan+"Trizepsüberkopf", "true");
                else editor.putString(Trainingsplan+"Trizepsüberkopf", "false");
                if(Bizepscurlskurzhantelbool == true)
                    editor.putString(Trainingsplan+"Bizepscurlskurzhantel", "true");
                else editor.putString(Trainingsplan+"Bizepscurlskurzhantel", "false");
                if(Bizepscurlskabelbool == true)
                    editor.putString(Trainingsplan+"Bizepscurlskabel", "true");
                else editor.putString(Trainingsplan+"Bizepscurlskabel", "false");
                if(Bizepscurlslanghantelkabelbool == true)
                    editor.putString(Trainingsplan+"Bizepscurlslangkabel", "true");
                else editor.putString(Trainingsplan+"Bizepscurlslangkabel", "false");
                if(Bizepscurlslanghantelbool == true)
                    editor.putString(Trainingsplan+"Bizepscurlslanghantel", "true");
                else editor.putString(Trainingsplan+"Bizepscurlslanghantel", "false");
                if(Latziehenbool == true)
                    editor.putString(Trainingsplan+"Latziehen", "true");
                else editor.putString(Trainingsplan+"Latziehen", "false");
                if(Klimmzügebool == true)
                    editor.putString(Trainingsplan+"Klimmzüge", "true");
                else editor.putString(Trainingsplan+"Klimmzüge", "false");
                if(Rudernkurzbool == true)
                    editor.putString(Trainingsplan+"Rudernkurz", "true");
                else editor.putString(Trainingsplan+"Rudernkurz", "false");
                if(Rudernlangbool == true)
                    editor.putString(Trainingsplan+"Rudernlang", "true");
                else editor.putString(Trainingsplan+"Rudernlang", "false");
                if(Kniebeugenbool == true)
                    editor.putString(Trainingsplan+"Kniebeugen", "true");
                else editor.putString(Trainingsplan+"Kniebeugen", "false");
                if(Beinpressebool == true)
                    editor.putString(Trainingsplan+"Beinpresse", "true");
                else editor.putString(Trainingsplan+"Beinpresse", "false");
                if(Kreuzhebenbool == true)
                    editor.putString(Trainingsplan+"Kreuzheben", "true");
                else editor.putString(Trainingsplan+"Kreuzheben", "false");
                if(Beinbeugerbool == true)
                    editor.putString(Trainingsplan+"Beinbeuger", "true");
                else editor.putString(Trainingsplan+"Beinbeuger", "false");
                if(Beincurlsbool == true)
                    editor.putString(Trainingsplan+"Beincurls", "true");
                else editor.putString(Trainingsplan+"Beincurls", "false");
                if(Wadendrückenbool == true)
                    editor.putString(Trainingsplan+"Wadendrücken", "true");
                else editor.putString(Trainingsplan+"Wadendrücken", "false");


                editor.apply();

            }
        });

        Bankdrücken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Bankdrückenbool == false){
                    Bankdrückenbool = true;
                    Bankdrücken.setBackgroundColor(Color.rgb(236,134,0));
                }else{
                    Bankdrückenbool = false;
                    Bankdrücken.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Liegestütze.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Liegestützebool == false){
                    Liegestützebool = true;
                    Liegestütze.setBackgroundColor(Color.rgb(236,134,0));
                }else{
                    Liegestützebool = false;
                    Liegestütze.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Butterfly.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Butterflybool == false) {
                    Butterflybool = true;
                    Butterfly.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Butterflybool = false;
                    Butterfly.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Schulterdrücken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Schulterdrückenbool == false) {
                    Schulterdrückenbool = true;
                    Schulterdrücken.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Schulterdrückenbool = false;
                    Schulterdrücken.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Seitheben.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Seithebenbool == false) {
                    Seithebenbool = true;
                    Seitheben.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Seithebenbool = false;
                    Seitheben.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Frontheben.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Fronthebenbool == false) {
                    Fronthebenbool = true;
                    Frontheben.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Fronthebenbool = false;
                    Frontheben.setBackgroundColor(Color.GRAY);
                }
            }
        });
        SeithebenKabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Seithebenkabelbool == false) {
                    Seithebenkabelbool = true;
                    SeithebenKabel.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Seithebenkabelbool = false;
                    SeithebenKabel.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Facepulls.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Facepullsbool == false) {
                    Facepullsbool = true;
                    Facepulls.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Facepullsbool = false;
                    Facepulls.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Trizepspushdowns.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Trizepspushdownsbool == false) {
                    Trizepspushdownsbool = true;
                    Trizepspushdowns.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Trizepspushdownsbool = false;
                    Trizepspushdowns.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Trizepsüberkopf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Trizepsüberkopfbool == false) {
                    Trizepsüberkopfbool = true;
                    Trizepsüberkopf.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Trizepsüberkopfbool = false;
                    Trizepsüberkopf.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Bizepscurlskurzhantel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Bizepscurlskurzhantelbool == false) {
                    Bizepscurlskurzhantelbool = true;
                    Bizepscurlskurzhantel.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Bizepscurlskurzhantelbool = false;
                    Bizepscurlskurzhantel.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Bizepscurlskabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Bizepscurlskabelbool == false) {
                    Bizepscurlskabelbool = true;
                    Bizepscurlskabel.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Bizepscurlskabelbool = false;
                    Bizepscurlskabel.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Bizepscurlslanghantel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Bizepscurlslanghantelbool == false) {
                    Bizepscurlslanghantelbool = true;
                    Bizepscurlslanghantel.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Bizepscurlslanghantelbool = false;
                    Bizepscurlslanghantel.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Bizepscurlslanghantelkabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Bizepscurlslanghantelkabelbool == false) {
                    Bizepscurlslanghantelkabelbool = true;
                    Bizepscurlslanghantelkabel.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Bizepscurlslanghantelkabelbool = false;
                    Bizepscurlslanghantelkabel.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Latziehen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Latziehenbool == false) {
                    Latziehenbool = true;
                    Latziehen.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Latziehenbool = false;
                    Latziehen.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Klimmzüge.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Klimmzügebool == false) {
                    Klimmzügebool = true;
                    Klimmzüge.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Klimmzügebool = false;
                    Klimmzüge.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Rudernkurz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Rudernkurzbool == false) {
                    Rudernkurzbool = true;
                    Rudernkurz.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Rudernkurzbool = false;
                    Rudernkurz.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Rudernlang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Rudernlangbool == false) {
                    Rudernlangbool = true;
                    Rudernlang.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Rudernlangbool = false;
                    Rudernlang.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Kniebeugen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Kniebeugenbool == false) {
                    Kniebeugenbool = true;
                    Kniebeugen.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Kniebeugenbool = false;
                    Kniebeugen.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Beinpresse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Beinpressebool == false) {
                    Beinpressebool = true;
                    Beinpresse.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Beinpressebool = false;
                    Beinpresse.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Kreuzheben.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Kreuzhebenbool == false) {
                    Kreuzhebenbool = true;
                    Kreuzheben.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Kreuzhebenbool = false;
                    Kreuzheben.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Beinbeuger.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Beinbeugerbool == false) {
                    Beinbeugerbool = true;
                    Beinbeuger.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Beinbeugerbool = false;
                    Beinbeuger.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Beincurls.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Beincurlsbool == false) {
                    Beincurlsbool = true;
                    Beincurls.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Beincurlsbool = false;
                    Beincurls.setBackgroundColor(Color.GRAY);
                }
            }
        });
        Wadendrücken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Wadendrückenbool == false) {
                    Wadendrückenbool = true;
                    Wadendrücken.setBackgroundColor(Color.rgb(236, 134, 0));
                } else {
                    Wadendrückenbool = false;
                    Wadendrücken.setBackgroundColor(Color.GRAY);
                }
            }
        });

    }

    private void coloractiveButtons(){
        //fnish btn
        final Button Finish = (Button)findViewById(R.id.btnfinish);
        //brust
        final Button Bankdrücken = (Button)findViewById(R.id.bankdrücken);
        final Button Liegestütze = (Button)findViewById(R.id.liegestütze);
        final Button Butterfly = (Button)findViewById(R.id.butterfly);
        //Schulter
        final Button Schulterdrücken = (Button)findViewById(R.id.schulterdrücken);
        final Button Seitheben = (Button)findViewById(R.id.seitheben);
        final Button Frontheben = (Button)findViewById(R.id.frontheben);
        final Button SeithebenKabel = (Button)findViewById(R.id.seithebenkabel);
        final Button Facepulls = (Button)findViewById(R.id.facepulls);
        //Trizeps
        final Button Trizepspushdowns = (Button)findViewById(R.id.trizepspushdowns);
        final Button Trizepsüberkopf = (Button)findViewById(R.id.trizepsüberkopf);
        //Bizeps
        final Button Bizepscurlskurzhantel = (Button)findViewById(R.id.bizepscurlskurzhantel);
        final Button Bizepscurlskabel = (Button)findViewById(R.id.bizepscurlskabelzug);
        final Button Bizepscurlslanghantel = (Button)findViewById(R.id.bizepscurlslanghantel);
        final Button Bizepscurlslanghantelkabel = (Button)findViewById(R.id.bizepscurlslanghantelKabel);
        //Rücken
        final Button Latziehen = (Button)findViewById(R.id.latziehen);
        final Button Klimmzüge = (Button)findViewById(R.id.klimmzüge);
        final Button Rudernkurz = (Button)findViewById(R.id.rudernkurzgriff);
        final Button Rudernlang = (Button)findViewById(R.id.rudernlanggriff);
        //Beine
        final Button Kniebeugen = (Button)findViewById(R.id.kniebeugen);
        final Button Beinpresse = (Button)findViewById(R.id.beinpresse);
        final Button Kreuzheben = (Button)findViewById(R.id.kreuzheben);
        final Button Beinbeuger = (Button)findViewById(R.id.beinbeuger);
        final Button Beincurls = (Button)findViewById(R.id.Beincurls);
        final Button Wadendrücken = (Button)findViewById(R.id.wadendrücken);

        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingspläne", 0);
        String Trainingsplan = "Trainingsplan"+aktuellerTrainingsplan+"Einheit"+ Einheit;

        if(myprefs.getString(Trainingsplan+"Bankdrücken", "").equals("true")){
            Bankdrücken.setBackgroundColor(Color.rgb(236,134,0));
            Bankdrückenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Liegestütze", "").equals("true")){
            Liegestütze.setBackgroundColor(Color.rgb(236,134,0));
            Liegestützebool = true;
        }
        if(myprefs.getString(Trainingsplan+"Butterfly", "").equals("true")){
            Butterfly.setBackgroundColor(Color.rgb(236,134,0));
            Butterflybool = true;
        }
        if(myprefs.getString(Trainingsplan+"Schulterdrücken", "").equals("true")){
            Schulterdrücken.setBackgroundColor(Color.rgb(236,134,0));
            Schulterdrückenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Seitheben", "").equals("true")){
            Seitheben.setBackgroundColor(Color.rgb(236,134,0));
            Seithebenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Frontheben", "").equals("true")){
            Frontheben.setBackgroundColor(Color.rgb(236,134,0));
            Fronthebenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Seithebenkabelzug", "").equals("true")){
            SeithebenKabel.setBackgroundColor(Color.rgb(236,134,0));
            Seithebenkabelbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Facepulls", "").equals("true")){
            Facepulls.setBackgroundColor(Color.rgb(236,134,0));
            Facepullsbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Trizepspushdowns", "").equals("true")){
            Trizepspushdowns.setBackgroundColor(Color.rgb(236,134,0));
            Trizepspushdownsbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Trizepsüberkopf", "").equals("true")){
            Trizepsüberkopf.setBackgroundColor(Color.rgb(236,134,0));
            Trizepsüberkopfbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Bizepscurlskurzhantel", "").equals("true")){
            Bizepscurlskurzhantel.setBackgroundColor(Color.rgb(236,134,0));
            Bizepscurlskurzhantelbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Bizepscurlskabel", "").equals("true")){
            Bizepscurlskabel.setBackgroundColor(Color.rgb(236,134,0));
            Bizepscurlskabelbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Bizepscurlslanghantel", "").equals("true")){
            Bizepscurlslanghantel.setBackgroundColor(Color.rgb(236,134,0));
            Bizepscurlslanghantelbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Bizepscurlslangkabel", "").equals("true")){
            Bizepscurlslanghantelkabel.setBackgroundColor(Color.rgb(236,134,0));
            Bizepscurlslanghantelkabelbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Latziehen", "").equals("true")){
            Latziehen.setBackgroundColor(Color.rgb(236,134,0));
            Latziehenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Klimmzüge", "").equals("true")){
            Klimmzüge.setBackgroundColor(Color.rgb(236,134,0));
            Klimmzügebool = true;
        }
        if(myprefs.getString(Trainingsplan+"Rudernkurz", "").equals("true")){
            Rudernkurz.setBackgroundColor(Color.rgb(236,134,0));
            Rudernkurzbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Rudernlang", "").equals("true")){
            Rudernlang.setBackgroundColor(Color.rgb(236,134,0));
            Rudernlangbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Kniebeugen", "").equals("true")){
            Kniebeugen.setBackgroundColor(Color.rgb(236,134,0));
            Kniebeugenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Beinpresse", "").equals("true")){
            Beinpresse.setBackgroundColor(Color.rgb(236,134,0));
            Beinpressebool = true;
        }
        if(myprefs.getString(Trainingsplan+"Kreuzheben", "").equals("true")){
            Kreuzheben.setBackgroundColor(Color.rgb(236,134,0));
            Kreuzhebenbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Beinbeuger", "").equals("true")){
            Beinbeuger.setBackgroundColor(Color.rgb(236,134,0));
            Beinbeugerbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Beincurls", "").equals("true")){
            Beincurls.setBackgroundColor(Color.rgb(236,134,0));
            Beincurlsbool = true;
        }
        if(myprefs.getString(Trainingsplan+"Wadendrücken", "").equals("true")){
            Wadendrücken.setBackgroundColor(Color.rgb(236,134,0));
            Wadendrückenbool = true;
        }

    }

}
