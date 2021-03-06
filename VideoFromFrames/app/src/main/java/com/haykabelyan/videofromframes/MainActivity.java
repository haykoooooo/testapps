package com.haykabelyan.videofromframes;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends Activity {

    MJPEGGenerator generator;
    Button createButton;
    VideoView videoView;
    String filename;
    int images[] = new int[]{
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
    ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>(images.length);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        createButton = (Button) findViewById(R.id.button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CreateMovieInBackground().execute();
            }
        });
    }

    class CreateMovieInBackground extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                File videoFile = null;
                String sdPath = Environment.getExternalStorageDirectory().getPath() + "/FrameVideos/";
                filename = sdPath + "VideoFromFrames.avi";
                videoFile = new File(filename);
                generator = new MJPEGGenerator(videoFile, 640, 386, 24, 201);
                for (int i = 1; i <= images.length; i++) {
                    bitmaps.add(BitmapFactory.decodeResource(getResources(), images[i]));
                    Bitmap bitmap = bitmaps.get(i);
                    generator.addImage(bitmap);
                }
                generator.finishAVI();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void param) {
            super.onPostExecute(param);
            Uri video = Uri.parse(filename);
            videoView.setVideoURI(video);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    videoView.start();
                }
            });
        }
    }
}