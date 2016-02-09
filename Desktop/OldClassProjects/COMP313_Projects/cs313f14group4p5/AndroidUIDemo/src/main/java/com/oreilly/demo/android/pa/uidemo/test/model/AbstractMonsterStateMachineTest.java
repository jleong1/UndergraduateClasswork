package com.oreilly.demo.android.pa.uidemo.test.model;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.oreilly.demo.android.pa.uidemo.model.DefaultMonster;
import com.oreilly.demo.android.pa.uidemo.model.Monster;
import com.oreilly.demo.android.pa.uidemo.model.ProtectedMonsterState;
import com.oreilly.demo.android.pa.uidemo.model.VulnerableMonsterState;


/**
 * Created by Julie Leong on 12/7/2014.
 */

// will add something once monster starts working
public class AbstractMonsterStateMachineTest {
//tests for color
   //tests for number of monsters
    Drawable MonsterImage;
    @Test
    public void colorMatch(){
        assertEquals(new ProtectedMonsterState().getColor(), Color.GREEN);
        assertEquals(new VulnerableMonsterState().getColor(), Color.YELLOW);
    }
}


