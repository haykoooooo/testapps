package com.haykabelyan.imagestosdcard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] images;
    CheckBox[] checkBoxes;
    Bitmap[] bitmaps;
    Button button;
    ArrayList<Bitmap> bitmap;
    ArrayList<Integer> index;
    File myDir;
    String fname;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new int[26];
        checkBoxes = new CheckBox[26];

        images[0] = R.drawable.a;
        images[1] = R.drawable.b;
        images[2] = R.drawable.c;
        images[3] = R.drawable.d;
        images[4] = R.drawable.e;
        images[5] = R.drawable.f;
        images[6] = R.drawable.g;
        images[7] = R.drawable.h;
        images[8] = R.drawable.i;
        images[9] = R.drawable.j;
        images[10] = R.drawable.k;
        images[11] = R.drawable.l;
        images[12] = R.drawable.m;
        images[13] = R.drawable.n;
        images[14] = R.drawable.o;
        images[15] = R.drawable.p;
        images[16] = R.drawable.q;
        images[17] = R.drawable.r;
        images[18] = R.drawable.s;
        images[19] = R.drawable.t;
        images[20] = R.drawable.u;
        images[21] = R.drawable.v;
        images[22] = R.drawable.w;
        images[23] = R.drawable.x;
        images[24] = R.drawable.y;
        images[25] = R.drawable.z;

        checkBoxes[0] = (CheckBox) findViewById(R.id.checkBoxA);
        checkBoxes[1] = (CheckBox) findViewById(R.id.checkBoxB);
        checkBoxes[2] = (CheckBox) findViewById(R.id.checkBoxC);
        checkBoxes[3] = (CheckBox) findViewById(R.id.checkBoxD);
        checkBoxes[4] = (CheckBox) findViewById(R.id.checkBoxE);
        checkBoxes[5] = (CheckBox) findViewById(R.id.checkBoxF);
        checkBoxes[6] = (CheckBox) findViewById(R.id.checkBoxG);
        checkBoxes[7] = (CheckBox) findViewById(R.id.checkBoxH);
        checkBoxes[8] = (CheckBox) findViewById(R.id.checkBoxI);
        checkBoxes[9] = (CheckBox) findViewById(R.id.checkBoxJ);
        checkBoxes[10] = (CheckBox) findViewById(R.id.checkBoxK);
        checkBoxes[11] = (CheckBox) findViewById(R.id.checkBoxL);
        checkBoxes[12] = (CheckBox) findViewById(R.id.checkBoxM);
        checkBoxes[13] = (CheckBox) findViewById(R.id.checkBoxN);
        checkBoxes[14] = (CheckBox) findViewById(R.id.checkBoxO);
        checkBoxes[15] = (CheckBox) findViewById(R.id.checkBoxP);
        checkBoxes[16] = (CheckBox) findViewById(R.id.checkBoxQ);
        checkBoxes[17] = (CheckBox) findViewById(R.id.checkBoxR);
        checkBoxes[18] = (CheckBox) findViewById(R.id.checkBoxS);
        checkBoxes[19] = (CheckBox) findViewById(R.id.checkBoxT);
        checkBoxes[20] = (CheckBox) findViewById(R.id.checkBoxU);
        checkBoxes[21] = (CheckBox) findViewById(R.id.checkBoxV);
        checkBoxes[22] = (CheckBox) findViewById(R.id.checkBoxW);
        checkBoxes[23] = (CheckBox) findViewById(R.id.checkBoxX);
        checkBoxes[24] = (CheckBox) findViewById(R.id.checkBoxY);
        checkBoxes[25] = (CheckBox) findViewById(R.id.checkBoxZ);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        bitmaps = new Bitmap[26];
        for (int i = 0; i < 26; i++)
            bitmaps[i] = BitmapFactory.decodeResource(getResources(), images[i]);
        index = new ArrayList<>(26);
        bitmap = new ArrayList<>(26);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.clickanim));
        index.clear();
        bitmap.clear();
        String path = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        myDir = new File(path);
        myDir.mkdirs();
        for (int i = 0; i < 26; i++)
            if (checkBoxes[i].isChecked()) {
                index.add(i);
                bitmap.add(bitmaps[i]);
            }
        if (bitmap.size() > 0)
            new SaveImageTask().execute();
        for (int i = 0; i < 26; i++)
            if (checkBoxes[i].isChecked())
                checkBoxes[i].setChecked(false);
    }

    class SaveImageTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < bitmap.size(); i++) {
                try {
                    fname = "Saved image " + (index.get(i)) + ".jpg";
                    file = new File(myDir, fname);
                    if (file.exists()) file.delete();
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.get(i).compress(Bitmap.CompressFormat.JPEG, 100, out);
                    out.flush();
                    out.close();
                    MediaScannerConnection.
                            scanFile(getApplicationContext(), new String[]{file.getPath()}, new String[]{"image/jpeg"}, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}