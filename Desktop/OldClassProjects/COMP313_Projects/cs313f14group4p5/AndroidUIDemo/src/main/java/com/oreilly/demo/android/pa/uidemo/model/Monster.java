package com.oreilly.demo.android.pa.uidemo.model;

import com.oreilly.demo.android.pa.uidemo.view.Grid;
import android.graphics.Picture;

/**
 * Created by ConorOrth on 12/2/2014.
 */
public interface Monster {

    void setX(int x);
    void setY(int y);
    int getX();
    int getY();//location getters

    boolean onTouch();//returns true if should be destroyed
    void run(Grid grid);//move and change state if necessary;

    MonsterState getState();



}
