package com.oreilly.demo.android.pa.uidemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;

import com.oreilly.demo.android.pa.uidemo.R;
import com.oreilly.demo.android.pa.uidemo.model.DefaultMonster;
import com.oreilly.demo.android.pa.uidemo.model.Monster;
import com.oreilly.demo.android.pa.uidemo.model.VulnerableMonsterState;
import com.oreilly.demo.android.pa.uidemo.model.ProtectedMonsterState;

import android.graphics.Rect;

import java.util.HashMap;

/**
 * Created by ali on 12/5/14.
 */

public class Grid extends View{

    private volatile DefaultMonster monster;

    //location can be used to retaining a monster in a single rectangle, need to resize monster to fit in rectangle?
    private Rect [][] location;

    Drawable MonsterImage;

    Object [][] grid;

    //specific coordnates of Rectangle locations
    Coordinates [][] RectLocations;


    public class Coordinates{
        int x;
        int y;
    }

    /**
     * @param context the rest of the application
     */
    public Grid(Context context) {
        super(context);
        setFocusableInTouchMode(true);

        int size = getItemSize();
        int col = getWidth()/size;
        int row = getHeight()/size;
        grid = new Object[row][col];
    }

    public int getItemSize(){
        return getWidth()/6;
    }
    public int getRowCount(){
        return grid.length;
    }
    public int getColCount(){
        return grid[0].length;
    }

    public void setItem(int k, int l, Monster o, Canvas canvas) {
        //Bitmap monsterPng = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        grid [k][l]= o;
        Paint paint = new Paint();


        if (o.getState() instanceof VulnerableMonsterState) {
            paint.setColor(hasFocus() ? Color.YELLOW : Color.YELLOW);
            paint.setStyle(Style.FILL);
            canvas.drawRect(location[k][l], paint);
        }
        else {if (o.getState() instanceof ProtectedMonsterState) {
            paint.setColor(hasFocus() ? Color.GREEN : Color.GREEN);
            paint.setStyle(Style.FILL);
            canvas.drawRect(location[k][l], paint);
        }
        }
    }


    public Object getItem(int r, int c){
        Coordinates coord = new Coordinates();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++ ) {
                coord = RectLocations[i][j];
                if (grid [i][j] instanceof Monster && location[i][j].contains(r,c)){
                    return grid[i][j];
                }
            }

        }
        return null;

    }

    /**
     * @param context
     * @param attrs
     */
    public Grid(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusableInTouchMode(true);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public Grid(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusableInTouchMode(true);
    }

    public void setDefaultMonster(DefaultMonster monster) {
        this.monster = monster;
    }

    /**
     * @see android.view.View#onDraw(android.graphics.Canvas)
     * draws individual rectangles (squares) to canvas to represent a grid
     */
    @Override
    protected void onDraw(Canvas canvas) {
        int n = 0;
        int offset;
        Coordinates coord = new Coordinates();
        int size = getWidth()/6;
        int col = getColCount();
        int row = getRowCount();

        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setColor(hasFocus() ? Color.BLACK : Color.GRAY);
        canvas.drawRect(0,0, getWidth() - 1, getHeight() - 1, paint);
        paint.setStyle(Style.STROKE);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                offset = i + j;
                paint.setColor((getItem(i,j) instanceof Monster)? ((Monster) getItem(i,j)).getState().getColor():Color.GRAY);
                int left = i*size;
                int top = j*size;
                int right = left + size;
                int bottom = top + size;
                canvas.drawRect(new Rect(left, top, right, bottom), paint);
                location[i][j] = new Rect(left,top, right, bottom);
                coord.x = location[i][j].centerX();
                coord.y = location[i][j].centerY();
                RectLocations[i][j] = coord;
            }
        }

    }
}