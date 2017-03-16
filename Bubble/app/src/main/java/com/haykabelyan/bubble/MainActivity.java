package com.haykabelyan.bubble;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView;
    float dX, dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        Resources resources = getResources();
        RoundedBitmapDrawable image = RoundedBitmapDrawableFactory.create(resources, BitmapFactory.decodeResource(resources, R.drawable.green));
        image.setCornerRadius(500);
        imageView.setImageDrawable(image);
        imageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (view.getId() == R.id.imageView)
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (imageView.getVisibility() == View.VISIBLE)
                        imageView.animate()
                                .x(Math.max(0, Math.min(event.getRawX() + dX, imageView.getWidth() * 9)))
                                .y(Math.max(0, Math.min(event.getRawY() + dY, imageView.getHeight() * 14)))
                                .setDuration(0)
                                .start();
                    break;
                default:
                    return false;
            }
        return true;
    }
}