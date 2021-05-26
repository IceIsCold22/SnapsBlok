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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rezultatLista = (ListView)findViewById(R.id.rezultatLista);
        txtv = (TextView)findViewById(R.id.Igr1txt);
        newgamebutton = (Button)findViewById(R.id.newgamebutton);



        ArrayList<String> novaLista = new ArrayList<>();

        novaLista.add("bezveze");
        novaLista.add("glupost");
        novaLista.add("1,2,3");
        novaLista.add("adsasd");

        ArrayAdapter novaListaAdapter = new ArrayAdapter<String>(this, R.layout.textview, novaLista);

        rezultatLista.setAdapter(novaListaAdapter);

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
}