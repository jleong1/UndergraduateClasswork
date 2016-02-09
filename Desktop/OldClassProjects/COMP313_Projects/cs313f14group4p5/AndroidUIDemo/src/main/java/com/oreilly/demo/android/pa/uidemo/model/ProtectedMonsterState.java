package com.oreilly.demo.android.pa.uidemo.model;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by ConorOrth on 12/2/2014.
 */
public class ProtectedMonsterState implements MonsterState {

    int color;
    Drawable MonsterImage;
    public ProtectedMonsterState()
    {
       // ColorFilter filter = new LightingColorFilter( Color.GREEN, Color.GREEN);
        //MonsterImage.setColorFilter(filter);
        color = Color.GREEN;
    }

    @Override
    public int getColor() {
        return color;
    }
}
