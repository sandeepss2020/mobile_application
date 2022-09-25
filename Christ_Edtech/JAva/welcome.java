package com.example.intente_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class welcome extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView name = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        String username = getIntent().getStringExtra("keyname");

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserprefs", Context.MODE_PRIVATE);
        String usrnm = sp.getString("username","");
        name.setText(usrnm);

        Button btn_teacher = (Button) findViewById(R.id.btn_teacher);
//        name.setText(username);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(welcome.this,about_us.class);
//                startActivity(intent);
                showPopup(view);
            }
        });

        btn_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this,teacher_list.class);
                startActivity(intent);
            }
        });


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        ImageView imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcome.this,get_details_form.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.firstpage_menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText(this,"Returned to Home Page" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(welcome.this,welcome.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.search:
//                Toast.makeText(this,"Searching..." , Toast.LENGTH_SHORT).show();
                Intent intent_course = new Intent(welcome.this,fragment_main.class);
                startActivity(intent_course);
                return true;

            case R.id.profile:
                Toast.makeText(this,"Details" , Toast.LENGTH_SHORT).show();
                new MaterialAlertDialogBuilder(welcome.this)
                        .setTitle("Details")
                        .setMessage("Name : SandeepSS\n " +
                                "Age: 22 \nCourse : MCA")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                return true;

            case R.id.about:
//                Toast.makeText(this,"Go to Settings " , Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(welcome.this,about_us.class);
                startActivity(intent3);

                return true;

            case R.id.more:
//                Toast.makeText(this,"" , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.logout:
                Toast.makeText(this,"Logged Out" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
                return true;

            case R.id.location:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("geo:12.9393585,77.5940298"));
                startActivity(intent1);
                return true;

            case R.id.phone:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:+91976543210"));
                startActivity(intent2);
                return true;

            case R.id.camera:
                Intent intentabout = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentabout);
                return true;


            case R.id.message:

                Intent intent4 = new Intent(Intent.ACTION_SENDTO);
                intent4.setData(Uri.parse("mailto:ok@christuniversity.in"));
                startActivity(intent4);

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.item2_1:
                Toast toast = Toast.makeText(this,"Marks in Java : 80/100",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,1,1);
                toast.show();
                return true;

            case R.id.item2_2:
                Toast toast1 = Toast.makeText(this,"Marks in C : 75/100",
                        Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER,0,0);
                toast1.show();
                return true;

            case R.id.item2_3:
                Toast toast3 = Toast.makeText(this,"Marks in Python : 81/100",
                        Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.CENTER,1,1);
                toast3.show();
                return true;

            case R.id.item2_4:
                Toast toast4 = Toast.makeText(this,"Marks in Android : 79/100",
                        Toast.LENGTH_SHORT);
                toast4.setGravity(Gravity.CENTER,1,1);
                toast4.show();
                return true;

            case R.id.item2_5:
                Toast toast5 = Toast.makeText(this,"Marks in Web Development : 88/100",
                        Toast.LENGTH_SHORT);
                toast5.setGravity(Gravity.CENTER,1,1);
                toast5.show();
                return true;

            default:
                return false;
        }
    }

}