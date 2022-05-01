package com.pax.demo.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.pax.demo.R;

public class MyView3 extends View {
    Context context;
    Canvas mCanvas;
    Paint mPaintCenter;
    Paint mPaintLeft;
    Paint mPaintNormal;
    Paint mPaintLine;
    Paint paint;
    Paint mPaintBack;
    Typeface typefaceText;

    int x;
    int y;

    Drawable imagePhone;

    public MyView3(Context context) {
        super(context);
        this.context = context;
        mPaintCenter = new Paint();
        mPaintLeft = new Paint();
        mPaintNormal = new Paint();
        mPaintLine = new Paint();
        paint = new Paint();
        mPaintBack = new Paint();

        imagePhone = context.getResources().getDrawable(R.drawable.phone_call);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = getWidth();
        y = getHeight();
        mCanvas = canvas;
        typefaceText = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.BOLD);
        Typeface typefaceNastaliq = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/IranNastaliq.ttf"), Typeface.BOLD);


        mPaintBack.setStyle(Paint.Style.FILL);
        mPaintBack.setColor(Color.WHITE);
        canvas.drawPaint(mPaintBack);

        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTypeface(typefaceNastaliq);

        canvas.drawText("فروشگاه رفاه", x - 30, 170 , paint);


        initText("1401/02/7", 30, 120, Paint.Align.LEFT);
        initText("16:48:20", 30, 160, Paint.Align.LEFT);
        initText("09121312234", 72, 200, Paint.Align.LEFT);

        Rect imageBounds = canvas.getClipBounds();
        imageBounds.set(30,175, x/11 -5, y/2 - 435 );
        imagePhone.setBounds(imageBounds);
        imagePhone.draw(canvas);


//        initText("09121312124", x - 30, 150, Paint.Align.RIGHT);
//        initText("025-33385501", x - 30, 180, Paint.Align.RIGHT);

        initText(" **** خرید-رسید مشتری ****", x / 2, 270, Paint.Align.CENTER);


        initLines(0, 380, x, 380);


        multiText("ردیف", "محصول", "قیمت", "تعداد", "کل", 350);
        multiText("1", "ماکارونی", "5000", "2", "10000", 430);
        multiText("2", "صابون", "2000", "4", "8000", 480);
        multiText("3", "شامپو", "8000", "3", "24000", 530);
        multiText("4", "لوبیا", "9000", "1", "9000", 580);
        multiText("4", "لوبیا", "9000", "1", "9000", 630);
        multiText("4", "لوبیا", "9000", "1", "9000", 680);
        multiText("4", "لوبیا", "9000", "1", "9000", 730);

        initText(" ****  صورتحساب ****", x / 2, y - 360, Paint.Align.CENTER);

        initText("قیمت خرید :", x - 30, y - 300, Paint.Align.RIGHT);
        initText("مالیات :", x - 30, y - 250, Paint.Align.RIGHT);
        initText("تخفیف :", x - 30, y - 200, Paint.Align.RIGHT);
        initText("مبلغ کل :", x - 30, y - 150, Paint.Align.RIGHT);


        initText("65000", 30, y - 300, Paint.Align.LEFT);
        initText("12000", 30, y - 250, Paint.Align.LEFT);
        initText("5000", 30, y - 200, Paint.Align.LEFT);
        initText("67000", 30, y - 150 , Paint.Align.LEFT);


        initLines(0, y-100, x, y-100);

        initText("با تشکر از خرید شما", x / 2 , y-50, Paint.Align.CENTER);


    }


    private void multiText(String num, String product, String price, String count, String total, int y) {
        initText(num, x * 9 / 10, y, Paint.Align.CENTER);
        initText(product, x * 7 / 10, y, Paint.Align.CENTER);
        initText(price, x * 5 / 10, y, Paint.Align.CENTER);
        initText(count, x * 3 / 10, y, Paint.Align.CENTER);
        initText(total, x * 1 / 10, y, Paint.Align.CENTER);
    }


    public void initText(String text, int x, float y, Paint.Align align) {
        mCanvas.drawText(text, x, y, initPaintText(align));
    }


    private void centerTitle(String text, Canvas canvas) {
        canvas.drawText(text, x / 2, 100, intiPaintTextCenter());
    }


    private Paint intiPaintTextCenter() {
        mPaintCenter.setColor(Color.BLACK);
        mPaintCenter.setTextSize(28);
        mPaintCenter.setTextAlign(Paint.Align.CENTER);
        mPaintCenter.setTypeface(typefaceText);
        return mPaintCenter;
    }

    private Paint initPaintText(Paint.Align align) {
        mPaintNormal.setColor(Color.BLACK);
        mPaintNormal.setTextSize(30);
        mPaintNormal.setTextAlign(align);
        mPaintNormal.setTypeface(typefaceText);
        return mPaintNormal;
    }


    private void initLines(int sX, int sY, int eX, int eY) {
        mCanvas.drawLine(sX, sY, eX, eY, intiPaintLine());
    }

    private Paint intiPaintLine() {
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStrokeWidth(6);
        return mPaintLine;
    }

}
