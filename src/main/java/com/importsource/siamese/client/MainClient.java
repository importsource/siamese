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
			SNode sNode4=new SNode();
			sNode4.setParent("root");
			sNode4.setName("app4");
			sNode4.setLabel("label4");

			SNode sNode5=new SNode();
			sNode5.setParent("root");
			sNode5.setName("app5");
			sNode5.setLabel("label5");
			
			SNode sNode6=new SNode();
			sNode6.setParent("root");
			sNode6.setName("app6");
			sNode6.setLabel("label6");
			
			System.out.println(defaultService.add("app4", sNode4));
			System.out.println(defaultService.add("app5", sNode5));
			System.out.println(defaultService.add("app6", sNode6));
			
			System.out.println(defaultService.listByApp("root"));
			
			
	}

}
