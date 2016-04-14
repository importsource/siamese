package com.importsource.siamese.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听事件
 * 
 * @author Hezf
 *
 */
public class WatchedEvent {
	private List<Watcher> observers = new ArrayList<Watcher>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Watcher watcher) {
		observers.add(watcher);
	}

	public void notifyAllObservers() {
		for (Watcher watcher : observers) {
			watcher.process(this);
		}
	}
}
