package com.example.cat3_2147130;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cat3_2147130.Adapters.courseadapter;
import com.example.cat3_2147130.Clases.RecyclerItemClickListener;
import com.example.cat3_2147130.Models.coursemodel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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


        list.add(new coursemodel(R.drawable.book1,"Android_JAVA"));
        list.add(new coursemodel(R.drawable.book2,"Python"));
        list.add(new coursemodel(R.drawable.book3,"C++"));
        list.add(new coursemodel(R.drawable.book4,"Operating System"));
        list.add(new coursemodel(R.drawable.book5,"Networking"));
        list.add(new coursemodel(R.drawable.book6,"Java"));
        list.add(new coursemodel(R.drawable.book7,"Software Engineering"));
        list.add(new coursemodel(R.drawable.book8,"Data Analytics"));
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
                        Intent intent =new Intent(MainActivity2.this , MainActivity3.class);
                        startActivity(intent);
                        break;

                    default:

                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity2.this, "Click once to get to know", Toast.LENGTH_SHORT).show();
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
