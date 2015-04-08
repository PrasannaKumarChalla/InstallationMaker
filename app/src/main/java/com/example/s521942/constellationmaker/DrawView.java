package com.example.s521942.constellationmaker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: document your custom view class.
 */
public class DrawView extends View implements View.OnTouchListener {
//int counter=0;
Paint paint=new Paint();
    List<Point> pointList=new ArrayList<Point>();
    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint.setColor(Color.BLUE);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.DrawView, defStyle, 0);
        a.recycle();
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(Color.WHITE);
        paint.setColor(Color.BLUE);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint.setColor(Color.BLUE);
        setFocusable(true);
        for (int i=0;i<pointList.size();i++) {
           canvas.drawCircle(pointList.get(i).x, pointList.get(i).y, 10, paint);
            //canvas.dr
//            if(counter==0){
//
//            }
//            else{
//                paint.setColor(Color.RED);
//                canvas.drawLine(pointList.get(counter-1).x,pointList.get(counter-1).y,point.x,point.y,paint);
//            }
//            counter++;
        }

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        requestFocus();
        setFocusable(true);
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Point point = new Point();
        point.x = event.getX();
        point.y = event.getY();
        pointList.add(point);
    }
        invalidate();
        //Log.d("t","touch");
        return true;
    }
    class Point {
        float x, y;
    }
}
