package com.example.lab9_recyclerview.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab9_recyclerview.MainActivity;
import com.example.lab9_recyclerview.MainActivity2;
import com.example.lab9_recyclerview.MainActivity3;
import com.example.lab9_recyclerview.Models.coursemodel;
import com.example.lab9_recyclerview.R;

import java.time.MonthDay;
import java.util.ArrayList;

public class courseadapter extends RecyclerView.Adapter<courseadapter.viewHolder>{
    public ArrayList<coursemodel> list;
    Context context;


    public courseadapter(ArrayList<coursemodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public courseadapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_course,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull courseadapter.viewHolder holder, int position) {

        coursemodel model = list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"Clicked Item",Toast.LENGTH_SHORT).show();
//            }
//        });

        switch (position){
            case 0:
                    holder.imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"Clicked Item 1 Image",Toast.LENGTH_SHORT).show();
                        }
                    });

                    holder.textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"C1 Text Seleceted",Toast.LENGTH_SHORT).show();
                        }
                    });
                break;

            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Clicked Item 2 Image",Toast.LENGTH_SHORT).show();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"C2 Text Seleceted",Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case  2:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), MainActivity3.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getContext().startActivity(intent);
                    }
                });
                break;
            default:

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.bookimg);
            textView = itemView.findViewById(R.id.booktxt);

        }
    }
}
