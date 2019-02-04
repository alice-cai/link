package com.ellehacks2019.android.link;

import android.app.Activity;
import android.app.Notification;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;


public class MatchActivity extends Activity {

    public static final String CHANNEL_1_ID = "matchnotif";

    private Integer images [] = {R.drawable.job1, R.drawable.job2, R.drawable.job3, R.drawable.job4, R.drawable.job5};
    private int currImage = 0;
    private int numSwipes = 0;
    private NotificationManagerCompat notificationManager;

    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        initializeImageSwitcher();
        setInitialImage();
        setImageRotateListener();

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void sendOnChannel1() {
        String title = "New Link!";
        String message = "You have been matched with Accenture for the DevOps Specialist position.";
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_link)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.notif_icon))
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(message))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[] {1000, 1000, 1000})
                .build();

        notificationManager.notify(1, notification);
    }


    private void initializeImageSwitcher() {
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MatchActivity.this);
                return imageView;
            }});

        //imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MatchActivity.this, android.R.anim.slide_in_left));
        //imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MatchActivity.this, android.R.anim.slide_out_right));
    }

    private void setImageRotateListener() {
        final Button swipeLeftButton = (Button) findViewById(R.id.swipe_left_button);
        swipeLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MatchActivity.this, R.anim.slide_in_right));
                imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MatchActivity.this, R.anim.slide_out_left));

                currImage++;
                if(currImage == 5) {
                    currImage = 0;
                }
                setCurrentImage();
            }
        });

        final Button swipeRightButton = (Button) findViewById(R.id.swipe_right_button);
        swipeRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MatchActivity.this, android.R.anim.slide_in_left));
                imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MatchActivity.this, android.R.anim.slide_out_right));

                numSwipes++;
                if (numSwipes == 3) {
                    numSwipes = 0;
                    sendOnChannel1();
                }

                currImage++;
                if(currImage == 5) {
                    currImage = 0;
                }
                setCurrentImage();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
    }

    private void setCurrentImage() {
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setImageResource(images[currImage]);
    }
}