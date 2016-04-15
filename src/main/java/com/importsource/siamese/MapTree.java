package com.importsource.siamese;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 这个一颗zookeeper的树
 * 
 * @author Hezf
 *
 */
public class MapTree implements Serializable{
	private static final long serialVersionUID = 1435403724318601149L;
	private static Map<String, SNode> map=new TreeMap<String, SNode>();
	static{
		SNode sNode=new SNode();
		sNode.setName("root");
		sNode.setParent("null");
		map.put("root", sNode);
	}
	public static void main(String[] args) {
		/*
		 * Map<String, Node> map=new HashMap<String,Node>(); map.put("/",new
		 * Node(null, "/")); map.put("/app1",new Node(new Node(null, "/"),
		 * "/app1")); map.put("/app2",new Node(new Node(null, "/"), "/app2"));
		 * map.put("/app2",new Node(new Node(null, "/"), "/app2"));
		 */

		map = init();
		
		set=map.entrySet();

		// 得到根节点
		Entry<String, SNode> root=getRoot();
		System.out.println(root.getKey());
		findSub(root,"---");
		//map.remove("192.168.1.104");
		System.out.println("app1下的节点：");
	    List<SNode> app1s=listbyApp("app1");
	    for (Iterator iterator = app1s.iterator(); iterator.hasNext();) {
			SNode node = (SNode) iterator.next();
			System.out.println(node.getName());
		}
	    
	    

	}

	private static Map<String, SNode> init() {
		/*map.put("root", "null");
		map.put("app1", "root");
		map.put("app2", "root");
		map.put("app3", "root");

		map.put("192.168.1.103", "app1");
		map.put("192.168.1.104", "app1");
		map.put("192.168.1.105", "app1");
		map.put("192.168.1.106", "app1");
		map.put("192.168.1.107", "app1");
		map.put("192.168.1.108", "app1");
		map.put("192.168.1.109", "app1");
		map.put("192.168.1.110", "app1");
		map.put("192.168.1.111", "app1");

		map.put("c3", "app2");
		
		map.put("c4", "app3");
		
		map.put("c5", "c4");
		
		map.put("c6", "c5");
		map.put("c7", "c5");
		map.put("c8", "c5");
		map.put("c9", "c5");
		return map;*/
		return null;
	}
	static Set<Entry<String, SNode>> set;
	
	

	private static void findSub(Entry<String, SNode> root,String deep) {
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, SNode> entry = (Entry<String, SNode>) iterator.next();
			SNode sNode=entry.getValue();
			String parent=sNode.getParent();
			String key=entry.getKey();
			if(parent.equals(root.getKey())){
				System.out.println(deep+key);
				/*for(Iterator iterator1 = set.iterator(); iterator1.hasNext();){
					Entry<String, String> entry1= (Entry<String, String>) iterator1.next();
					String val1=entry1.getValue();
					String key1=entry1.getKey();
					if(val1.equals(key)){
						System.out.println(key1);
					}
				}*/
				findSub(entry,deep+"---");
				
			}
			
			
		}
		
		
		
		
		
	}

	public static Entry<String, SNode> getRoot() {
		Set<Entry<String, SNode>> set=map.entrySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, SNode> entry = (Entry<String, SNode>) iterator.next();
			SNode val=entry.getValue();
			String parent=val.getParent();
			if(val.equals(parent)){
				return entry;
			}
		}
		return null;
	}
	
	/**
	 * 得到指定的节点
	 * @param key
	 * @return
	 */
	public static SNode get(String key){
		return map.get(key);
	}
	
	/**
	 * 添加
	 * @param key
	 * @param parentKey
	 * @return
	 */
	public static SNode add(String key,SNode sNode){
		if(sNode==null){
			throw new IllegalArgumentException("SNode can't be null");
		}
		/*if(map.containsKey(key)){
			throw new  IllegalArgumentException("The key is existed");
		}*/
		
		if(!isParent(sNode.getParent())){
			throw new IllegalArgumentException("The parent key is not existed!");
		}
		 map.put(key, sNode);
		 return sNode;
	}
	
	/**
	 * 更新
	 * @param key
	 * @param parentKey
	 * @return
	 */
	public static SNode update(String key,SNode sNode){
		if(sNode==null){
			throw new IllegalArgumentException("SNode can't be null");
		}
		if(!isParent(sNode.getParent())){
			throw new IllegalArgumentException("The parent key is not existed!");
		}
		 map.put(key, sNode);
		 return sNode;
	}
	
	/**
	 * 得到指定的应用下的节点
	 * @param key
	 * @return
	 */
	public static List<SNode> listbyApp(String app){
		Set<Entry<String, SNode>> set=map.entrySet();
		List<SNode> newSet=new ArrayList<SNode>();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, SNode> entry = (Entry<String, SNode>) iterator.next();
			SNode sNode=entry.getValue();
			String parent=sNode.getParent();
			if(parent.equals(app)){
				newSet.add(sNode);
			}
		}
		return newSet;
	}
	
	/**
	 * 节点
	 * @param key 节点key
	 * @return
	 */
	public static SNode remove(String key){
		 SNode sNode=map.get(key);
		 map.remove(key);
		 return sNode;
	}

	private static boolean isParent(String parentKey) {
		return map.containsKey(parentKey);
	}
}
