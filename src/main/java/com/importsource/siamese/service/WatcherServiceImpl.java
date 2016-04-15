package com.importsource.siamese.service;

import com.importsource.siamese.watcher.AppWatcher;
import com.importsource.siamese.watcher.WatchedEvent;
import com.importsource.siamese.watcher.Watcher;

public class WatcherServiceImpl implements WatcherService{

	public void attach(Watcher watcher) {
		   
		
	}

	public void process(WatchedEvent event) {
		Watcher w=new AppWatcher();
		w.process(event);
		
	}

}
