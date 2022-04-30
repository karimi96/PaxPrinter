package com.pax.demo.modules.printer;

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

public class MyView6 extends View {
    Canvas mCanvas;
    Context context;
    Drawable logo;
    Drawable call_phone;

    Typeface fontIranSans;
    Typeface typefaceNastaliq;

    Paint mPaintTitle;
    Paint mPaintAllText;
    Paint mPaintLine;
    Paint mPaintRect;


    int x;
    int y;


    public MyView6(Context context) {
        super(context);
        this.context = context;
        logo = context.getResources().getDrawable(R.drawable.ic_shaparak);
        call_phone = context.getResources().getDrawable(R.drawable.phone_call);

        mPaintTitle = new Paint();
        mPaintAllText = new Paint();
        mPaintLine = new Paint();
        mPaintRect = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        x = getWidth();
        y = getHeight();
        mCanvas = canvas;
        fontIranSans = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.BOLD);
        typefaceNastaliq = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/IranNastaliq.ttf"), Typeface.BOLD);


        Rect imageBounds = canvas.getClipBounds();
        imageBounds.set(30, 50, x / 2 - 80, 140);
        logo.setBounds(imageBounds);
        logo.draw(canvas);


        initText("1401/02/7", x- 30, 80, Paint.Align.RIGHT);
        initText("16:48:20", x - 30, 120, Paint.Align.RIGHT);


        setTitle("فروشگاه رفاه", x /2, 200, Paint.Align.CENTER);


        imageBounds.set(x/2-150,225, x/2 -120, 250 );
        call_phone.setBounds(imageBounds);
        call_phone.draw(canvas);
        initText("0253-9898989", x/2,250 , Paint.Align.CENTER);



        multiText("ردیف", "محصول", "قیمت", "تعداد", "کل", 350);
        multiText("1", "ماکارونی", "5000", "2", "10000", 430);
        multiText("2", "صابون", "2000", "4", "8000", 480);
        multiText("3", "شامپو", "8000", "3", "24000", 530);
        multiText("4", "لوبیا", "9000", "1", "9000", 580);
        multiText("5", "چای", "9000", "1", "9000", 630);
        multiText("6", "تخم مرغ", "9000", "1", "9000", 680);
        multiText("7", "پنیر کاله", "9000", "1", "9000", 730);


        initLines(380);


        setRect(y-400,y-145);


        initText("قیمت خرید :", x - 60, y- 300, Paint.Align.RIGHT);
        initText("مالیات :", x - 60, y-250, Paint.Align.RIGHT);
        initText("تخفیف :", x - 60, y-200, Paint.Align.RIGHT);
        initText("مبلغ کل :", x - 60, y-150, Paint.Align.RIGHT);

        initText("65000", 60, y- 300, Paint.Align.LEFT);
        initText("12000", 60, y-250, Paint.Align.LEFT);
        initText("5000", 60, y-200, Paint.Align.LEFT);
        initText("67000", 60, y-150 , Paint.Align.LEFT);


        initLines(y - 100);
        initText("www.refah.com", x/2, y-50, Paint.Align.CENTER);




    }

    private Paint initPaintTitle(Paint.Align align) {
        mPaintTitle.setColor(Color.BLACK);
        mPaintTitle.setTextSize(30);
        mPaintTitle.setTextAlign(align);
        mPaintTitle.setTypeface(fontIranSans);
        return mPaintTitle;
    }


    public void setTitle(String text, int x, float y, Paint.Align align) {
        mCanvas.drawText(text, x, y, initPaintTitle(align));
    }


    private void multiText(String num, String product, String price, String count, String total, int y) {
        initText(num, x * 9 / 10, y, Paint.Align.CENTER);
        initText(product, x * 7 / 10, y, Paint.Align.CENTER);
        initText(price, x * 5 / 10, y, Paint.Align.CENTER);
        initText(count, x * 3 / 10, y, Paint.Align.CENTER);
        initText(total, x * 1 / 10, y, Paint.Align.CENTER);
    }

    public void initText(String text, int x, float y, Paint.Align align) {
        mCanvas.drawText(text, x, y, initPaintAllText(align));
    }
    
    private Paint initPaintAllText(Paint.Align align) {
        mPaintAllText.setColor(Color.BLACK);
        mPaintAllText.setTextSize(30);
        mPaintAllText.setTextAlign(align);
        mPaintAllText.setTypeface(fontIranSans);
        return mPaintAllText;
    }


    private void initLines(int height) {
        mCanvas.drawLine(0, height, x, height, intiPaintLine());
    }


    private Paint intiPaintLine() {
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStrokeWidth(1);
        return mPaintLine;
    }


    private void setRect(int top , int bottom){
        mCanvas.drawRoundRect(new RectF(30, top, x - 30, bottom), 30, 30, initPaintRect());

    }

    private Paint initPaintRect(){
        mPaintRect.setColor(Color.BLACK);
        mPaintRect.setStyle(Paint.Style.STROKE);
        mPaintRect.setStrokeWidth(2);
        return mPaintRect;
    }

}
