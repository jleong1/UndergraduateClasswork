package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class StoppedState implements StopwatchState {

	public StoppedState(final StopwatchSMStateView sm) {
		this.sm = sm;
	}

	private final StopwatchSMStateView sm;//sm = state machine

	@Override
	public void onSetStop() {
		sm.actionStart();
        sm.actionInc();
		sm.toSetState();
	}

	@Override
	public void onTick() {
		//throw new UnsupportedOperationException("onTick");
        sm.actionStop();
	}

	@Override
	public void updateView() {
		sm.updateUIRuntime();
	}

	@Override
	public int getId() {
		return R.string.STOPPED;
	}
}
