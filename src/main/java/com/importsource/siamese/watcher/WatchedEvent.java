package com.importsource.siamese.watcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.importsource.siamese.MapTree;
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
	
	private String list="";
	
	private Siamese siamese;
	
	public void setList(){
		list= MapTree.listbyApp("root").toString();
	}
	
	public String getList(){
		return list;
	}
	

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
		//setList();
		System.out.println("进入notifyAllObservers方法了");
		//System.out.println("WatcherPool.observers.size():"+WatcherPool.observers.size());
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
