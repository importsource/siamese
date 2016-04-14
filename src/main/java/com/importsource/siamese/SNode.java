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
    
	//节点名称
	private String name;
	
	// 父节点 （根节点的父节点为“null”）
	private String parent;

	// 节点上可以加的内容
	private String content;

	// 给节点加标签
	private String label;
	
	//命令 有 新增 create del update 
	private String cmd;
	//访问控制（预留）openAclUnsafe and so on
	private Ids ids;
	//创建模式（persistent、transient）
	private CreateMode createMode;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	@Override
	public String toString(){
		return "name="+this.name+"、parent="+this.parent+"、label="+this.label;
	}

	

	public CreateMode getCreateMode() {
		return createMode;
	}

	public void setCreateMode(CreateMode createMode) {
		this.createMode = createMode;
	}

	public Ids getIds() {
		return ids;
	}

	public void setIds(Ids ids) {
		this.ids = ids;
	}

}
