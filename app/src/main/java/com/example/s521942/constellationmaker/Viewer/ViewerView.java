package com.example.s521942.constellationmaker.Viewer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.s521942.constellationmaker.Drawing.DrawView;
import com.example.s521942.constellationmaker.R;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: document your custom view class.
 */
public class ViewerView extends View {
//    private String mExampleString; // TODO: use a default from R.string...
//    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
//    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
//    private Drawable mExampleDrawable;
//


   // Drawings.DrawItem item=new Drawings.DrawItem("k",null);
   Drawings.DrawItem item;
    List<DrawView.Point> pointsList;
    Paint paint=new Paint();
    //List<DrawView.Point> pointsList=new ArrayList<DrawView.Point>();
   // List<Drawings.DrawItem> selectedDrawings=new ArrayList<Drawings.DrawItem>(Drawings.SELECTED_ITEMS);




    public ViewerView(Context context) {
        super(context);
        init(null, 0);
    }

    public ViewerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ViewerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ViewerView, defStyle, 0);


        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        for(Drawings.DrawItem drawing:Drawings.SELECTED_ITEMS){
            pointsList=new ArrayList<DrawView.Point>(drawing.getPointsOfDrawing());
            for (int i = 0; i < pointsList.size(); i++) {
                canvas.drawCircle(pointsList.get(i).getX(), pointsList.get(i).getY(), 10, paint);
                if (i == 0) {

                } else {
                    canvas.drawLine(pointsList.get(i - 1).getX(), pointsList.get(i - 1).getY(), pointsList.get(i).getX(), pointsList.get(i).getY(), paint);
                }
            }
        }


    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */

}
