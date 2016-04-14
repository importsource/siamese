package com.importsource.siamese;

import java.util.List;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;
import com.importsource.siamese.service.DefaultService;
import com.importsource.siamese.watcher.WatchedEvent;
import com.importsource.siamese.watcher.Watcher;

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
		defaultService=SiameseRPC.getSiameseProxy(DefaultService.class, getIp(host), getPort(host));
		WatchedEvent subject = new WatchedEvent();
	    subject.attach(watcher);
	}
	
	
	private int getPort(String host) {
		String[] hostArr=split(host);
		if(hostArr.length==2){
			return Integer.parseInt(hostArr[0]);
		}
		return -1;
	}


	


	private String getIp(String host) {
		String[] hostArr=split(host);
		if(hostArr.length==2){
			return hostArr[1];
		}
		return "-1";
	}
	
	private String[] split(String host) {
		if(null==host){
			throw new IllegalArgumentException("The host can't be null!");
		}
		if(!host.contains(":")){
			throw new IllegalArgumentException("HostFormatException:The host must contain colon ':'!");
		}
		return host.split(":");
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
