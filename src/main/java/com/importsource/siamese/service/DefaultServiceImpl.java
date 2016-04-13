package com.importsource.siamese.service;

import java.util.List;
import java.util.Map.Entry;

import com.importsource.siamese.MapTree;
import com.importsource.siamese.SNode;

/**
 * 实现部分
 * @author Hezf
 *
 */
public class DefaultServiceImpl implements DefaultService {

	public boolean add(String key, SNode sNode) {
		MapTree.add(key, sNode.getParent());
		return true;
	}

	public String listByApp(String app) {
		return MapTree.listbyApp(app).toString();
	}

	public boolean del(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(String key, SNode sNode) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
