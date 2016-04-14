package com.importsource.siamese;

import java.util.List;

import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;
import com.importsource.siamese.service.DefaultService;

/**
 * 客户端发送请求的api
 * @author Hezf
 * 
 */
public class Siamese {
	private  Logger logger = LogManager.getLogger(Client.class);
	
	DefaultService defaultService =SiameseRPC.getSiameseProxy(DefaultService.class);
	
	/**
	 * 新建一个siamese实例
	 * @param host 服务器ip和端口
	 * @param timeout 超时时间
	 * @param watcher 设置监控
	 */
	public Siamese(String host, int timeout, Watcher watcher) {
		
		
	}
	
	
	/**
	 * 新建一个siamese实例
	 * @param host 服务器ip
	 * @param port 服务器端口
	 */
    public Siamese(String host,int port) {
		defaultService=SiameseRPC.getSiameseProxy(DefaultService.class, host, port);
	}
	
	
	
	/**
	 * 现在就用这个就可以了
	 */
	public Siamese(){
		super();
	}

	

	public void create(String key, SNode sNode) {
		defaultService.add(key, sNode);
	}

	public List<SNode> getChildren(String key, boolean b) {
		return defaultService.listByApp(key);
	}

	public SNode getData(String key, boolean b, Object object) {
		return defaultService.get(key);
		
	}

	public void setData(String key, SNode sNode, int i) {
		defaultService.add(key, sNode);
		
	}

	public void delete(String key, int i) {
		defaultService.remove(key);
		
	}

	public void close() {
		// TODO 暂无实现
		
	}

}
