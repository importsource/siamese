package com.importsource.siamese.client;

import java.util.List;

import com.importsource.rpc.RPC;
import com.importsource.rpc.entity.ServiceInfo;
import com.importsource.rpc.support.Server;
import com.importsource.siamese.DefaultScannerUtil;

/**
 * 
 * rpc 服务启动器
 * @author Hezf
 * 
 */
public class SlaveServer2 {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();
		server.setPort(20384);
		List<ServiceInfo> services=DefaultScannerUtil.scan();
		server.register(services);
		server.start();
	}
}
