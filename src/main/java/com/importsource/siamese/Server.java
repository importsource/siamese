package com.importsource.siamese;

import java.net.ServerSocket;
import java.net.Socket;

import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;

/**
 * 初步的socket服务端
 * @author Hezf
 *
 */
public class Server {
	private static Logger logger = LogManager.getLogger(Server.class);
	public static void main(String[] args) throws Exception{
		//服务端在20006端口监听客户端请求的TCP连接
	    int port=20006;
		ServerSocket server = new ServerSocket(port);
		Socket client = null;
		boolean f = true;
		logger.i("server启动成功！端口为："+port);
		while(f){
			//等待客户端的连接，如果没有获取连接
			client = server.accept();
			logger.i("与客户端连接成功！");
			//为每个客户端连接开启一个线程
			new Thread(new ServerThread(client)).start();
		}
		server.close();
	}
}
