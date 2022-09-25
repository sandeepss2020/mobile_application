package com.example.input_controls_p6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox ch1,ch2,ch3,ch4,ch5,ch6;
    private RadioGroup rb_grp;
    private RadioButton rb_gender;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        FloatingActionButton fab = findViewById(R.id.flt_btn);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer result = new StringBuffer();
                result.append("Courses Selected : \n");
                if (ch1.isChecked()){
                    result.append(ch1.getText().toString()).append("\n");
                }
                if (ch2.isChecked()){
                    result.append(ch2.getText().toString()).append("\n");
                }
                if (ch3.isChecked()){
                    result.append(ch3.getText().toString()).append("\n");
                }
                if (ch4.isChecked()){
                    result.append(ch4.getText().toString()).append("\n");
                }
                if (ch5.isChecked()){
                    result.append(ch5.getText().toString()).append("\n");
                }
                if (ch6.isChecked()){
                    result.append(ch6.getText().toString()).append("\n");
                }

                int gender = rb_grp.getCheckedRadioButtonId();
                rb_gender = findViewById(gender);

                if (rb_gender!=null){
                    result.append("\n Gender: \n").append(rb_gender.getText().toString());
                }

                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG)
                        .show();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (switch1.isChecked()){
                    Toast toast = Toast.makeText(MainActivity.this,"Congo!! Hackathon Selected",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(MainActivity.this,"See you Next Time",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }
        });


    }

    private void init()
    {
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);
        ch6 = findViewById(R.id.ch6);

        rb_grp = findViewById(R.id.rb_grp);
        switch1 =findViewById(R.id.switch1);

    }
}