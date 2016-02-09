package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.*;

/**
 * An implementation of the stopwatch data model.
 */
public class DefaultTimeModel implements TimeModel {

	private int runningTime = 0;

	//private int lapTime = -1;

    @Override
	public void resetRuntime() {
		runningTime = 0;
	}

    public void setRuntime(int time){
        runningTime = time;
    }

    @Override
	public void incRuntime() {
		if(runningTime < 99 )runningTime = getRuntime()+1;
	}
    @Override
    public void decRuntime(){
        runningTime = (runningTime - SEC_PER_TICK);
    }
    @Override
	public int getRuntime() {
		return runningTime;
	}

   /* @Override
	public void setLaptime() {
		lapTime = runningTime;
	}

    @Override
	public int getLaptime() {
		return lapTime;
	}
	*/
}