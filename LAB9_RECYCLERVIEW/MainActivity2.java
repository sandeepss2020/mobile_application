package com.example.lab9_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab9_recyclerview.Adapters.courseadapter;
import com.example.lab9_recyclerview.Models.coursemodel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView2;
     FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView2 = findViewById(R.id.recyclerview);
        btn = findViewById(R.id.floatingActionButton);

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
        recyclerView2.setAdapter(adapter);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView2.setLayoutManager(gridLayoutManager);

        StaggeredGridLayoutManager stagger = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL); //horizontal
        recyclerView2.setLayoutManager(stagger);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursemodel objnew = new coursemodel(R.drawable.lab9_10,"New Added");
                adapter.list.add(objnew);
                adapter.notifyItemInserted(adapter.getItemCount() - 1);
            }
        });



//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, recyclerView2.HORIZONTAL,true);
//        recyclerView2.setLayoutManager(layoutManager);
    }
}