package com.importsource.siamese.watcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.importsource.siamese.Siamese;

/**
 * 监听事件
 * 
 * @author Hezf
 *
 */
public class WatchedEvent implements Serializable {
	private static final long serialVersionUID = 3125739237875994488L;

    private List<Watcher> observers = new ArrayList<Watcher>();
	private EventType eventType;
	
	private Siamese siamese;
	
	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
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

	public void setSiamese(Siamese siamese) {
		this.siamese=siamese;
	}
	
	public Siamese getSiamese() {
		return this.siamese;
	}
}
