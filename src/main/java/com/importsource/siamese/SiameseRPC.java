package com.importsource.siamese;

import com.importsource.rpc.RPC;


public class SiameseRPC {
	private static final int PORT = 20382;
	private static final String SERVER_HOST = "127.0.0.1";

	public  static <T> T  getSiameseProxy(final Class<T> clazz) {
		T t=RPC.getProxy(clazz, SERVER_HOST, PORT);
		return t;
	}
}
