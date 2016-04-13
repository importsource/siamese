package com.importsource.siamese;

import java.io.Serializable;

/**
 * 节点。你可以在节点上保存一些信息
 * 
 * @author Hezf
 *
 */
public class SNode  implements Serializable {
	private static final long serialVersionUID = 2857977918547494033L;

	// 父节点 （根节点的父节点为“null”）
	private String parent;

	// 节点上可以加的内容
	private String content;

	// 给节点加标签
	private String label;
	
	//命令 有 新增 create del update 
	private String cmd;

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
