package com.haykabelyan.animations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button0, button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.set);
        button1 = (Button) findViewById(R.id.object);
        button2 = (Button) findViewById(R.id.value);
        button3 = (Button) findViewById(R.id.view);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;
            case R.id.object:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;
            case R.id.value:
                startActivity(new Intent(this, ValueAnimatorActivity.class));
                break;
            case R.id.view:
                startActivity(new Intent(this, ViewPropertyAnimatorActivity.class));
                break;
        }
    }
}