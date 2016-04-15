package com.importsource.siamese.watcher;

/**
 * 增加通用watcher
 * @author Hezf
 *
 */
public class AppWatcher implements Watcher {
	public void process(WatchedEvent event) {
		System.out.println("进来没？");
		//DefaultService defaultService =SiameseRPC.getSiameseProxy(DefaultService.class);
		//System.out.println("defaultService.listByApp(\"root\"):"+defaultService.listByApp("root"));
		System.out.println("请求服务端的变化："+event.getList());
	}

}
 