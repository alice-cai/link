package com.ellehacks2019.android.link;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;


public class LinkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_link, container, false);

        ImageButton mGoToMatchingButton = view.findViewById(R.id.go_to_matching_button);

        mGoToMatchingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MatchActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}


/*
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class LinkFragment extends Fragment {
    protected static final int[] jobImageList = {
            R.drawable.job1,
            R.drawable.job2,
            R.drawable.job3,
            R.drawable.job4,
            R.drawable.job5
    };

    protected ImageView jobCard;
    protected int swipeCount = 0;
    protected int jobIndex = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_link, container, false);

        jobCard = (ImageView) view.findViewById(R.id.job_card_image_view);
        ImageButton mSwipeLeftButton = (ImageButton) view.findViewById(R.id.swipe_left_button);
        ImageButton mSwipeRightButton = (ImageButton) view.findViewById(R.id.swipe_right_button);

        SwipeButtonListener listener = new SwipeButtonListener();

        mSwipeLeftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View button, MotionEvent event) {
                ImageButton button = (ImageButton) button;
                button.setSelected(!studentButton.isSelected());

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        studentButton.setImageResource(R.drawable.left_button_pressed);
                        return true;
                    case MotionEvent.ACTION_UP:
                        studentButton.setImageResource(R.drawable.left_button);
                        return true;
                }
                return false;
            }
        });

        mSwipeRightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View button, MotionEvent event) {
                ImageButton studentButton = (ImageButton) button;
                studentButton.setSelected(!studentButton.isSelected());

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        studentButton.setImageResource(R.drawable.left_button_pressed);
                        return true;
                    case MotionEvent.ACTION_UP:
                        studentButton.setImageResource(R.drawable.left_button);
                        return true;
                }
                return false;
            }
        });

        return inflater.inflate(R.layout.fragment_link, container, false);
    }

    protected class SwipeButtonListener implements View.OnClickListener {
        private final static String SWIPE_LEFT_ID = "swipe_left_button";
        private final static String SWIPE_RIGHT_ID = "swipe_right_button";

        private final static String SWIPE_LEFT_MSG = "swipe_left_button";
        private final static String SWIPE_RIGHT_MSG = "swipe_right_button";

        @Override
        public boolean (View v, MotionEvent event) {
            ImageButton swipeButton = (ImageButton) v;
            swipeButton.setSelected(!swipeButton.isSelected());

            String buttonId = v.getResources().getResourceName(v.getId());

            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (buttonId.equals(SWIPE_LEFT_ID)) {
                        swipeButton.setImageResource(R.drawable.left_button_pressed);
                    } else if (buttonId.equals(SWIPE_RIGHT_ID)) {
                        swipeButton.setImageResource(R.drawable.right_button_pressed);
                    }
                    switchCard();
                    return true;
                case MotionEvent.ACTION_UP:
                    if (buttonId.equals(SWIPE_LEFT_ID)) {
                        swipeButton.setImageResource(R.drawable.left_button);
                    } else if (buttonId.equals(SWIPE_RIGHT_ID)) {
                        swipeButton.setImageResource(R.drawable.right_button);
                    }
                    return true;
            }

            if (buttonId.equals(SWIPE_LEFT_ID)) {
                swipeCount++;
                Toast matchToast = Toast.makeText(getActivity(), SWIPE_LEFT_MSG, Toast.LENGTH_SHORT);
                matchToast.show();
            } else if (buttonId.equals(SWIPE_RIGHT_ID)) {
                swipeCount++;
                Toast matchToast = Toast.makeText(getActivity(), SWIPE_RIGHT_MSG, Toast.LENGTH_SHORT);
                matchToast.show();
            }
            return false;
        }

        private void switchCard () {
            jobIndex++;
            jobCard.setImageResource(jobImageList[jobIndex]);
        }
    }
}
*/