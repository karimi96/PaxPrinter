package com.pax.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.pax.demo.canvas.MyView3;
import com.pax.demo.modules.printer.MyView2;
import com.pax.demo.modules.printer.MyView5;
import com.pax.demo.modules.printer.MyView6;
import com.pax.demo.modules.printer.PrinterTester;


public class MainActivity extends AppCompatActivity {
    TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView6 myView6 = new MyView6(this);
        setContentView(myView6);

//        setContentView(R.layout.activity_main2);


      /*  tt = findViewById(R.id.click);
        tt.setOnClickListener(view -> {
            new Thread(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                public void run() {
//                    MyView2 myView2 = new MyView2(MainActivity.this);
                    MyView3 myView3 = new MyView3(MainActivity.this);


//                    MyView3 myView3 = new MyView3(MainActivity.this);
//                    MyView5 myView5 = new MyView5(MainActivity.this);
                    ImageView imageView = findViewById(R.id.image);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(getBitmapFromView(MainActivity.this, myView3));
                            PrinterTester.getInstance().printBitmap(getBitmapFromView(MainActivity.this, myView3));
                        }
                    });
                PrinterTester.getInstance().start();
//
                }
            }).start();

        });*/




    }

    private static Bitmap getBitmapFromView(Context ctx, View view) {
        view.setLayoutParams(new
                ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        view.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels,
                View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(dm.heightPixels,
                        View.MeasureSpec.EXACTLY));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return bitmap;
    }
}