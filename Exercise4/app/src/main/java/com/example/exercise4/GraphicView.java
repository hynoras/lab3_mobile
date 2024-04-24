package com.example.exercise4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class GraphicView extends View {

    Bitmap[] frames = new Bitmap[3];
    int i = 0;
    long last_tick = 0;
    long period = 1000;
    static Context ctext;
    static MediaPlayer mediaPlayer;


    public GraphicView(Context context) {
        super(context);
        ctext = context;
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.gigachad1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.gigachad2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.gigachad3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 3){
            long time = (System.currentTimeMillis() - last_tick);
            if (time >= period) {
                last_tick = System.currentTimeMillis();
                canvas.scale(0.75f, 0.8f);
                canvas.drawBitmap(frames[i],40,40, new Paint());
                i++;
                postInvalidate();
            }
            else {
                canvas.scale(0.75f, 0.8f);
                canvas.drawBitmap(frames[i], 40, 40, new Paint());
                postInvalidate();
            }
        }
        else {
            i = 0;
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }
}
