package com.example.lab9_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lab9_recyclerview.Adapters.courseadapter;
import com.example.lab9_recyclerview.Clases.RecyclerItemClickListener;
import com.example.lab9_recyclerview.Models.coursemodel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
//    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
//        imageView = findViewById(R.id.bookimg);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//                startActivity(intent);
//            }
//        });



        ArrayList<coursemodel> list = new ArrayList<>();
        list.add(new coursemodel(R.drawable.lab9_1,"Android_JAVA"));
        list.add(new coursemodel(R.drawable.lab9_2,"Python"));
        list.add(new coursemodel(R.drawable.lab9_3,"C++"));
        list.add(new coursemodel(R.drawable.lab9_4,"Operating System"));
        list.add(new coursemodel(R.drawable.lab9_5,"Networking"));
        list.add(new coursemodel(R.drawable.lab9_6,"Java"));
        list.add(new coursemodel(R.drawable.lab9_7,"Software Engineering"));
        list.add(new coursemodel(R.drawable.lab9_8,"Data Analytics"));
        list.add(new coursemodel(R.drawable.lab9_9,"HED"));

        courseadapter adapter = new courseadapter(list, this);
        recyclerView.setAdapter(adapter);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, recyclerView.HORIZONTAL,true);
//        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                            Intent intent =new Intent(MainActivity.this , MainActivity2.class);
                            startActivity(intent);
                        break;

                    default:

                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Click once to get to know", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:

                        break;
                    default:
                }
            }
        }
        ));

    }


}