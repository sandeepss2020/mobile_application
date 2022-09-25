package com.example.input_controls_p6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button next;
    private ConstraintLayout layout2;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = findViewById(R.id.spinner);
        next = findViewById(R.id.next);
        layout2 = findViewById(R.id.layout2);
        toggleButton = findViewById(R.id.toggleButton);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity2.this,"Have You Agreed Terms and Conditions",Toast.LENGTH_SHORT).show();
                }

            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()){
                    Snackbar.make(layout2,"Submitted Data", Snackbar.LENGTH_INDEFINITE)
                        .setTextColor(Color.CYAN)
                        .setBackgroundTint(Color.BLACK)
                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        })
                        .setActionTextColor(Color.RED).show();
                }
            else{
                    Snackbar.make(layout2,"Please Agree T&C", Snackbar.LENGTH_INDEFINITE)
                            .setTextColor(Color.CYAN)
                            .setBackgroundTint(Color.BLACK)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(Color.RED).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),choice,Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}