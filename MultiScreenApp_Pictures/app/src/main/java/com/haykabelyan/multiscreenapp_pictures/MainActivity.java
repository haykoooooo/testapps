package com.haykabelyan.multiscreenapp_pictures;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.haykabelyan.admin.multiscreenapp_pictures.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView[] imageViews = new ImageView[6];
    EditText t1, t2;
    Button b;
    ArrayList<Drawable> pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViews[0] = (ImageView) findViewById(R.id.imageView);
        imageViews[1] = (ImageView) findViewById(R.id.imageView2);
        imageViews[2] = (ImageView) findViewById(R.id.imageView3);
        imageViews[3] = (ImageView) findViewById(R.id.imageView4);
        imageViews[4] = (ImageView) findViewById(R.id.imageView5);
        imageViews[5] = (ImageView) findViewById(R.id.imageView6);
        t1 = (EditText) findViewById(R.id.editText);
        t2 = (EditText) findViewById(R.id.editText2);
        b = (Button) findViewById(R.id.button);

        pictures = new ArrayList<Drawable>();
        pictures.add(getResources().getDrawable(R.drawable.c1));
        pictures.add(getResources().getDrawable(R.drawable.c2));
        pictures.add(getResources().getDrawable(R.drawable.c3));
        pictures.add(getResources().getDrawable(R.drawable.c4));
        pictures.add(getResources().getDrawable(R.drawable.c5));
        pictures.add(getResources().getDrawable(R.drawable.c6));

        for (int i = 0; i < 6; i++) {
            int k = (int) ((6 - i) * Math.random());
            while (pictures.get(k).equals(null))
                k--;
            imageViews[i].setImageDrawable(pictures.get(k));
            pictures.remove(pictures.get(k));
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable temp = null;
                if (t1.getText().length() == 1 && t2.getText().length() == 1 && (Integer.parseInt(t1.getText().toString()) > 0 && Integer.parseInt(t1.getText().toString()) < 7 &&
                        Integer.parseInt(t2.getText().toString()) > 0 && Integer.parseInt(t2.getText().toString()) < 7)) {
                    temp = imageViews[Integer.parseInt(t1.getText().toString()) - 1].getDrawable();
                    imageViews[Integer.parseInt(t1.getText().toString()) - 1].setImageDrawable(imageViews[Integer.parseInt(t2.getText().toString()) - 1].getDrawable());
                    imageViews[Integer.parseInt(t2.getText().toString()) - 1].setImageDrawable(temp);
                } else
                    Toast.makeText(getApplicationContext(), "Not valid input", Toast.LENGTH_SHORT).show();
            }
        });
    }
}