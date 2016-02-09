package com.oreilly.demo.android.pa.uidemo.model;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by ConorOrth on 12/2/2014.
 */
public class VulnerableMonsterState implements MonsterState {

    int color;
    Drawable MonsterImage;

    public VulnerableMonsterState()
    {
      //  ColorFilter filter = new LightingColorFilter( Color.YELLOW, Color.YELLOW);
        //MonsterImage.setColorFilter(filter);
        color = Color.YELLOW;
    }
    public int getColor() {
        return color;
    }

}
