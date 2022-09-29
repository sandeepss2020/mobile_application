package com.example.cat3_2147130;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String ACTION_UPDATE_NOTIFICATION =
                "com.android.example.notifyme.ACTION_UPDATE_NOTIFICATION";
        // Notification channel ID.
        final String PRIMARY_CHANNEL_ID =
                "primary_notification_channel";
        // Notification ID.
        final int NOTIFICATION_ID = 0;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        FragmentManager fragmentManager = getSupportFragmentManager();
        Button btnandroid = findViewById(R.id.btn_android);
        Button btnml = findViewById(R.id.btn_ml);
        Button btndekr = findViewById(R.id.btn_dekr);
        Button btnnlp = findViewById(R.id.btn_nlp);
        Button btn_next = findViewById(R.id.btn_nxt);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnandroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, frag_android.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

        btnml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, frag_ml.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

        btndekr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, frag_dekr.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

        btnnlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, frag_nlp.class, null)
                        .setReorderingAllowed(true).addToBackStack("add").commit();
            }
        });

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("myCh", "Mychannel", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.person_icon))
//                .setSmallIcon(R.drawable.notificationss)
//                .setContentTitle("Heyaa SAandeep SS")
//                .setContentText("Course 4 MCA-A");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "Welcome Back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;


            case R.id.profile:
                Toast.makeText(this, "Details", Toast.LENGTH_SHORT).show();
                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Details")
                        .setMessage("Name : Mr. SS\n " +
                                "Age: 24 \nCourse : MCA")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                return true;


            case R.id.more:
//                Toast.makeText(this,"" , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.logout:
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
                finish();
                return true;


            case R.id.phone:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:+91976543210"));
                startActivity(intent2);
                return true;


            case R.id.message:
                Intent intent4 = new Intent(Intent.ACTION_SENDTO);
                intent4.setData(Uri.parse("mailto:ok@christuniversity.in"));
                startActivity(intent4);

            case R.id.noti:
                notificationManagerCompat.notify(1, notification);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    }

