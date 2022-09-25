package com.example.intente_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText username;
SharedPreferences sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        Button btn_btn =(Button) findViewById(R.id.btn_btn);

        sp = getSharedPreferences("MyUserprefs", Context.MODE_PRIVATE);

        btn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                if (name.equals("SandeepSS") && pass.equals("2147130")){
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("username",name);
                        editor.commit();

//                    SharedPreferences.Editor spEditor = getSharedPreferences("com.example.values", MODE_PRIVATE).edit();
//                    spEditor.putString("username", name);
//                    spEditor.putString("password", pass);
//                    spEditor.apply();

//                    SharedPreferences sp = getSharedPreferences("com.example.values", MODE_PRIVATE);
//                    sp.getString("username", "null00");

                    Toast.makeText(MainActivity.this , "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(MainActivity.this,welcome.class);
                  intent.putExtra("keyname" , name);
                  startActivity(intent);
                  finish();
                }
                else
                    Toast.makeText(MainActivity.this , "LOGIN FAIL", Toast.LENGTH_SHORT).show();
            }
        });


    }
}