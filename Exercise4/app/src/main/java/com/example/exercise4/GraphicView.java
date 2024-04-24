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

    Bitmap[] frames = new Bitmap[128];
    int i = 0;
    long last_tick = 0;
    long period = 200;
    static Context ctext;
    static MediaPlayer mediaPlayer;


    public GraphicView(Context context) {
        super(context);
        ctext = context;
        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.cat0);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.cat1);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.cat2);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.cat3);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.cat4);
        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.cat5);
        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.cat6);
        frames[7] = BitmapFactory.decodeResource(getResources(), R.drawable.cat7);
        frames[8] = BitmapFactory.decodeResource(getResources(), R.drawable.cat8);
        frames[9] = BitmapFactory.decodeResource(getResources(), R.drawable.cat9);
        frames[10] = BitmapFactory.decodeResource(getResources(), R.drawable.cat10);
        frames[11] = BitmapFactory.decodeResource(getResources(), R.drawable.cat11);
        frames[12] = BitmapFactory.decodeResource(getResources(), R.drawable.cat12);
        frames[13] = BitmapFactory.decodeResource(getResources(), R.drawable.cat13);
        frames[14] = BitmapFactory.decodeResource(getResources(), R.drawable.cat14);
        frames[15] = BitmapFactory.decodeResource(getResources(), R.drawable.cat15);
        frames[16] = BitmapFactory.decodeResource(getResources(), R.drawable.cat16);
        frames[17] = BitmapFactory.decodeResource(getResources(), R.drawable.cat17);
        frames[18] = BitmapFactory.decodeResource(getResources(), R.drawable.cat18);
        frames[19] = BitmapFactory.decodeResource(getResources(), R.drawable.cat19);
        frames[20] = BitmapFactory.decodeResource(getResources(), R.drawable.cat20);
        frames[21] = BitmapFactory.decodeResource(getResources(), R.drawable.cat21);
        frames[22] = BitmapFactory.decodeResource(getResources(), R.drawable.cat22);
        frames[23] = BitmapFactory.decodeResource(getResources(), R.drawable.cat23);
        frames[24] = BitmapFactory.decodeResource(getResources(), R.drawable.cat24);
        frames[25] = BitmapFactory.decodeResource(getResources(), R.drawable.cat25);
        frames[26] = BitmapFactory.decodeResource(getResources(), R.drawable.cat26);
        frames[27] = BitmapFactory.decodeResource(getResources(), R.drawable.cat27);
        frames[28] = BitmapFactory.decodeResource(getResources(), R.drawable.cat28);
        frames[29] = BitmapFactory.decodeResource(getResources(), R.drawable.cat29);
        frames[30] = BitmapFactory.decodeResource(getResources(), R.drawable.cat30);
        frames[31] = BitmapFactory.decodeResource(getResources(), R.drawable.cat31);
        frames[32] = BitmapFactory.decodeResource(getResources(), R.drawable.cat32);
        frames[33] = BitmapFactory.decodeResource(getResources(), R.drawable.cat33);
        frames[34] = BitmapFactory.decodeResource(getResources(), R.drawable.cat34);
        frames[35] = BitmapFactory.decodeResource(getResources(), R.drawable.cat35);
        frames[36] = BitmapFactory.decodeResource(getResources(), R.drawable.cat36);
        frames[37] = BitmapFactory.decodeResource(getResources(), R.drawable.cat37);
        frames[38] = BitmapFactory.decodeResource(getResources(), R.drawable.cat38);
        frames[39] = BitmapFactory.decodeResource(getResources(), R.drawable.cat39);
        frames[40] = BitmapFactory.decodeResource(getResources(), R.drawable.cat40);
        frames[41] = BitmapFactory.decodeResource(getResources(), R.drawable.cat41);
        frames[42] = BitmapFactory.decodeResource(getResources(), R.drawable.cat42);
        frames[43] = BitmapFactory.decodeResource(getResources(), R.drawable.cat43);
        frames[44] = BitmapFactory.decodeResource(getResources(), R.drawable.cat44);
        frames[45] = BitmapFactory.decodeResource(getResources(), R.drawable.cat45);
        frames[46] = BitmapFactory.decodeResource(getResources(), R.drawable.cat46);
        frames[47] = BitmapFactory.decodeResource(getResources(), R.drawable.cat47);
        frames[48] = BitmapFactory.decodeResource(getResources(), R.drawable.cat48);
        frames[49] = BitmapFactory.decodeResource(getResources(), R.drawable.cat49);
        frames[50] = BitmapFactory.decodeResource(getResources(), R.drawable.cat50);
        frames[51] = BitmapFactory.decodeResource(getResources(), R.drawable.cat51);
        frames[52] = BitmapFactory.decodeResource(getResources(), R.drawable.cat52);
        frames[53] = BitmapFactory.decodeResource(getResources(), R.drawable.cat53);
        frames[54] = BitmapFactory.decodeResource(getResources(), R.drawable.cat54);
        frames[55] = BitmapFactory.decodeResource(getResources(), R.drawable.cat55);
        frames[56] = BitmapFactory.decodeResource(getResources(), R.drawable.cat56);
        frames[57] = BitmapFactory.decodeResource(getResources(), R.drawable.cat57);
        frames[58] = BitmapFactory.decodeResource(getResources(), R.drawable.cat58);
        frames[59] = BitmapFactory.decodeResource(getResources(), R.drawable.cat59);
        frames[60] = BitmapFactory.decodeResource(getResources(), R.drawable.cat60);
        frames[61] = BitmapFactory.decodeResource(getResources(), R.drawable.cat61);
        frames[62] = BitmapFactory.decodeResource(getResources(), R.drawable.cat62);
        frames[63] = BitmapFactory.decodeResource(getResources(), R.drawable.cat63);
        frames[64] = BitmapFactory.decodeResource(getResources(), R.drawable.cat64);
        frames[65] = BitmapFactory.decodeResource(getResources(), R.drawable.cat65);
        frames[66] = BitmapFactory.decodeResource(getResources(), R.drawable.cat66);
        frames[67] = BitmapFactory.decodeResource(getResources(), R.drawable.cat67);
        frames[68] = BitmapFactory.decodeResource(getResources(), R.drawable.cat68);
        frames[69] = BitmapFactory.decodeResource(getResources(), R.drawable.cat69);
        frames[70] = BitmapFactory.decodeResource(getResources(), R.drawable.cat70);
        frames[71] = BitmapFactory.decodeResource(getResources(), R.drawable.cat71);
        frames[72] = BitmapFactory.decodeResource(getResources(), R.drawable.cat72);
        frames[73] = BitmapFactory.decodeResource(getResources(), R.drawable.cat73);
        frames[74] = BitmapFactory.decodeResource(getResources(), R.drawable.cat74);
        frames[75] = BitmapFactory.decodeResource(getResources(), R.drawable.cat75);
        frames[76] = BitmapFactory.decodeResource(getResources(), R.drawable.cat76);
        frames[77] = BitmapFactory.decodeResource(getResources(), R.drawable.cat77);
        frames[78] = BitmapFactory.decodeResource(getResources(), R.drawable.cat78);
        frames[79] = BitmapFactory.decodeResource(getResources(), R.drawable.cat79);
        frames[80] = BitmapFactory.decodeResource(getResources(), R.drawable.cat80);
        frames[81] = BitmapFactory.decodeResource(getResources(), R.drawable.cat81);
        frames[82] = BitmapFactory.decodeResource(getResources(), R.drawable.cat82);
        frames[83] = BitmapFactory.decodeResource(getResources(), R.drawable.cat83);
        frames[84] = BitmapFactory.decodeResource(getResources(), R.drawable.cat84);
        frames[85] = BitmapFactory.decodeResource(getResources(), R.drawable.cat85);
        frames[86] = BitmapFactory.decodeResource(getResources(), R.drawable.cat86);
        frames[87] = BitmapFactory.decodeResource(getResources(), R.drawable.cat87);
        frames[88] = BitmapFactory.decodeResource(getResources(), R.drawable.cat88);
        frames[89] = BitmapFactory.decodeResource(getResources(), R.drawable.cat89);
        frames[90] = BitmapFactory.decodeResource(getResources(), R.drawable.cat90);
        frames[91] = BitmapFactory.decodeResource(getResources(), R.drawable.cat91);
        frames[92] = BitmapFactory.decodeResource(getResources(), R.drawable.cat92);
        frames[93] = BitmapFactory.decodeResource(getResources(), R.drawable.cat93);
        frames[94] = BitmapFactory.decodeResource(getResources(), R.drawable.cat94);
        frames[95] = BitmapFactory.decodeResource(getResources(), R.drawable.cat95);
        frames[96] = BitmapFactory.decodeResource(getResources(), R.drawable.cat96);
        frames[97] = BitmapFactory.decodeResource(getResources(), R.drawable.cat97);
        frames[98] = BitmapFactory.decodeResource(getResources(), R.drawable.cat98);
        frames[99] = BitmapFactory.decodeResource(getResources(), R.drawable.cat99);
        frames[100] = BitmapFactory.decodeResource(getResources(), R.drawable.cat100);
        frames[101] = BitmapFactory.decodeResource(getResources(), R.drawable.cat101);
        frames[102] = BitmapFactory.decodeResource(getResources(), R.drawable.cat102);
        frames[103] = BitmapFactory.decodeResource(getResources(), R.drawable.cat103);
        frames[104] = BitmapFactory.decodeResource(getResources(), R.drawable.cat104);
        frames[105] = BitmapFactory.decodeResource(getResources(), R.drawable.cat105);
        frames[106] = BitmapFactory.decodeResource(getResources(), R.drawable.cat106);
        frames[107] = BitmapFactory.decodeResource(getResources(), R.drawable.cat107);
        frames[108] = BitmapFactory.decodeResource(getResources(), R.drawable.cat108);
        frames[109] = BitmapFactory.decodeResource(getResources(), R.drawable.cat109);
        frames[110] = BitmapFactory.decodeResource(getResources(), R.drawable.cat110);
        frames[111] = BitmapFactory.decodeResource(getResources(), R.drawable.cat111);
        frames[112] = BitmapFactory.decodeResource(getResources(), R.drawable.cat112);
        frames[113] = BitmapFactory.decodeResource(getResources(), R.drawable.cat113);
        frames[114] = BitmapFactory.decodeResource(getResources(), R.drawable.cat114);
        frames[115] = BitmapFactory.decodeResource(getResources(), R.drawable.cat115);
        frames[116] = BitmapFactory.decodeResource(getResources(), R.drawable.cat116);
        frames[117] = BitmapFactory.decodeResource(getResources(), R.drawable.cat117);
        frames[118] = BitmapFactory.decodeResource(getResources(), R.drawable.cat118);
        frames[119] = BitmapFactory.decodeResource(getResources(), R.drawable.cat119);
        frames[120] = BitmapFactory.decodeResource(getResources(), R.drawable.cat120);
        frames[121] = BitmapFactory.decodeResource(getResources(), R.drawable.cat121);
        frames[122] = BitmapFactory.decodeResource(getResources(), R.drawable.cat122);
        frames[123] = BitmapFactory.decodeResource(getResources(), R.drawable.cat123);
        frames[124] = BitmapFactory.decodeResource(getResources(), R.drawable.cat124);
        frames[125] = BitmapFactory.decodeResource(getResources(), R.drawable.cat125);
        frames[126] = BitmapFactory.decodeResource(getResources(), R.drawable.cat126);
        frames[127] = BitmapFactory.decodeResource(getResources(), R.drawable.cat127);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 128){
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
