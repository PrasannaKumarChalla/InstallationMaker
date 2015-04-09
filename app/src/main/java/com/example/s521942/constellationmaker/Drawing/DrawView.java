package com.example.s521942.constellationmaker.Drawing;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.s521942.constellationmaker.R;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: document your custom view class.
 */
public class DrawView extends View implements View.OnTouchListener{
Paint paint=new Paint();
    public boolean clearCanvas=false;

    List<Point> pointList=new ArrayList<Point>();
    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
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
        super.onDraw(canvas);
        if(clearCanvas==true)
        {
           pointList=new ArrayList<Point>();
            canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
            paint.setColor(Color.BLACK);
            clearCanvas = false;

        }


            Log.v("d", "called ondraw");


            setFocusable(true);
            setFocusableInTouchMode(true);
            this.setOnTouchListener(this);
            setFocusable(true);
            for (int i = 0; i < pointList.size(); i++) {
                canvas.drawCircle(pointList.get(i).x, pointList.get(i).y, 10, paint);
                if (i == 0) {

                } else {
                    canvas.drawLine(pointList.get(i - 1).x, pointList.get(i - 1).y, pointList.get(i).x, pointList.get(i).y, paint);
                }
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

        return true;
    }
    public void clearCanvas(){

        this.clearCanvas = true;
        invalidate();

    }
  


   public class Point {
        float x, y;

       public float getX() {
           return x;
       }

       public void setX(float x) {
           this.x = x;
       }

       public float getY() {
           return y;
       }

       public void setY(float y) {
           this.y = y;
       }
   }
}
