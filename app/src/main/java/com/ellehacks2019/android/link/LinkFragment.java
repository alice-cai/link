package com.ellehacks2019.android.link;

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


public class LinkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_link, container, false);

        ImageButton mGoToMatchingButton = view.findViewById(R.id.go_to_matching_button);

        /*
        mGoToMatchingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MatchActivity.class);
                startActivity(intent);
            }
        });*/

        mGoToMatchingButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View button, MotionEvent event) {
                ImageButton studentButton = (ImageButton) button;
                studentButton.setSelected(!studentButton.isSelected());

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        studentButton.setImageResource(R.drawable.match_button_press);
                        Intent intent = new Intent(getActivity(), MatchActivity.class);
                        startActivity(intent);
                        return true;
                    case MotionEvent.ACTION_UP:
                        studentButton.setImageResource(R.drawable.match_button);
                        return true;
                }
                return false;
            }
        });

        return view;
    }
}