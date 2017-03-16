package com.haykabelyan.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimatorSetActivity extends AppCompatActivity {
    AnimatorSet animatorSet;
    Button button;
    ImageView imageView;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        imageView = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);
    }

    public void play(View v) {
        animatorSet = new AnimatorSet();
        i++;
        if (i % 2 == 0) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", - 100f);
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(imageView.getY(), imageView.getY() + 100);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    imageView.setY((Float) animation.getAnimatedValue());
                }
            });
            animatorSet.play(objectAnimator).after(valueAnimator);
            animatorSet.start();
        } else {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 100f);
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(imageView.getY(), imageView.getY() - 100);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    imageView.setY((Float) animation.getAnimatedValue());
                }
            });
            animatorSet.play(objectAnimator).before(valueAnimator);
            animatorSet.start();
        }
    }
}