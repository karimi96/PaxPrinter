package com.pax.demo.modules.printer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import com.pax.demo.R;

public class MyView2 extends View {
    Context context;
    Paint paint;
    Drawable imageShaprak, imageIranKish, imagePhone;



    public MyView2(Context context) {
        super(context);
        this.context = context;
        paint = new Paint();

        imageShaprak = context.getResources().getDrawable(R.drawable.ic_shaparak);
        imageIranKish = context.getResources().getDrawable(R.drawable.irankish2);
        imagePhone = context.getResources().getDrawable(R.drawable.phone_call);

    }

    @SuppressLint("ResourceType")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Typeface typefaceText = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.BOLD);
        Typeface typefaceNumber = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/irsansfanum.ttf"), Typeface.BOLD);
        Typeface typefaceNormal = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.NORMAL);
        Typeface typefaceNumberNormal = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/irsansfanum.ttf"), Typeface.NORMAL);



        int x = getWidth();
        int y = getHeight();
        int oy = getWidth();
        int s = (y - x) / 2;
        Log.e("111", "onDraw: X =" + x);
        Log.e("111", "onDraw: oy =" + oy);
        Log.e("111", "onDraw: s =" + s);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);


        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        canvas.drawLine(0, s + (oy / 3), x, s + (oy / 3), paint);
        canvas.drawLine(0, s + (oy * 2 / 3) + 25, x, s + (oy * 2 / 3) + 25, paint);
        canvas.drawLine(0, s + (oy * 11) / 18 + 15, x, s + (oy * 11) / 18 + 15, paint);
        canvas.drawLine(0, s + (oy * 15.5f) / 18 + 25, x, s + (oy * 15.5f) / 18 + 25, paint);

        // for image
        Rect imageBounds = canvas.getClipBounds();
        imageBounds.set((3 * x) / 4, (int) (s + ((oy * 2.7) / 18)), x - 20, (int) (s + (4.7f * oy / 18)));
        imageShaprak.setBounds(imageBounds);
        imageShaprak.draw(canvas);

        imageBounds.set(20, (int) (s + ((oy * 2.6) / 18)), ((1 * x) / 4) - 10, (int) (s + (4.7 * oy / 18)));
        imageIranKish.setBounds(imageBounds);
        imageIranKish.draw(canvas);

        imageBounds.set((1 * x) / 2 - 65, (int) (s + (oy * 4) / 18), (1 * x) / 2 - 40, (int) (s + (4.6 * oy / 18)));
        imagePhone.setBounds(imageBounds);
        imagePhone.draw(canvas);


        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "کارت اعتباری ایران کیش", x / 2, (int) (s + (oy * 3.3) / 18), paint, canvas);
        setText(Color.BLACK, 29, Paint.Align.CENTER, typefaceNumber, "1688", x / 2, s + (oy * 4.5f) / 18, paint, canvas);

        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceNormal, "تست شاپ", x - 20, s + (oy * 5.6f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumberNormal, "Tel : 0251556787", 20, s + (oy * 5.6f) / 18, paint, canvas);


        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "خرید", x - 20, s + (oy * 6.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "پایانه", x - 20, s + (oy * 7.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "بانک مسکن", x - 20, s + (oy * 8.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceNumber, "1401/1/29", x - 20, s + (oy * 9.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "پیگیری", x - 20, s + (oy * 10.7f) / 18, paint, canvas);

        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceText, "رسید مشتری", 20, s + (oy * 6.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "98088", 20, s + (oy * 7.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "0574446876", 20, s + (oy * 8.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "16:54", 20, s + (oy * 9.7f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "109", 20, s + (oy * 10.7f) / 18, paint, canvas);

        setText(Color.BLACK, 26, Paint.Align.CENTER, typefaceNumber, "تراکنش نامعتبر است (91)", x / 2, s + (oy * 12.2f) / 18, paint, canvas);

//        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "در صورت کسر وجه از حساب شما مبلغ مذکور ظرف ", x / 2, s + (oy * 13.4f) / 18, paint, canvas);
//        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "72 ساعت به حساب شما عودت خواهد شد در غیر اینصورت", x / 2, s + (oy * 14.4f) / 18, paint, canvas);
//        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "  جهت پیگیری لطفا با شماره تلفن 1688 تماس حاصل کنید.", x / 2, s + (oy * 15.4f) / 18, paint, canvas);

        String text = "در صورت کسر وجه از حساب شما مبلغ مذکور ظرف  ساعت به حساب شما عودت خواهد شد در غیر اینصورت جهت پیگیری لطفا با شماره تلفن 1688 تماس حاصل کنید.";

        TextPaint myTextPaint = new TextPaint();
        myTextPaint.setAntiAlias(true);
        myTextPaint.setTextAlign(Paint.Align.CENTER);
//        myTextPaint.setTextSize(18 * getResources().getDisplayMetrics().density);
        myTextPaint.setTextSize(28);
        myTextPaint.setTypeface(typefaceNumber);
//        myTextPaint.setColor(0xFF000000);
        myTextPaint.setColor(Color.BLACK);

        int width = x-10;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
        float spacingMultiplier = 1;
        float spacingAddition = 0;
        boolean includePadding = false;

        StaticLayout myStaticLayout = new StaticLayout(text, myTextPaint, width, alignment, spacingMultiplier, spacingAddition, includePadding);
//        float height = myStaticLayout.getHeight();
        canvas.save();
//        canvas.translate(getPaddingLeft(), getPaddingTop());
        canvas.translate( x / 2, s + (oy * 12.7f) / 18);
        myStaticLayout.draw(canvas);
        canvas.restore();

        setText(Color.BLACK, 28, Paint.Align.CENTER, typefaceNumberNormal, "9284584/85  4838/345", x / 2, s + (oy * 16.9f) / 18, paint, canvas);
    }


    public void setText(int color, int size, Paint.Align align, Typeface typeface, String text, int x, float y, Paint paint, Canvas canvas) {
        paint.setColor(color);
        paint.setTextSize(size);
        paint.setTextAlign(align);
        paint.setTypeface(typeface);
        canvas.drawText(text, x, y, paint);
    }


}
