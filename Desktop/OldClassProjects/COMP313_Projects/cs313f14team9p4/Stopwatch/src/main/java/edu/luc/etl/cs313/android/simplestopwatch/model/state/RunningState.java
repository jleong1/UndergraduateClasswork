package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;


class RunningState implements StopwatchState {

	public RunningState(final StopwatchSMStateView sm) {
		this.sm = sm;
	}

	private final StopwatchSMStateView sm;

    @Override
	public void onSetStop() { //onButtonPress(), if button stops during running state then go back to sto    final MediaPlayer mediaPlayer = new MediaPlayer();ppedstate
		sm.actionReset();
		sm.toStoppedState();
	}

	@Override
	public void onTick() {
		sm.actionDec();
        if(sm.getRuntime()==0){ //condition of switching states when tic/time is 0
            sm.toAlarmState();
        }
	}

	@Override
	public void updateView() {
		sm.updateUIRuntime();
	}

	@Override
	public int getId() {
		return R.string.RUNNING;
	}
}
