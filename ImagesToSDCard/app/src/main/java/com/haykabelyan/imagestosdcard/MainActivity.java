package com.haykabelyan.imagestosdcard;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView[] images;
    CheckBox[] checkBoxes;
    Bitmap[] bitmaps;
    Button button;
    Bitmap bitmap;
    File myDir;
    String fname;
    File file;
    ImageIndex imageIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new ImageView[26];
        checkBoxes = new CheckBox[26];

        images[0] = (ImageView) findViewById(R.id.a);
        images[1] = (ImageView) findViewById(R.id.b);
        images[2] = (ImageView) findViewById(R.id.c);
        images[3] = (ImageView) findViewById(R.id.d);
        images[4] = (ImageView) findViewById(R.id.e);
        images[5] = (ImageView) findViewById(R.id.f);
        images[6] = (ImageView) findViewById(R.id.g);
        images[7] = (ImageView) findViewById(R.id.h);
        images[8] = (ImageView) findViewById(R.id.i);
        images[9] = (ImageView) findViewById(R.id.j);
        images[10] = (ImageView) findViewById(R.id.k);
        images[11] = (ImageView) findViewById(R.id.l);
        images[12] = (ImageView) findViewById(R.id.m);
        images[13] = (ImageView) findViewById(R.id.n);
        images[14] = (ImageView) findViewById(R.id.o);
        images[15] = (ImageView) findViewById(R.id.p);
        images[16] = (ImageView) findViewById(R.id.q);
        images[17] = (ImageView) findViewById(R.id.r);
        images[18] = (ImageView) findViewById(R.id.s);
        images[19] = (ImageView) findViewById(R.id.t);
        images[20] = (ImageView) findViewById(R.id.u);
        images[21] = (ImageView) findViewById(R.id.v);
        images[22] = (ImageView) findViewById(R.id.w);
        images[23] = (ImageView) findViewById(R.id.x);
        images[24] = (ImageView) findViewById(R.id.y);
        images[25] = (ImageView) findViewById(R.id.z);

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
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.clickanim));

        String path = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        myDir = new File(path);
        myDir.mkdirs();
        imageIndex = new ImageIndex();
        for (int i = 0; i < 26; i++) {
            bitmaps[i] = ((BitmapDrawable) (images[i].getDrawable())).getBitmap();
            if (checkBoxes[i].isChecked()) {
                imageIndex.index = i;
                new SaveImageTask().execute(imageIndex.index);
            }
        }
        for (int i = 0; i < 26; i++)
            if (checkBoxes[i].isChecked())
                checkBoxes[i].setChecked(false);
    }

    class SaveImageTask extends AsyncTask<Integer, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            fname = "Saved image " + (imageIndex.index + 1) + ".jpg";
            file = new File(myDir, fname);
            if (file.exists()) file.delete();
        }

        @Override
        protected Void doInBackground(Integer... params) {
            try {
                FileOutputStream out = new FileOutputStream(file);
                bitmaps[params[0]].compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
                MediaScannerConnection.scanFile(getApplicationContext(), new String[]{file.getPath()}, new String[]{"image/jpeg"}, null);
            } catch (Exception e) {
                e.printStackTrace();
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