package com.oreilly.demo.android.pa.uidemo.model;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.oreilly.demo.android.pa.uidemo.R;
import com.oreilly.demo.android.pa.uidemo.view.Grid;

/**
 * Created by ConorOrth on 12/2/2014.
 */
public class DefaultMonster implements Monster {

    int x,y,chance;
    MonsterState state;
    Drawable MonsterImage;

    public DefaultMonster(){
        //this.MonsterImage = monsterImage;
        x = 0;
        y = 0;
        chance = 0;
        state = PROTECTED;
    }
/*
second Default monster class for when instantiating at a specific place, more than 1 monster
 */
    public DefaultMonster(int x, int y){
        this.x = x;
        this.y = y;
        chance = 0;
        state = PROTECTED;
    }

    public final MonsterState PROTECTED = new ProtectedMonsterState();
    public final MonsterState VULNERABLE = new VulnerableMonsterState();


    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean onTouch() {
        if(state == VULNERABLE)return true;
        else return false;

    }
/*
switch states randomly
 */
    public void switchState(){
        state = (state == PROTECTED) ? VULNERABLE: PROTECTED;
    }
/*
responsible for monster movement
 */
    public void run(Grid grid) {
        //R.drawable.monster_protected;

        int random = (int)(Math.random()*100);

        int width = grid.getRowCount();
        int height = grid.getColCount();

        float direction = (random/100f)*360;
        int dx = Math.round((int)Math.sin(direction));
        int dy = Math.round((int)Math.cos(direction));

        int count = 0;
        int n = 0;
        int t = 0;
        while (count<8){
            n = getX()+dx;
            t = getY()+dy;//n = x cord of potential move location, t = y cord of potential move location
            if(n>=0 && n<width && t>=0 && t<height)
            {
                if(grid.getItem(n,t) instanceof Monster);
                else{
                    setX(n);
                    setY(t);
                    grid.setItem(n,t,this, new Canvas());
                    grid.setItem(getX(),getY(),null, new Canvas());
                    setX(n);setY(t);
                    break;
                }
            }
            dx = (dx==-1&&dy==-1)? -1:(dx==-1&&dy==0)? -1:(dx==-1&&dy==1)?
                    0:(dx==0&&dy==1)?1:(dx==1&&dy==1)?1:(dx==1&&dy==0)?1:(dx==1&&dy==-1)?0:-1;

            dy = (dx==-1&&dy==-1)? 0:(dx==-1&&dy==0)? 1:(dx==-1&&dy==1)?
                    1:(dx==0&&dy==1)?1:(dx==1&&dy==1)?0:(dx==1&&dy==0)?-1:(dx==1&&dy==-1)?-1:-1;
            count++;
        }

        if(chance > random){
            switchState();
            chance = 0;
        }

        chance += 5;

    }
//return states
    @Override
    public MonsterState getState() {
        return state;
    }
}

