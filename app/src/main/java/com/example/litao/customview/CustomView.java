package com.example.litao.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * created by litao
 **/
public class CustomView extends View{
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    http://blog.csdn.net/harvic880925/article/details/38875149
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRGB(255,255,255);
        //画圆
        canvas.drawCircle(100,100,80,paint);
        //        paint.setStrokeWidth(20.0f);
        //画字体
        paint.setShadowLayer(15,15,10,Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("ssssmmmm",300,300,paint);
        //画矩形
        canvas.drawRect(200,500,500,700,paint);

        float[] ptls = new float[]{0,720,100,900};
        paint.setStrokeWidth(20);
//        画线
        canvas.drawLines(ptls,paint);
        float[] ptls2 = new float[]{100,900,200,720};
        canvas.drawLines(ptls2,paint);
        //画点
        canvas.drawPoint(300,1000,paint);

        //带圆角的矩形
        RectF rect = new RectF(220,800,420,900);
        canvas.drawRoundRect(rect,20,10,paint);


    }
}
