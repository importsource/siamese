package com.importsource.siamese.leader;

import java.util.List;

/**
 * 我的信息
 * @author Hezf
 *
 */
public class My {
    /**
     * 本地缓存的server列表
     */
	public static List<String> serverList;
	/**
	 * 本地缓存的自己的id
	 */
	public static int myid=1;
	/**
	 * 自己的状态 （ LEADING, FLLOWING 等 ）
	 */
	public static ServerState myServerState;
	/**
	 * 本地缓存的领导
	 */
	public static int leader;

}
