package com.example.snaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SnapsActivity extends AppCompatActivity {

    TextInputLayout txtInput;
    TextInputEditText txtHint;
    Button doneButton;

    public static int brojigre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snaps);

        txtInput = (TextInputLayout)findViewById(R.id.textInputLayout2);
        txtHint = (TextInputEditText)findViewById(R.id.textInputEditText);
        doneButton = (Button)findViewById(R.id.donebutton);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String txt = txtInput.getEditText().getText().toString().trim();
               if(txt.equals("7") || txt.equals("9")) {
                   SnapsActivity.brojigre = Integer.valueOf(txt);
                   Intent i = new Intent(SnapsActivity.this, GameActivity.class);
                   startActivity(i);
                } else System.out.println("Unijeli ste krivi broj!");
            }
        });
    }
}