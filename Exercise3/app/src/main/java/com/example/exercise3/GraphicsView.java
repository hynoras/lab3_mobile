package com.example.exercise3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    Bitmap[] frames = new Bitmap[3];
    int i = 0;
    public GraphicsView(Context context) {
        super(context);
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.gigachad1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.gigachad2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.gigachad3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 3){
            canvas.scale(0.75f, 0.8f);
            canvas.drawBitmap(frames[i],40,40, new Paint());
        }
        else {
            i = 0;
        }
        invalidate();
//        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }
}
