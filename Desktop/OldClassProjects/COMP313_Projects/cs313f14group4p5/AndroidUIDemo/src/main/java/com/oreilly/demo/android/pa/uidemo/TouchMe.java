package com.oreilly.demo.android.pa.uidemo;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;

import com.oreilly.demo.android.pa.uidemo.model.ApplicationContext;
import com.oreilly.demo.android.pa.uidemo.model.DefaultMonster;
import com.oreilly.demo.android.pa.uidemo.model.Monster;
import com.oreilly.demo.android.pa.uidemo.view.Grid;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TouchMe extends Activity {
    Context c = ApplicationContext.getContext();
    Drawable trashcan = c.getResources().getDrawable(R.drawable.trashcan);

    private static final class TrackingTouchListener implements View.OnTouchListener {

        private List<Integer> tracks = new ArrayList<Integer>();
        Grid grid;

        TrackingTouchListener(Grid grid) {
            this.grid = grid;
        }

        //onTouch methods
        @Override
        public boolean onTouch(View v, MotionEvent evt) {
            int n,x,y;
            int idx;
            int action = evt.getAction();
            switch (action & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    x = ((int)evt.getX())/grid.getItemSize();
                    y = ((int)evt.getY())/grid.getItemSize();
                    Object item = grid.getItem(x,y);
                    if(item instanceof Monster && ((Monster)item).onTouch()){
                        grid.setItem(x,y,null, new Canvas());
                    }

                case MotionEvent.ACTION_POINTER_DOWN:
                    idx = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                            >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                    tracks.add(Integer.valueOf(evt.getPointerId(idx)));
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    idx = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                            >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                    tracks.remove(Integer.valueOf(evt.getPointerId(idx)));
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                default:
                    return false;

            }
            return true;
        }

    }

    //generates monsters on a runnable
    private final class MonsterGenerator implements Runnable{
        final DefaultMonster monster;
   //
        private final Handler hdlr = new Handler();
        private final Runnable makeMonster = new Runnable() {
            @Override
            public void run() {
                makeMonster();
            }
        };
        private volatile boolean done;

        MonsterGenerator(DefaultMonster monster){
            this.monster = monster;

        }
        int k; //represents number of Monsters generated
        public void done() {
            done = true;
        }
        @Override
        public void run(){
            while(!done){
                hdlr.post(makeMonster);
                try {
                    Thread.sleep(50);
                    k++;
                    if(k == 10) //setting minimum k monster
                    return;
                }
                catch(InterruptedException e){}

            }
        }

    }

    private final Random rand = new Random();
    final DefaultMonster monsterModel = new DefaultMonster();
    Grid view;
    MonsterGenerator monsterGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        view = new Grid(c);
        view.setDefaultMonster(monsterModel);
        view.setOnCreateContextMenuListener(this);
        view.setOnTouchListener(new TrackingTouchListener(view));
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus && (null != monsterGenerator)) {
                    monsterGenerator.done();
                    monsterGenerator = null;
                    }
                else if (hasFocus && (null == monsterGenerator)) {
                    monsterGenerator = new MonsterGenerator(monsterModel);
                    new Thread(monsterGenerator).start();
                    }
            }
        });
    }


    //makes monsters at a random location
    public void makeMonster() {
        int x = (int)(Math.random()*view.getRowCount());
        int y = (int)(Math.random()*view.getColCount());

        while (view.getItem(x,y) instanceof Monster) {
            x = (int)(Math.random()*view.getRowCount());
            y = (int)(Math.random()*view.getColCount());
        }
        view.setItem(x,y,new DefaultMonster(x,y), new Canvas());
    }


}