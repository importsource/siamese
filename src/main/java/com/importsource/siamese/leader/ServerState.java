package com.importsource.siamese.leader;

/**
 * 节点的状态
 * 
 * 分为四种：
 * 1、寻觅阶段
 * 2、跟随者
 * 3、领导节点
 * 4、普通的节点
 * @author Hezf
 *
 */
public enum ServerState {
	LEADING, FLLOWING,LOOKING,OBSERVING

}
