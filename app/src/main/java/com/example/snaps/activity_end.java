package com.example.snaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_end extends AppCompatActivity {

    TextView winnerTView;
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        winnerTView = (TextView)findViewById(R.id.winnerTView);
        returnButton = (Button)findViewById(R.id.returnButton);

        if(GameActivity.pobjednik == 1){
            winnerTView.setText("Igrač 1 je pobjednik! " + "Rezultat je " + NovaIgraActivity.igr1duljina + "/" + NovaIgraActivity.igr2duljina);
        } else if(GameActivity.pobjednik == 2){
            winnerTView.setText("Igrač 2 je pobjednik! " + "Rezultat je " + NovaIgraActivity.igr1duljina + "/" + NovaIgraActivity.igr2duljina);
        }

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_end.this, MainActivity.class);
                activity_end.this.finish();
                startActivity(i);
            }
        });
    }
}