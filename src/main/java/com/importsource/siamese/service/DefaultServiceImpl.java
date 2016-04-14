package com.importsource.siamese.service;


import java.util.List;

import com.importsource.siamese.MapTree;
import com.importsource.siamese.SNode;

/**
 * 实现部分
 * @author Hezf
 *
 */
public class DefaultServiceImpl implements DefaultService {

	public String add(String key, SNode sNode) {
		return MapTree.add(key, sNode)==null?"null":MapTree.add(key, sNode).toString();
	}

	public List<SNode> listByApp(String app) {
		return MapTree.listbyApp(app);
	}

	public String remove(String key) {
		return MapTree.remove(key).toString();
	}

	public String update(String key, SNode sNode) {
		return MapTree.update(key, sNode).toString();
	}

	public SNode get(String key) {
		return MapTree.get(key);
	}
	

}
