package com.importsource.siamese.client;

import java.util.List;

import com.importsource.rpc.RPC;
import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.support.Server;
import com.importsource.siamese.DefaultScannerUtil;
import com.importsource.siamese.service.WatcherService;
import com.importsource.siamese.service.WatcherServiceImpl;
import com.importsource.siamese.watcher.AppWatcher;
import com.importsource.siamese.watcher.Watcher;

/**
 * 
 * rpc 服务启动器
 * @author Hezf
 * 
 */
public class MasterServer {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();
		List<ServiceInfo> services=DefaultScannerUtil.scan();
		server.register(services);
		//注册监听器
		server.register(WatcherService.class, WatcherServiceImpl.class);
		server.start();
	}
}
