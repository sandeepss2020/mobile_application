package com.example.lab7_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        Button btnandroid = findViewById(R.id.btn_android);
        Button btnml = findViewById(R.id.btn_ml);
        Button btndekr = findViewById(R.id.btn_dekr);
        Button btnnlp = findViewById(R.id.btn_nlp);

        btnandroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                fragmentManager.beginTransaction()
////                        .replace(R.id.fragment_container, ExampleFragment.class, null)
////                        .setReorderingAllowed(true)
////                        .addToBackStack("name") // name can be null
////                        .commit();

                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,frag_android.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

        btnml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,frag_ml.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

        btndekr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,frag_dekr.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

        btnnlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,frag_nlp.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });
}
}