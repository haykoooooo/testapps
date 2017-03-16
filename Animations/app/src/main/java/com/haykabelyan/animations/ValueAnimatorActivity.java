package com.haykabelyan.animations;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    ValueAnimator up, down, right, left;
    ImageView imageView;
    TextView upt, downt, rightt, leftt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        upt = (TextView) findViewById(R.id.textViewVU);
        downt = (TextView) findViewById(R.id.textViewVD);
        rightt = (TextView) findViewById(R.id.textViewVR);
        leftt = (TextView) findViewById(R.id.textViewVL);
        imageView = (ImageView) findViewById(R.id.imageViewV);
        upt.setOnClickListener(this);
        downt.setOnClickListener(this);
        rightt.setOnClickListener(this);
        leftt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewVU:
                up = ValueAnimator.ofFloat(imageView.getY(), imageView.getY() - 200);
                up.setDuration(3000);
                up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setY((Float) animation.getAnimatedValue());
                    }
                });
                up.start();
                up = ValueAnimator.ofFloat(imageView.getY() - 200, imageView.getY());
                up.setStartDelay(3000);
                up.setDuration(1000);
                up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setY((Float) animation.getAnimatedValue());
                    }
                });
                up.start();
                up = ValueAnimator.ofFloat(imageView.getScaleX(), 2 * imageView.getScaleX());
                up.setDuration(3000);
                up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleX((Float) animation.getAnimatedValue());
                    }
                });
                up.start();
                up = ValueAnimator.ofFloat(2 * imageView.getScaleX(), imageView.getScaleX());
                up.setStartDelay(3000);
                up.setDuration(1000);
                up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleX((Float) animation.getAnimatedValue());
                    }
                });
                up.start();
                up = ValueAnimator.ofFloat(imageView.getScaleY(), 2 * imageView.getScaleY());
                up.setDuration(3000);
                up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleY((Float) animation.getAnimatedValue());
                    }
                });
                up.start();
                up = ValueAnimator.ofFloat(2 * imageView.getScaleY(), imageView.getScaleY());
                up.setStartDelay(3000);
                up.setDuration(1000);
                up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleY((Float) animation.getAnimatedValue());
                    }
                });
                up.start();
                break;
            case R.id.textViewVD:
                down = ValueAnimator.ofFloat(imageView.getY(), imageView.getY() + 200);
                down.setDuration(1000);
                down.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setY((Float) animation.getAnimatedValue());
                    }
                });
                down.start();
                down = ValueAnimator.ofFloat(imageView.getY() + 200, imageView.getY());
                down.setStartDelay(1000);
                down.setDuration(3000);
                down.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setY((Float) animation.getAnimatedValue());
                    }
                });
                down.start();
                down = ValueAnimator.ofFloat(imageView.getScaleX(), (float) 0.5 * imageView.getScaleX());
                down.setDuration(1000);
                down.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleX((Float) animation.getAnimatedValue());
                    }
                });
                down.start();
                down = ValueAnimator.ofFloat((float) 0.5 * imageView.getScaleX(), imageView.getScaleX());
                down.setStartDelay(1000);
                down.setDuration(3000);
                down.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleX((Float) animation.getAnimatedValue());
                    }
                });
                down.start();
                down = ValueAnimator.ofFloat(imageView.getScaleY(), (float) 0.5 * imageView.getScaleY());
                down.setDuration(1000);
                down.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleY((Float) animation.getAnimatedValue());
                    }
                });
                down.start();
                down = ValueAnimator.ofFloat((float) 0.5 * imageView.getScaleY(), imageView.getScaleY());
                down.setStartDelay(1000);
                down.setDuration(3000);
                down.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setScaleY((Float) animation.getAnimatedValue());
                    }
                });
                down.start();
                break;
            case R.id.textViewVR:
                right = ValueAnimator.ofFloat(imageView.getX(), imageView.getX() + 200);
                right.setDuration(2000);
                right.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setX((Float) animation.getAnimatedValue());
                    }
                });
                right.start();
                right = ValueAnimator.ofFloat(imageView.getX() + 200, imageView.getX());
                right.setStartDelay(2000);
                right.setDuration(2000);
                right.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setX((Float) animation.getAnimatedValue());
                    }
                });
                right.start();
                break;
            case R.id.textViewVL:
                left = ValueAnimator.ofFloat(imageView.getX(), imageView.getX() - 200);
                left.setDuration(2000);
                left.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setX((Float) animation.getAnimatedValue());
                    }
                });
                left.start();
                left = ValueAnimator.ofFloat(imageView.getX() - 200, imageView.getX());
                left.setStartDelay(2000);
                left.setDuration(2000);
                left.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setX((Float) animation.getAnimatedValue());
                    }
                });
                left.start();
                break;
        }
    }
}