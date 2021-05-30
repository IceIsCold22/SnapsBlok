package com.example.snaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    ListView rezultatLista;
    TextView txtv;
    Button newgamebutton;
    TextView igr1scoretxt;
    TextView igr2scoretxt;

    NovaIgraActivity ni = new NovaIgraActivity();


    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rezultatLista = (ListView)findViewById(R.id.rezultatLista);
        txtv = (TextView)findViewById(R.id.Igr1txt);
        newgamebutton = (Button)findViewById(R.id.newgamebutton);
        igr1scoretxt = (TextView) findViewById(R.id.igr1score);
        igr2scoretxt = (TextView) findViewById(R.id.igr2score);


        ArrayList<String> novaLista = new ArrayList<>();
        ArrayAdapter novaListaAdapter = new ArrayAdapter<String>(this, R.layout.textview, novaLista);
        rezultatLista.setAdapter(novaListaAdapter);
        pocetakIgre(novaLista, novaListaAdapter);

        newgamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGameFunction();
            }
        });
    }

    private void newGameFunction(){
        Intent i = new Intent(GameActivity.this, NovaIgraActivity.class);
        startActivity(i);
    }

    public void updateScores(ArrayList<String> novaLista, ArrayAdapter novaListaAdapter){
        novaLista.add(counter,"Igrač 1: " + ni.igr1score + " Igrač 2: " + ni.igr2score + " Rezultat: " + ni.igr1duljina + "/" + ni.igr2duljina);
        counter++;
    }

    private void pocetakIgre(ArrayList<String> novaLista, ArrayAdapter novaListaAdapter){
        igr1scoretxt.setText(String.valueOf(ni.igr1duljina));
        igr2scoretxt.setText(String.valueOf(ni.igr2duljina));
        updateScores(novaLista, novaListaAdapter);
    }


}