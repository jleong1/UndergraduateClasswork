package edu.luc.etl.cs313.android.simplestopwatch.model.time;

/**
 * The passive data model of the stopwatch.
 * It does not emit any events.
 *
 * @author laufer
 */
/*we need a decRuntime() which does opposite of incRuntime(). Also we need some method
such as setRuntime() to set a time for the timer.
*
 */
public interface TimeModel {
	void resetRuntime();
    void decRuntime();
	void incRuntime();
	public int getRuntime();
    void setRuntime(int x);
}
