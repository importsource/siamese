package com.importsource.siamese.watcher;

import java.io.Serializable;

/**
 * 监听器
 * @author Hezf
 *
 */
public interface Watcher extends Serializable {
	public void process(WatchedEvent event);
}
