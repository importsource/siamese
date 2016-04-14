package com.importsource.siamese.watcher;

public class AppWatcher implements Watcher {

	public void process(WatchedEvent event) {
		 System.out.println(event.getState());
	}

}
