package com.haykabelyan.animations;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPropertyAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView fade, unfade, rotate, unrotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animator);
        fade = (TextView) findViewById(R.id.textViewVPFade);
        unfade = (TextView) findViewById(R.id.textViewVPUnfade);
        rotate = (TextView) findViewById(R.id.textViewVPRotate);
        unrotate = (TextView) findViewById(R.id.textViewVPUnrotate);
        imageView = (ImageView) findViewById(R.id.imageViewVP);
        fade.setOnClickListener(this);
        unfade.setOnClickListener(this);
        rotate.setOnClickListener(this);
        unrotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        imageView.animate().setDuration(1000);
        switch (v.getId()) {
            case R.id.textViewVPFade:
                imageView.animate().alpha(0);
                break;
            case R.id.textViewVPUnfade:
                imageView.animate().alpha(1);
                break;
            case R.id.textViewVPRotate:
                imageView.animate().rotation(360);
                break;
            case R.id.textViewVPUnrotate:
                imageView.animate().rotation(0);
                break;
        }
    }
}