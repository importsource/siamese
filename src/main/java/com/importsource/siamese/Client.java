package com.importsource.siamese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;

/**
 * socket 长连接客户端
 * @author Hezf
 *
 */
public class Client {
	private static Logger logger = LogManager.getLogger(Client.class);
	
	public static void main(String[] args) throws IOException {
		//客户端请求与本机在20006端口建立TCP连接 
		Socket client = init();
		//获取键盘输入 
		BufferedReader keyReader = keyInput();
		//获取Socket的输出流，用来发送数据到服务端  
		PrintStream serverWriter = socketOutput(client);
		//获取Socket的输入流，用来接收从服务端发送过来的数据  
		BufferedReader serverReader = socketInput(client);
		boolean flag = true;
		while(flag){
			logger.i("输入信息：");
			String str = keyReader.readLine();
			//发送数据到服务端  
			serverWriter.println(str);
			if("bye".equals(str)){
				flag = false;
			}else{
				try{
					//从服务器端接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会抛出该异常
					String echo = serverReader.readLine();
					System.out.println(echo);
				}catch(SocketTimeoutException e){
					System.out.println("Time out, No response");
				}
			}
		}
		keyReader.close();
		close(client);
	}

	private static void close(Socket client) throws IOException {
		if(client != null){
	        //如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
			client.close();	//只关闭socket，其关联的输入输出流也会被关闭
		}
	}

	private static BufferedReader socketInput(Socket client) throws IOException {
		BufferedReader buf =  new BufferedReader(new InputStreamReader(client.getInputStream()));
		return buf;
	}

	private static PrintStream socketOutput(Socket client) throws IOException {
		PrintStream out = new PrintStream(client.getOutputStream());
		return out;
	}

	private static BufferedReader keyInput() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		return input;
	}

	private static Socket init() throws UnknownHostException, IOException, SocketException {
		Socket client = new Socket("127.0.0.1", 20006);
		client.setSoTimeout(10000);
		return client;
	}
}