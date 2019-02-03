/*package com.ellehacks2019.android.link;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class LinkActivity extends AppCompatActivity {

    private ArrayList<String> jobImageList;
    private ArrayAdapter<String> arrayAdapter;
    private ImageView jobCard;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        jobImageList = new ArrayList<>();
        jobImageList.add("job1.png");
        jobImageList.add("job2.png");
        jobImageList.add("job3.png");
        jobImageList.add("job4.png");
        jobImageList.add("job5.png");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.joblist, jobImageList);

        jobCard = (ImageView) findViewById(R.id.job_card_image_view);
        ImageButton mSwipeLeftButton = (ImageButton) findViewById(R.id.swipe_left_button);
        ImageButton mSwipeRightButton = (ImageButton) findViewById(R.id.swipe_right_button);

        mSwipeLeftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View button, MotionEvent event) {
                ImageButton leftButton = (ImageButton) button;
                leftButton.setSelected(!leftButton.isSelected());

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        leftButton.setImageResource(R.drawable.test);
                        switchCard();
                        return true;
                    case MotionEvent.ACTION_UP:
                        leftButton.setImageResource(R.drawable.test);
                        return true;
                }
                return false;
            }
        });

        mSelectEmployerButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View button, MotionEvent event) {
                ImageButton employeeButton = (ImageButton) button;
                employeeButton.setSelected(!employeeButton.isSelected());

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        employeeButton.setImageResource(R.drawable.employer_button_press);
                        Intent intent = new Intent(SelectUserActivity.this, LoginActivity.class);
                        startActivity(intent);
                        return true;
                    case MotionEvent.ACTION_UP:
                        employeeButton.setImageResource(R.drawable.employer_button);
                        return true;
                }
                return false;
            }
        });
    }

    protected class swipeButtonListener implements View.OnTouchListener {
        private final static String SWIPE_LEFT_ID = "swipe_left_button";
        private final static String SWIPE_RIGHT_ID = "swipe_right_button";

        @Override
        protected boolean onTouch(View v, MotionEvent event) {
            ImageButton swipeButton = (ImageButton) v;
            swipeButton.setSelected(!swipeButton.isSelected());

            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    swipeButton.setImageResource(R.drawable.test); //pressed
                    switchCard();
                    return true;
                case MotionEvent.ACTION_UP:
                    swipeButton.setImageResource(R.drawable.test); //not pressed
                    return true;
            }

            String buttonId = v.getResources().getResourceName(v.getId());
            if (buttonId.equals(SWIPE_LEFT_ID)) {

            } else if (buttonId.equals(SWIPE_RIGHT_ID)) {
                // possible match?
            }
            return false;
        }

        protected void switchCard () {
            // switch cards!
            return;
        }
    }
}
*/