package com.ellehacks2019.android.link;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class SelectUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        ImageButton mSelectStudentButton = (ImageButton) findViewById(R.id.select_student_button);
        ImageButton mSelectEmployerButton = (ImageButton) findViewById(R.id.select_employer_button);

        mSelectStudentButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View button, MotionEvent event) {
                ImageButton studentButton = (ImageButton) button;
                studentButton.setSelected(!studentButton.isSelected());

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        studentButton.setImageResource(R.drawable.student_button_press);
                        Intent intent = new Intent(SelectUserActivity.this, LoginActivity.class);
                        startActivity(intent);
                        return true;
                    case MotionEvent.ACTION_UP:
                        studentButton.setImageResource(R.drawable.student_button);
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
}
