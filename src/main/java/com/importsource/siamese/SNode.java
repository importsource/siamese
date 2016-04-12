package com.importsource.siamese;

/**
 * 节点。你可以在节点上保存一些信息
 * 
 * @author Hezf
 *
 */
public class SNode {
	// 父节点 （根节点的父节点为“null”）
	private String parent;

	// 节点上可以加的内容
	private String content;

	// 给节点加标签
	private String label;

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
