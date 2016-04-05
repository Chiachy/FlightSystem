package com.shanshan.flightmanager;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Chiachi on 2016/4/5.
 */
public class RecyclerViewDividerLine extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL = LinearLayoutManager.VERTICAL;

    private Paint paint;//画笔

    private int orientation;//布局方向

    private int color;//分割线颜色

    private int size;//分割线尺寸

    //分割线尺寸
    public RecyclerViewDividerLine(){
        this(VERTICAL);
    }

    public RecyclerViewDividerLine(int orientation){
        this.orientation = orientation;
        paint = new Paint();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        if (orientation == VERTICAL) {
            drawHorizontal(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    /*
    * 设置分割线
    *
    * @param color 颜色
    * */
    public void setColor(int color) {
        this.color = color;
        paint.setColor(color);
    }

    /*
    *设置分割线尺寸
    *
    * @param size 尺寸
    * */
    public void setSize(int size){
        this.size = size ;
    }

    /*
    * 绘制垂直分割线
    * */
    protected void drawVertical(Canvas c, RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount ; i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params =
                    (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + size ;

            c.drawRect(left , top , right , bottom, paint);
        }
    }
    //绘制水平风格线
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for(int i= 0; i < childCount ; i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params =
                    (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + size ;

            c.drawRect(left , top , right , bottom, paint);
        }
    }
}