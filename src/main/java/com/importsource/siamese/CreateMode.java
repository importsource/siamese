package com.importsource.siamese;

/**
 * 节点存储方式
 * @author Hezf
 */
public enum CreateMode {
	/**
	 * 持久化存儲
	 */
	PERSISTENT,
	/**
	 * 臨時存儲
	 */
	EPHEMERAL,
	/**
	 *  a node like this :item0000000004,item0000000005,item0000000006
	 */
	SEQUENCE

}
