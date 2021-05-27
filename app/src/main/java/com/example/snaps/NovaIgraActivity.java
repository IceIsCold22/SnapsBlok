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


    public static int igr1score = 0;
    public static int igr2score = 0;
    int igr1zvanje = 0;
    int igr2zvanje = 0;
    boolean igra = true;
    boolean zvanje = false;

    public static int igr1duljina = SnapsActivity.brojigre;
    public static int igr2duljina = SnapsActivity.brojigre;

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
                showDialog1();
            }
        });

        Igr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog2();
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
        if(igra == true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Unesite broj");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);

            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr1score = Integer.parseInt(val) + igr1zvanje;
                    Igr1.setText(String.valueOf(igr1score));
                    System.out.println(igr1score);
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        } else if(zvanje == true){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Unesite broj");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);

            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr1zvanje = Integer.parseInt(val);
                    igr1score += igr1zvanje;
                    Igr1.setText(String.valueOf(igr1score));
                    System.out.println(igr1score);
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
    }

    private void showDialog2() {
        if(igra == true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Unesite broj");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);

            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr2score = Integer.parseInt(val) + igr2zvanje;
                    Igr2.setText(String.valueOf(igr2score));
                    System.out.println(igr2score);
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        } else if(zvanje == true){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Unesite broj");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);

            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr2zvanje = Integer.parseInt(val);
                    igr2score += igr2zvanje;
                    Igr2.setText(String.valueOf(igr2score));
                    System.out.println(igr2score);
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
    }

    private void krajIgre() {
        if(igr1score>igr2score){
                if (igr1score >= 66 && igr2score >= 66) {
                    igr1duljina--;
                } else if (igr1score >= 66 && (igr2score >= 33 && igr2score < 66)) {
                    igr1duljina--;
                } else if (igr1score >= 66 && (igr2score > 0 && igr2score < 33)) {
                    igr1duljina -= 2;
                } else if (igr1score >= 66 && (igr2score == 0)) {
                    igr1duljina -= 3;
                }
        } else if(igr2score>igr1score){
            if(igr2score>=66 && igr1score>=66){
                igr2duljina--;
            } else if(igr2score>=66 && (igr1score>=33 && igr1score<66)){
                igr2duljina--;
            } else if(igr2score>=66 && (igr1score>0 && igr1score<33)){
                igr2duljina-=2;
            } else if(igr2score>=66 && (igr1score==0)){
                igr2duljina-=3;
            }
        } else if(igr1score == igr2score){
            //ne znam
        }
        prebaciActivity();
    }

    private void prebaciActivity() {
        Intent i = new Intent(NovaIgraActivity.this, GameActivity.class);
        NovaIgraActivity.this.finish();
        startActivity(i);
    }
}