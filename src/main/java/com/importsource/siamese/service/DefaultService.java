package com.importsource.siamese.service;


import java.util.List;
import java.util.Map.Entry;

import com.importsource.siamese.SNode;

/**
 * 这个服务主要负责siamese的基本操作
 * @author Hezf
 */
public interface DefaultService {
	/**
	 * 添加一个默认的
	 * @param key 键
	 * @param sNode 对应的节点值
	 * @return String 
	 */
    public String add(String key,SNode sNode);
    
    /**
     * 通过指定的key获取该key之下的节点
     * @param app 
     * @return String 一个特定格式的串
     */
    public List<SNode> listByApp(String app);
    
    /**
     * 删除一个节点
     * @param key
     * @return String 
     */
    public String remove(String key);
    
    /**
     * 删除一个节点
     * @param key
     * @return String 是否删除成功
     */
    public String update(String key,SNode sNode);
    
    /**
     * 通过key得到指定的节点
     * @param key 
     * @return String 节点信息
     */
    public SNode get(String key);
}
