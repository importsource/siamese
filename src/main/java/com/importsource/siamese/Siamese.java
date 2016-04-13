package com.importsource.siamese;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;

/**
 * 客户端发送请求的api
 * @author Hezf
 * 
 */
public class Siamese {
	private  Logger logger = LogManager.getLogger(Client.class);
	
	private Socket client;
	/**
	 * 新建一个siamese实例
	 * @param host 服务器ip和端口
	 * @param timeout 超时时间
	 * @param watcher 设置监控
	 */
	public Siamese(String host, int timeout, Watcher watcher) {
		try {
			client = new Socket(getIp(host), getPort(host));
			client.setSoTimeout(timeout);
		} catch (UnknownHostException e) {
			logger.e(e.getMessage());
		} catch (IOException e) {
			logger.e(e.getMessage());
		}
		
	}

	private String getIp(String host) {
		String[] tmps=host.split(":");
		return tmps[0];
	}

	private int getPort(String host) {
		String[] tmps=host.split(":");
		return Integer.parseInt(tmps[1]);
	}

	public void create(String string, byte[] bytes, Ids openAclUnsafe, CreateMode persistent) {
		// 这个操作完成后直接就添加了。
		//客户端需要把信息封装好，然后通过stream发送服务端。服务端需要接收到这个消息，然后做操作。
		
		
	}

	public void getChildren(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void getData(String string, boolean b, Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setData(String string, byte[] bytes, int i) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String string, int i) {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
