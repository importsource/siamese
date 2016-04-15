package com.importsource.siamese.service;


import java.util.List;

import com.importsource.siamese.MapTree;
import com.importsource.siamese.SNode;
import com.importsource.siamese.SiameseRPC;
import com.importsource.siamese.watcher.WatchedEvent;
import com.importsource.siamese.watcher.Watcher;
import com.importsource.siamese.watcher.WatcherPool;

/**
 * 实现部分
 * @author Hezf
 *
 */
public class DefaultServiceImpl implements DefaultService {

	public String add(String key, SNode sNode) {
		return MapTree.add(key, sNode)==null?"null":MapTree.add(key, sNode).toString();
	}

	public List<SNode> listByApp(String app) {
		System.out.println("来请求列表来了");
		return MapTree.listbyApp(app);
	}

	public String remove(String key) {
		String result= MapTree.remove(key).toString();
		WatchedEvent event=new WatchedEvent();
		event.notifyAllObservers();
		return result;
	}

	public String update(String key, SNode sNode) {
		return MapTree.update(key, sNode).toString();
	}

	public SNode get(String key) {
		return MapTree.get(key);
	}

	public void attach(Watcher watcher) {
		WatchedEvent event=new WatchedEvent();
		event.attach(watcher);
		
		System.out.println("WatcherPool.observers.size():"+WatcherPool.observers.size());
		
	}

	public void process(WatchedEvent event) {
		
		
	}

	
	

}
