package com.example.snaps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NovaIgraActivity extends AppCompatActivity {

    Button Igr1;
    Button Igr2;
    Button IgraButton;
    Button ZvanjaButton;
    Button BackButton;
    Button ConfirmButton;

    int igr1score = 0;
    int igr2score = 0;
    boolean igra = true;
    boolean zvanje = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_igra);

        Igr1 = (Button)findViewById(R.id.Igr1);
        Igr2 = (Button)findViewById(R.id.Igr2);
        IgraButton = (Button)findViewById(R.id.Igra_button);
        ZvanjaButton = (Button)findViewById(R.id.Zvanja_button);
        BackButton = (Button)findViewById(R.id.back_button);
        ConfirmButton = (Button)findViewById(R.id.confirm_button);

        pocetakIgre();

        Igr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(igra == true) {
                    showDialog1();
                } else if(igra == false){
                    //dijalog za zvanja 1
                }
            }
        });

        Igr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(igra == true) {
                    showDialog2();
                } else if(igra == false){
                    //dijalog za zvanja 2
                }
            }
        });

        IgraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IgraButton.setBackgroundColor(Color.parseColor("#134C16"));
                ZvanjaButton.setBackgroundColor(Color.parseColor("#000000"));
                igra = true;
                zvanje = false;
            }
        });

        ZvanjaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZvanjaButton.setBackgroundColor(Color.parseColor("#134C16"));
                IgraButton.setBackgroundColor(Color.parseColor("#000000"));
                igra = false;
                zvanje = true;
            }
        });

        ConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                krajIgre();
            }
        });
    }

    private void pocetakIgre(){
        Igr1.setText(String.valueOf(igr1score));
        Igr2.setText(String.valueOf(igr2score));
        IgraButton.setBackgroundColor(Color.parseColor("#134C16"));
    }

    private void showDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Unesite broj");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Igr1.setText(input.getText().toString());
                String val = input.getText().toString();
                igr1score = Integer.parseInt(val);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void showDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Unesite broj");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Igr2.setText(input.getText().toString());
                String val = input.getText().toString();
                igr2score = Integer.parseInt(val);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void krajIgre() {
        if(igr1score>igr2score){
            if(igr1score>=66 && igr2score>=66){
                //igr1 ide za 1
            } else if(igr1score>=66 && (igr2score>=33 && igr2score<66)){
                //igr1 ide za 1
            } else if(igr1score>=66 && (igr2score>0 && igr2score<33)){
                //igr1 ide za 2
            } else if(igr1score>=66 && (igr2score==0)){
                //igr1 ide za 3
            }
        } else if(igr2score>igr1score){
            if(igr2score>=66 && igr1score>=66){
                //igr2 ide za 1
            } else if(igr2score>=66 && (igr1score>=33 && igr1score<66)){
                //igr2 ide za 1
            } else if(igr2score>=66 && (igr1score>0 && igr1score<33)){
                //igr2 ide za 2
            } else if(igr2score>=66 && (igr1score==0)){
                //igr2 ide za 3
            }
        } else if(igr1score == igr2score){
            //ne znam
        }
        prebaciActivity();
    }

    private void prebaciActivity() {
        Intent i = new Intent(NovaIgraActivity.this, GameActivity.class);
        //prebaciti info od igraca i smanjiti score
        startActivity(i);
    }
}