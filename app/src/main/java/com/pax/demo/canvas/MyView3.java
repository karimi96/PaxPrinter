package com.pax.demo.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class MyView3 extends View {
    Context context;
    Canvas mCanvas;
    Paint mPaintCenter;
    Paint mPaintLeft;
    Paint mPaintRight;
    Paint mPaintLine;
    Typeface typefaceText;


    int x;
    int y;

    public MyView3(Context context) {
        super(context);
        this.context = context;
        mCanvas = new Canvas();
        mPaintCenter = new Paint();
        mPaintLeft = new Paint();
        mPaintRight = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        x = getWidth();
        y = getHeight();
        typefaceText = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.BOLD);
        centerTitle("فروشگاه رفاه");



    }


    public void setText(int color, int size, Paint.Align align, Typeface typeface, String text, int x, float y, Paint paint, Canvas canvas) {
        paint.setColor(color);
        paint.setTextSize(size);
        paint.setTextAlign(align);
        paint.setTypeface(typeface);
        canvas.drawText(text, x, y, paint);
    }


    private void centerTitle(String text) {
        mCanvas.drawText(text, x, 100, intiTextCenter());
    }


    private Paint intiTextCenter() {
        mPaintCenter.setColor(Color.BLACK);
        mPaintCenter.setTextSize(28);
//        mPaintCenter.setTextAlign(Paint.Align.CENTER);
        mPaintCenter.setTypeface(typefaceText);
        return mPaintCenter;
    }


//    private void drawLine(int sX , int sY , int eX , int eY , ){
//        mCanvas.drawLine(0, s + (oy * 11) / 18 + 15, x, s + (oy * 11) / 18 + 15, paint);
//    }

}
