package com.example.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.ShareCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID1 = "Opening";
    private final String CHANNEL_ID2 = "Monday : 09:00 to 16:00\nWednesday : 09:00 to 16:00\nSaturday : 09:00 to 13:00";
    private final String CHANNEL_ID3 = "Click to Open Image";
    private final int NOTIFICATION_ID = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void basicNotify(View view) {


        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, notificationIntent.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        createNotificationChannel(CHANNEL_ID1);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID1)
            .setSmallIcon(R.drawable.ic_notification_message)
            .setContentTitle("Checked Now")
            .setContentText("Office is Open Now...")
            .setContentIntent(resultPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void headsUpNotify(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel02", "name",
                    NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("Timings are");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(this, "channel02")
                .setSmallIcon(R.drawable.ic_notification_important)
                .setContentTitle("Checking Time")
                .setContentText("The available Office Timing are : \n" + CHANNEL_ID2)
                .setDefaults(Notification.DEFAULT_ALL)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, notification);
    }

    public void expandableNotify(View view) {
        createNotificationChannel(CHANNEL_ID3);

        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, notificationIntent.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        BroadcastReceiver brCopy = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(getApplicationContext(), "Copied!", Toast.LENGTH_LONG).show();
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.example.ACTION_COPY");
        getApplicationContext().registerReceiver(brCopy, intentFilter);

        Intent copy = new Intent("com.example.ACTION_COPY");
        PendingIntent piCopy = PendingIntent.getBroadcast(getApplicationContext(), 0, copy, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this, CHANNEL_ID3)
            .setSmallIcon(R.drawable.ic_post)
            .setContentTitle("View College Front Image")
            .setContentText("Tap to view post, Click on the notification to Open image")
            .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon3))
            .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.icon3)).bigLargeIcon(null))
            .addAction(R.drawable.ic_copy_foreground, "Copy Image", piCopy)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(resultPendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel(String CHANNEL) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}