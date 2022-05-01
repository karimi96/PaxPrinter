package com.pax.demo.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.pax.demo.R;

public class MyView4 extends View {
    Context context;
    Canvas mCanvas;
    Paint mPaintCenter;
    Paint mPaintDate;
    Paint mPaintNormal;
    Paint mPaintLine;
    Paint mPaintRect;
    Paint mPaintBack;
    Typeface typefaceText;
    Typeface typefaceNastaliq;

    int x;
    int y;

    Drawable imagePhone;

    public MyView4(Context context) {
        super(context);
        this.context = context;
//        mPaintCenter = new Paint();
        mPaintNormal = new Paint();
        mPaintDate = new Paint();
        mPaintLine = new Paint();
        mPaintRect = new Paint();
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
        typefaceNastaliq = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/IranNastaliq.ttf"), Typeface.BOLD);

        mPaintBack.setStyle(Paint.Style.FILL);
        mPaintBack.setColor(Color.WHITE);
        canvas.drawPaint(mPaintBack);

        setTitle("فروشگاه رفاه", x - 30, 150, Paint.Align.RIGHT);

        Rect imageBounds = canvas.getClipBounds();
        imageBounds.set(30,115, x/11 -5, 140 );
        imagePhone.setBounds(imageBounds);
        imagePhone.draw(canvas);
        initText("0253-9898989", 70,140 , Paint.Align.LEFT);


        setRect(200,280);
        setRect(y-400,y-145);


        setDate("1401/02/8", "17:17");

        multiText("ردیف", "محصول", "قیمت", "تعداد", "کل", 350);
        multiText("1", "ماکارونی", "5000", "2", "10000", 430);
        multiText("2", "صابون", "2000", "4", "8000", 480);
        multiText("3", "شامپو", "8000", "3", "24000", 530);
        multiText("4", "لوبیا", "9000", "1", "9000", 580);
        multiText("5", "چای", "9000", "1", "9000", 630);
        multiText("6", "تخم مرغ", "9000", "1", "9000", 680);
        multiText("7", "پنیر کاله", "9000", "1", "9000", 730);
        multiText("8", "پسته", "9000", "1", "9000", 780);


        initLines(380);

        initText("قیمت خرید :", x - 60, y- 350, Paint.Align.RIGHT);
        initText("مالیات :", x - 60, y-290, Paint.Align.RIGHT);
        initText("تخفیف :", x - 60, y-230, Paint.Align.RIGHT);
        initText("مبلغ کل :", x - 60, y-170, Paint.Align.RIGHT);

        initText("65000", 60, y- 350, Paint.Align.LEFT);
        initText("12000", 60, y-290, Paint.Align.LEFT);
        initText("5000", 60, y-230, Paint.Align.LEFT);
        initText("67000", 60, y-170 , Paint.Align.LEFT);


        initLines(y - 100);
        initText("www.refah.com", x/2, y-50, Paint.Align.CENTER);



    }


    private Paint initPaintTitle(Paint.Align align) {
        mPaintNormal.setColor(Color.BLACK);
        mPaintNormal.setTextSize(80);
        mPaintNormal.setTextAlign(align);
        mPaintNormal.setTypeface(typefaceNastaliq);
        return mPaintNormal;
    }


    public void setTitle(String text, int x, float y, Paint.Align align) {
        mCanvas.drawText(text, x, y, initPaintTitle(align));
    }


    private void setRect(int top , int bottom){
        mCanvas.drawRoundRect(new RectF(30, top, x - 30, bottom), 30, 30, initPaintRect());

    }

    private Paint initPaintRect(){
        mPaintRect.setColor(Color.BLACK);
        mPaintRect.setStyle(Paint.Style.STROKE);
        mPaintRect.setStrokeWidth(5);
        return mPaintRect;
    }


    private Paint initPaintDate(Paint.Align align) {
        mPaintDate.setColor(Color.BLACK);
        mPaintDate.setTextSize(30);
        mPaintDate.setTextAlign(align);
        mPaintDate.setTypeface(typefaceText);
        return mPaintDate;
    }

    private void setDate(String date, String time) {
        mCanvas.drawText("تاریخ :", x * 14 / 16 - 10, 250, initPaintDate(Paint.Align.CENTER));
        mCanvas.drawText("ساعت :", x * 4 / 16 + 10, 250, initPaintDate(Paint.Align.CENTER));
        mCanvas.drawText(date, x * 12 / 16 +10, 250, initPaintDate(Paint.Align.RIGHT));
        mCanvas.drawText(time, x * 2 / 16,  250, initPaintDate(Paint.Align.CENTER));
    }


    private void multiText(String num, String product, String price, String count, String total, int y) {
        initText(num, x * 9 / 10, y, Paint.Align.CENTER);
        initText(product, x * 7 / 10, y, Paint.Align.CENTER);
        initText(price, x * 5 / 10, y, Paint.Align.CENTER);
        initText(count, x * 3 / 10, y, Paint.Align.CENTER);
        initText(total, x * 1 / 10, y, Paint.Align.CENTER);
    }

    public void initText(String text, int x, float y, Paint.Align align) {
        mCanvas.drawText(text, x, y, initPaintDate(align));
    }


    private void initLines(int height) {
        mCanvas.drawLine(0, height, x, height, intiPaintLine());
    }


    private Paint intiPaintLine() {
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStrokeWidth(6);
        return mPaintLine;
    }

}
