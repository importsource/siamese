package com.importsource.siamese;

import com.importsource.rpc.RPC;

/**
 * siamese定制rpc
 * @author Hezf
 */
public class SiameseRPC {
	private static final String SERVER_HOST = "127.0.0.1";
	private static final int PORT = 20382;

	/**
	 * 得到实例（使用默认配置好的ip和端口来请求)
	 * @param clazz 接口类
	 * @return <T> T 通过反射获得的具体实例
	 */
	public  static <T> T  getSiameseProxy(final Class<T> clazz) {
		T t=RPC.getProxy(clazz, SERVER_HOST, PORT);
		return t;
	}
	
	/**
	 * 得到实例
	 * @param clazz 接口类
	 * @param host 服务器ip
	 * @param port 服务器端口
	 * @return <T> T 通过反射获得的具体实例
	 */
	public  static <T> T  getSiameseProxy(final Class<T> clazz,String host,int port) {
		T t=RPC.getProxy(clazz, host, port);
		return t;
	}
	
	/**
	 * 得到实例
	 * @param clazz 接口类
	 * @param host 主机
	 * @param port 端口
	 * @param timeout 超时时间
	 * @return <T> T 通过反射获得的具体实例
	 */
	public  static <T> T  getSiameseProxy(final Class<T> clazz,String host,int port,int timeout) {
		T t=RPC.getProxy(clazz, host, port,timeout);
		return t;
	}
}
