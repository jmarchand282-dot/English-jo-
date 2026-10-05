package com.josephmarchand.englishjoe.notifications;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.josephmarchand.englishjoe.MainActivity;
import com.josephmarchand.englishjoe.R;

public class NotificationManager {

    public static final String CHANNEL_ID = "english_joe_learning";

    private final Context context;

    public NotificationManager(Context context) {
        this.context = context.getApplicationContext();
        createChannel();
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "English Joe",
                    android.app.NotificationManager.IMPORTANCE_DEFAULT
            );

            channel.setDescription("Rappels et notifications d'apprentissage English Joe");

            android.app.NotificationManager manager =
                    (android.app.NotificationManager)
                            context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    public void showLearningReminder() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }

        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                100,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
                        | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_english_joe)
                        .setContentTitle("English Joe")
                        .setContentText("C'est le moment d'apprendre l'anglais !")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(
                                        "Quelques minutes d'anglais aujourd'hui " +
                                        "peuvent faire progresser ton niveau. " +
                                        "Ouvre English Joe et continue ton parcours."
                                ))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);

        NotificationManagerCompat.from(context)
                .notify(1001, builder.build());
    }
              }
