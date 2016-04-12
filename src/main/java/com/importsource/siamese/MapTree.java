package com.importsource.siamese;

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
public class MapTree {
	private static Map<String, String> map;
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
		Entry<String, String> root=getRoot(map);
		System.out.println(root.getKey());
		findSub(root,"---");
		//map.remove("192.168.1.104");
		System.out.println("app1下的节点：");
	    List<Entry<String, String>> app1s=listbyApp("app1");
	    for (Iterator iterator = app1s.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			System.out.println(entry.getKey());
		}
	    
	    

	}

	private static Map<String, String> init() {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("root", "null");
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
		return map;
	}
	static Set<Entry<String, String>> set;
	
	

	private static void findSub(Entry<String, String> root,String deep) {
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			String val=entry.getValue();
			String key=entry.getKey();
			if(val.equals(root.getKey())){
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

	private static Entry<String, String> getRoot(Map<String, String> map) {
		Set<Entry<String, String>> set=map.entrySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			String val=entry.getValue();
			if(val.equals("null")){
				return entry;
			}
		}
		return null;
	}
	
	/**
	 * 添加
	 * @param key
	 * @param parentKey
	 * @return
	 */
	public static String add(String key,String parentKey){
		if(map.containsKey(key)){
			throw new  IllegalArgumentException("The key is existed");
		}
		
		if(!isParent(parentKey)){
			throw new IllegalArgumentException("The parent key is not existed!");
		}
		return map.put(key, parentKey);
	}
	
	/**
	 * 得到指定的应用下的节点
	 * @param key
	 * @return
	 */
	public static List<Entry<String, String>> listbyApp(String app){
		Set<Entry<String, String>> set=map.entrySet();
		List<Entry<String, String>> newSet=new ArrayList<Entry<String, String>>();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			String val=entry.getValue();
			if(val.equals(app)){
				newSet.add(entry);
			}
		}
		return newSet;
	}
	
	/**
	 * 节点
	 * @param key 节点key
	 * @return
	 */
	public static String remove(String key){
		return map.remove(key);
	}

	private static boolean isParent(String parentKey) {
		return map.containsKey(parentKey);
	}
}
