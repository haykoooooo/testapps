package com.haykabelyan.animations;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    ObjectAnimator up, down, right, left;
    ImageView imageView;
    TextView upt, downt, rightt, leftt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        upt = (TextView) findViewById(R.id.textViewOU);
        downt = (TextView) findViewById(R.id.textViewOD);
        rightt = (TextView) findViewById(R.id.textViewOR);
        leftt = (TextView) findViewById(R.id.textViewOL);
        imageView = (ImageView) findViewById(R.id.imageViewO);
        upt.setOnClickListener(this);
        downt.setOnClickListener(this);
        rightt.setOnClickListener(this);
        leftt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewOU:
                up = ObjectAnimator.ofFloat(imageView, "TranslationY", 0f, -200f);
                up.setDuration(3000);
                up.setStartDelay(1000);
                up.start();
                up = ObjectAnimator.ofFloat(imageView, "TranslationY", -200f, 0f);
                up.setDuration(1000);
                up.setStartDelay(4000);
                up.start();
                break;
            case R.id.textViewOD:
                down = ObjectAnimator.ofFloat(imageView, "TranslationY", 0f, 200f);
                down.setDuration(1000);
                down.start();
                down = ObjectAnimator.ofFloat(imageView, "TranslationY", 200f, 0f);
                down.setDuration(3000);
                down.setStartDelay(1000);
                down.start();
                break;
            case R.id.textViewOR:
                right = ObjectAnimator.ofFloat(imageView, "TranslationX", 0f, 200f);
                right.setDuration(2000);
                right.setStartDelay(500);
                right.start();
                right = ObjectAnimator.ofFloat(imageView, "TranslationX", 200f, 0f);
                right.setDuration(2000);
                right.setStartDelay(3000);
                right.start();
                break;
            case R.id.textViewOL:
                left = ObjectAnimator.ofFloat(imageView, "TranslationX", 0f, -200f);
                left.setDuration(2000);
                left.setStartDelay(500);
                left.start();
                left = ObjectAnimator.ofFloat(imageView, "TranslationX", -200f, 0f);
                left.setDuration(2000);
                left.setStartDelay(3000);
                left.start();
                break;
        }
    }
}