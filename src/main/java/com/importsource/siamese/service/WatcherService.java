package com.importsource.siamese.service;

import com.importsource.siamese.watcher.WatchedEvent;
import com.importsource.siamese.watcher.Watcher;

public interface WatcherService {
    public void attach(Watcher watcher);
    public void process(WatchedEvent event);
}
