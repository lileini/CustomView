package com.example.litao.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * created by litao
 **/
public class MyRegionView extends View {
    public MyRegionView(Context context) {
        super(context);
    }

    public MyRegionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRegionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    http://blog.csdn.net/harvic880925/article/details/39056701
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRGB(255,255,255);

        Path path = new Path();
        path.addOval(new RectF(50,50,150,250), Path.Direction.CW);

        Region region = new Region();
        region.setPath(path,new Region(50,50,200,300));

        drawRegion(canvas,region,paint);

        Rect rect = new Rect(50, 600, 650, 800);
        Rect rect1 = new Rect(250, 400, 450, 1000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawRect(rect,paint);
        canvas.drawRect(rect1,paint);

        Region region1 = new Region(rect);
        Region region2 = new Region(rect1);

        region1.op(region2, Region.Op.XOR);
        // 区域交集
        Paint paint_fill = new Paint();
        paint_fill.setStyle(Paint.Style.FILL);
        paint_fill.setAntiAlias(true);
        paint_fill.setColor(Color.RED);

        drawRegion(canvas,region1,paint_fill);


        canvas.translate(200,200);//平移画布
        canvas.drawText("平移后的位置",0,0,paint_fill);
        canvas.rotate(30);//旋转画布
        canvas.skew(1.732f,0);//X轴倾斜60度，Y轴不变(需要了解矩阵matrix)

        canvas.clipPath(path);//按路径裁剪画布
        canvas.clipRect(rect);//按矩形裁剪画布

        canvas.save();


    }

    private void drawRegion(Canvas canvas, Region region, Paint paint) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)){
            canvas.drawRect(rect,paint);
        }
    }
}
