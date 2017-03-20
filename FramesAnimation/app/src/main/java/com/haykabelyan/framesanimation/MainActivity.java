package com.haykabelyan.framesanimation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    private int images[] = new int[]{
            R.drawable.a000,
            R.drawable.a001,
            R.drawable.a002,
            R.drawable.a003,
            R.drawable.a004,
            R.drawable.a005,
            R.drawable.a006,
            R.drawable.a007,
            R.drawable.a008,
            R.drawable.a009,
            R.drawable.a010,
            R.drawable.a011,
            R.drawable.a012,
            R.drawable.a013,
            R.drawable.a014,
            R.drawable.a015,
            R.drawable.a016,
            R.drawable.a017,
            R.drawable.a018,
            R.drawable.a019,
            R.drawable.a020,
            R.drawable.a021,
            R.drawable.a022,
            R.drawable.a023,
            R.drawable.a024,
            R.drawable.a025,
            R.drawable.a026,
            R.drawable.a027,
            R.drawable.a028,
            R.drawable.a029,
            R.drawable.a030,
            R.drawable.a031,
            R.drawable.a032,
            R.drawable.a033,
            R.drawable.a034,
            R.drawable.a035,
            R.drawable.a036,
            R.drawable.a037,
            R.drawable.a038,
            R.drawable.a039,
            R.drawable.a040,
            R.drawable.a041,
            R.drawable.a042,
            R.drawable.a043,
            R.drawable.a044,
            R.drawable.a045,
            R.drawable.a046,
            R.drawable.a047,
            R.drawable.a048,
            R.drawable.a049,
            R.drawable.a050,
            R.drawable.a051,
            R.drawable.a052,
            R.drawable.a053,
            R.drawable.a054,
            R.drawable.a055,
            R.drawable.a056,
            R.drawable.a057,
            R.drawable.a058,
            R.drawable.a059,
            R.drawable.a060,
            R.drawable.a061,
            R.drawable.a062,
            R.drawable.a063,
            R.drawable.a064,
            R.drawable.a065,
            R.drawable.a066,
            R.drawable.a067,
            R.drawable.a068,
            R.drawable.a069,
            R.drawable.a070,
            R.drawable.a071,
            R.drawable.a072,
            R.drawable.a073,
            R.drawable.a074,
            R.drawable.a075,
            R.drawable.a076,
            R.drawable.a077,
            R.drawable.a078,
            R.drawable.a079,
            R.drawable.a080,
            R.drawable.a081,
            R.drawable.a082,
            R.drawable.a083,
            R.drawable.a084,
            R.drawable.a085,
            R.drawable.a086,
            R.drawable.a087,
            R.drawable.a088,
            R.drawable.a089,
            R.drawable.a090,
            R.drawable.a091,
            R.drawable.a092,
            R.drawable.a093,
            R.drawable.a094,
            R.drawable.a095,
            R.drawable.a096,
            R.drawable.a097,
            R.drawable.a098,
            R.drawable.a099,
            R.drawable.a200
    };
    private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>(images.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler();
        imageView = new ImageView(this);
        setContentView(imageView);

        Thread load = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < images.length; i++) {
                    bitmaps.add(BitmapFactory.decodeResource(getResources(), images[i]));
                }
            }
        };
        load.setPriority(Thread.MAX_PRIORITY);
        load.start();
        Thread animation = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i < images.length) {
                    if (i >= bitmaps.size()) {
                        Thread.yield();
                    } else {
                        final Bitmap bitmap = bitmaps.get(i);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                        i++;
                    }
                }
            }
        };
        animation.setPriority(Thread.MAX_PRIORITY);
        animation.start();
    }
}