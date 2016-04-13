package com.importsource.siamese.client;

import com.importsource.siamese.SNode;
import com.importsource.siamese.SiameseRPC;
import com.importsource.siamese.service.DefaultService;

/**
 * rpc客户端启动器
 * 
 * @author Hezf
 *
 */
public class MainClient {
	public static void main(String[] args) {
			DefaultService defaultService =SiameseRPC.getSiameseProxy(DefaultService.class);
			SNode sNode=new SNode();
			sNode.setParent("root");
			System.out.println(defaultService.add("app7", sNode));
			System.out.println(defaultService.add("app8", sNode));
			System.out.println(defaultService.add("app9", sNode));
			
			System.out.println(defaultService.listByApp("root"));
	}

}
