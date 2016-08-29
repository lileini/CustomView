package com.example.litao.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * created by litao
 **/
public class View2 extends View {
    public View2(Context context) {
        super(context);
    }

    public View2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    http://blog.csdn.net/harvic880925/article/details/38926877
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRGB(255,255,255);
        //画圆
        canvas.drawOval(new RectF(0f,0f,200f,150f),paint);
        //画扇形
        canvas.drawArc(new RectF(0,170,200,220),0,90,false,paint);
        //画轨迹
        Path path = new Path();
        path.moveTo(10,280);
        path.lineTo(10,382.5f);
        path.arcTo(new RectF(-40,280,60,380),-90,180);
        canvas.drawPath(path,paint);
//        canvas.drawTextOnPath("我想嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻",path,0,18,paint);

        Path cwRectPath = new Path();
        cwRectPath.moveTo(50,450);
        RectF rect = new RectF(50,450,250,650);
//        cwRectPath.addRect(rect, Path.Direction.CCW);//逆时针
        canvas.drawPath(cwRectPath,paint);
        paint.setTextSize(35);
        canvas.drawTextOnPath("一二三四五六七八九十十一十二",cwRectPath,0,18,paint);

        path.addRoundRect(rect,new float[]{10,20,10,10,10,10,10,10}, Path.Direction.CW);
        canvas.drawPath(path,paint);
        paint.setTextSize(20);
        paint.setStrokeWidth(2);
        canvas.drawPosText("风萧萧",new float[]{100,50,120,70,140,50},paint);

        Typeface typeface = Typeface.create("楷体", Typeface.NORMAL);
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(typeface);

        canvas.drawText("测试加粗楷体",50,700,paint);

    }
}
