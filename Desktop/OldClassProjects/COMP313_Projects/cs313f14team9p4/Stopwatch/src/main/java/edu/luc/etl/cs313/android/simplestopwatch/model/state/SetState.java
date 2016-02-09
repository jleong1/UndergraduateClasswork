package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;
/*
    Set State is representing for when the timer is setting itself up to be run
    @Julie
 */

class SetState implements StopwatchState {

    public SetState(final StopwatchSMStateView sm) {
        this.sm = sm; ticks = 3;
    }

    private final StopwatchSMStateView sm;

    private int ticks;

    @Override
    public void onSetStop() {  //counts if 3 seconds have passed
        sm.actionInc();
        ticks = 3;
    }
    //

    @Override
    public void onTick() {  //if the button has not been pushed and 3 seconds have passed, then switch to running state
        if(ticks <= 0){
            sm.toRunningState();
            sm.actionPlaySound();
        }
        else ticks--;
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.SET;
    }
}
