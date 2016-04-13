package com.importsource.siamese.service;


import com.importsource.siamese.SNode;

/**
 * 这个服务主要负责siamese的基本操作
 * @author Hezf
 *
 */
public interface DefaultService {
	/**
	 * 添加一个默认的
	 * @param key 键
	 * @param sNode 对应的节点值
	 * @return boolean 是否插入成功
	 */
    public boolean add(String key,SNode sNode);
    
    /**
     * 通过指定的key获取该key之下的节点
     * @param app 
     * @return String 一个特定格式的串
     */
    public String listByApp(String app);
    
    /**
     * 删除一个节点
     * @param key
     * @return boolean 是否删除成功
     */
    public boolean del(String key);
    
    /**
     * 删除一个节点
     * @param key
     * @return boolean 是否删除成功
     */
    public boolean update(String key,SNode sNode);
}
