package com.walbogym.walbo.walbogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_trainieren extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Integer Einheit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainieren);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        createbuttons();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_trainieren, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_hauptmenü) {
            startActivity(new Intent(activity_trainieren.this, MainActivity.class));
        } else if (id == R.id.nav_übungen) {
            //startActivity(new Intent(activity_trainieren.this, .class));
        } else if (id == R.id.nav_trainingspläne) {
            startActivity(new Intent(activity_trainieren.this, trainignsplanActivity.class));
        } else if (id == R.id.nav_motivation) {
            startActivity(new Intent(activity_trainieren.this, activityMotivation.class));
        } else if (id == R.id.nav_kontakt) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createbuttons(){
        switch (Einheit){
            case 1:
                loadEinheit1Übungen();
                break;
            case 2:
                //loadEinheit2Übungen();
                break;
            case 3:
                //loadEinheit3Übungen();
                break;
            case 4:
                //loadEinheit4Übungen();
                break;
        }
    }

    private void loadEinheit1Übungen(){
        SharedPreferences myprefs = getApplicationContext().getSharedPreferences("trainingsplan1", 0);

        String trainingsplan = "Trainingsplan1Einheit1";
        String Bankdrücken = myprefs.getString((trainingsplan + "Bankdrücken"),"default");
        String Liegestütze = myprefs.getString((trainingsplan + "Liegestütze"),"default");
        String Butterfly = myprefs.getString((trainingsplan + "Butterfly"),"default");
        String Schulterdrücken = myprefs.getString((trainingsplan + "Schulterdrücken"),"default");
        String Seitheben = myprefs.getString((trainingsplan + "Seitheben"),"default");
        String Frontheben = myprefs.getString((trainingsplan + "Frontheben"),"default");
        String Seithebenkabel = myprefs.getString((trainingsplan + "Seithebenkabel"),"default");
        String Facepulls = myprefs.getString((trainingsplan + "Facepulls"),"default");
        String Trizepspushdowns = myprefs.getString((trainingsplan + "Trizepspushdowns"),"default");
        String Trizepsüberkopf = myprefs.getString((trainingsplan + "Trizepsüberkopf"),"default");
        String Bizepscurlskurzhantel = myprefs.getString((trainingsplan + "Bizepscurlskurzhantel"),"default");
        String Bizepscurlskabel = myprefs.getString((trainingsplan + "Bizepscurlskabel"),"default");
        String Bizepscurlslangkabel = myprefs.getString((trainingsplan + "Bizepscurlslangkabel"),"default");
        String Bizepscurlslanghantel = myprefs.getString((trainingsplan + "Bizepscurlslanghantel"),"default");
        String Latziehen = myprefs.getString((trainingsplan + "Latziehen"),"default");
        String Klimmzüge = myprefs.getString((trainingsplan + "Klimmzüge"),"default");
        String Beinpresse = myprefs.getString((trainingsplan + "Beinpresse"),"default");
        String Kreuzheben = myprefs.getString((trainingsplan + "Kreuzheben"),"default");
        String Beinbeuger = myprefs.getString((trainingsplan + "Beinbeuger"),"default");
        String Beincurls = myprefs.getString((trainingsplan + "Beincurls"),"default");
        String Wadendrücken = myprefs.getString((trainingsplan + "Wadendrücken"),"default");

        if (Bankdrücken.equals("true"))createButton("Bankdrücken");
        if (Liegestütze.equals("true"))createButton("Liegestütze");
        if (Butterfly.equals("true"))createButton("Butterfly");
        if (Schulterdrücken.equals("true"))createButton("Schulterdrücken");
        if (Seitheben.equals("true"))createButton("Seitheben");
        if (Frontheben.equals("true"))createButton("Frontheben");
        if (Seithebenkabel.equals("true"))createButton("Seitheben Kabelzug");
        if (Facepulls.equals("true"))createButton("Facepulls");
        if (Trizepspushdowns.equals("true"))createButton("Trizepspushdowns");
        if (Trizepsüberkopf.equals("true"))createButton("Trizepsüberkopf ziehen");
        if (Bizepscurlskurzhantel.equals("true"))createButton("Bizepscurls Kurzhantel");
        if (Bizepscurlskabel.equals("true"))createButton("Bizepscurls Kabelzug Kurzgriff");
        if (Bizepscurlslangkabel.equals("true"))createButton("Bizepscurls Kabelzug Langgriff");
        if (Bizepscurlslanghantel.equals("true"))createButton("Bizepscurls Langhantel");
        if (Latziehen.equals("true"))createButton("Latziehen");
        if (Klimmzüge.equals("true"))createButton("Klimmzüge");
        if (Beinpresse.equals("true"))createButton("Beinpresse");
        if (Kreuzheben.equals("true"))createButton("Kreuzheben");
        if (Beinbeuger.equals("true"))createButton("Beinbeuger");
        if (Beincurls.equals("true"))createButton("Beincurls");
        if (Wadendrücken.equals("true"))createButton("Wadendrücken");

    }

    private void createButton(final String btnText){
        LinearLayout layoutübungswahl = (LinearLayout)findViewById(R.id.LinearLayoutÜbungswahl);
        final Button Übungbtn = new Button(this);
        Übungbtn.setText(btnText);
        layoutübungswahl.addView(Übungbtn);

        Übungbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_trainieren.this, activity_trainingubung.class));
                activity_trainingubung.aktuelleübung = Übungbtn.getText().toString();
            }
        });

    }
}
