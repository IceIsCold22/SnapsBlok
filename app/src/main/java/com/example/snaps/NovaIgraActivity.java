package com.example.snaps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
    Button ZadnjiStihButton;

    public static int igr1score = 0;
    public static int igr2score = 0;
    int igr1zvanje = 0;
    int igr2zvanje = 0;
    boolean igra = true;
    boolean zvanje = false;
    boolean zadnjistihigr1 = true;
    boolean zadnjistihigr2 = false;

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
        ZadnjiStihButton = (Button)findViewById(R.id.zadnjiStihButton);

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
                ZvanjaButton.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                igra = true;
                zvanje = false;
            }
        });

        ZvanjaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZvanjaButton.setBackgroundColor(Color.parseColor("#134C16"));
                IgraButton.setBackgroundColor(Color.parseColor("#00FFFFFF"));
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

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prebaciActivity();
            }
        });

        ZadnjiStihButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = {"Igrač 1", "Igrač 2"};
                final ArrayList itemsSelected = new ArrayList();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(NovaIgraActivity.this);
                alertDialog.setTitle("Tko je imao zadnji štih?");
                int checkedItem = 1;
                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                zadnjistihigr1 = true;
                                zadnjistihigr2 = false;
                                break;
                            case 1:
                                zadnjistihigr1 = false;
                                zadnjistihigr2 = true;
                                break;
                        }
                    }
                });
                alertDialog.setPositiveButton("Potvrdi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialog.setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();
            }
        });
    }

    private void pocetakIgre(){
        Igr1.setText(String.valueOf(igr1score));
        Igr2.setText(String.valueOf(igr2score));
        igr1score = 0;
        igr2score = 0;
    }

    private void showDialog1() {
        if(igra == true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Unesite broj");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);

            builder.setPositiveButton("Potvrdi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr1score = Integer.parseInt(val) + igr1zvanje;
                    Igr1.setText(String.valueOf(igr1score));
                    System.out.println(igr1score);
                }
            });

            builder.setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
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

            builder.setPositiveButton("Potvrdi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr1zvanje = Integer.parseInt(val);
                    igr1score += igr1zvanje;
                    Igr1.setText(String.valueOf(igr1score));
                    System.out.println(igr1score);
                }
            });

            builder.setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
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

            builder.setPositiveButton("Potvrdi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr2score = Integer.parseInt(val) + igr2zvanje;
                    Igr2.setText(String.valueOf(igr2score));
                    System.out.println(igr2score);
                }
            });

            builder.setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
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

            builder.setPositiveButton("Potvrdi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String val = input.getText().toString();
                    igr2zvanje = Integer.parseInt(val);
                    igr2score += igr2zvanje;
                    Igr2.setText(String.valueOf(igr2score));
                    System.out.println(igr2score);
                }
            });

            builder.setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
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
                } else if(igr1score >= 33 && igr2score>=33){
                    igr1duljina--;
                } else if (igr1score >= 33 && (igr2score >= 0 && igr2score < 33)){
                    igr1duljina--;
                } else if(igr1score == 0) { igr2score+=3; }
        } else if(igr2score>igr1score){
            if(igr2score>=66 && igr1score>=66){
                igr2duljina--;
            } else if(igr2score>=66 && (igr1score>=33 && igr1score<66)){
                igr2duljina--;
            } else if(igr2score>=66 && (igr1score>0 && igr1score<33)){
                igr2duljina-=2;
            } else if(igr2score>=66 && (igr1score==0)){
                igr2duljina-=3;
            } else if(igr2score >= 33 && igr1score>=33){
                igr2duljina--;
            } else if (igr2score >= 33 && (igr1score >= 0 && igr1score < 33)){
                igr2duljina--;
            } else if (igr2score == 0) { igr1score+=3; }
        } else if(igr1score == igr2score){
            if(zadnjistihigr1 == true){
                igr1duljina--;
            } else {
                igr2duljina--;
            }
        }
        prebaciActivity();
    }

    private void prebaciActivity() {
        Intent i = new Intent(NovaIgraActivity.this, GameActivity.class);
        NovaIgraActivity.this.finish();
        startActivity(i);
    }
}