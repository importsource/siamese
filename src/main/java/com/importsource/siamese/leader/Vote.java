package com.importsource.siamese.leader;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 1、收集第一轮投票结果
 * <p>
 * 2、统计投票数，计算出投票数最大的id
 * <P>
 * 3、如果投票数超过1/2则选该id为leader
 * <P>
 * 4、如果最大投票数id没有超过1/2,则推荐txid最大的id为leader
 * <p>
 * 5、计算出最大的txid及其服务器id
 * <p>
 * 6、计算出最大的txid有几个
 * <p>
 * 7、如果最大txid超过一个，则比较服务器id，推荐服务id最大的为leader
 * <p>
 * 8、发起第二轮投票
 * <p>
 * 
 * @author Hezf
 *
 */
public class Vote {
	public static void main(String[] args) {
		Vote vote1 = new Vote();
		Map<Integer, Notification> vote = new HashMap<Integer, Notification>();

		Notification nf = new Notification();
		nf.id = 1;
		nf.leader = 1;
		nf.txid = 1;

		Notification nf1 = new Notification();
		nf1.id = 2;
		nf1.leader = 2;
		nf1.txid = 2;

		Notification nf2 = new Notification();
		nf2.id = 3;
		nf2.leader = 3;
		nf2.txid = 3;

		Notification nf3 = new Notification();
		nf3.id = 4;
		nf3.leader = 4;
		nf3.txid = 4;

		Notification nf4 = new Notification();
		nf4.id = 5;
		nf4.leader = 5;
		nf4.txid = 5;

		Notification nf5 = new Notification();
		nf5.id = 6;
		nf5.leader = 6;
		nf5.txid = 6;

		Notification nf6 = new Notification();
		nf6.id = 7;
		nf6.leader = 7;
		nf6.txid = 7;

		Notification nf7 = new Notification();
		nf7.id = 8;
		nf7.leader = 8;
		nf7.txid = 8;

		vote.put(1, nf);
		vote.put(2, nf1);
		vote.put(3, nf2);
		/*
		 * vote.put(4, nf3); vote.put(5, nf4);
		 */
		vote.put(6, nf5);
		vote.put(7, nf6);
		vote.put(8, nf7);

		int leader=vote1.forLeader(vote);
		vote1.setMyState(leader);
		System.out.println("My.leader:" + My.leader);
	}

	/**
	 * 选举leader
	 * 
	 * @param vote
	 *            投票信息
	 * @return
	 */
	public int forLeader(Map<Integer, Notification> vote) {
		// 统计leader投票数
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		for (Map.Entry<Integer, Notification> entry : vote.entrySet()) {
			Notification nf = entry.getValue();
			if (tmap.containsKey(nf.leader))
				tmap.put(nf.leader, tmap.get(nf.leader) + 1);
			else
				tmap.put(nf.leader, 1);
		}
		// 计算出投票数最大的id
		int a = 0;
		int l = 0;
		for (Map.Entry<Integer, Integer> entry : tmap.entrySet()) {
			if (entry.getValue() > a) {
				a = entry.getValue();
				l = entry.getKey();
			}
		}
		System.out.println("My.myid:" + My.myid);
		// 如果投票数超过1/2则选该id为leader
		// TODO 暂时用这个来替代 if (a / (My.serverList.size() * 1.0) > 1 / 2.0) {
		System.out.println("a:" + a);
		System.out.println("a / (11 * 1.0) > 1 / 2.0:" + (a / (15 * 1.0) > 1 / 2.0));
		System.out.println("l:" + l);

		if (a / (10 * 1.0) > 1 / 2.0) {
			// 选出leader
			return l;
		}
		// 如果最大投票数leader没有超过1/2,则推荐txid最大的id为leader
		// 计算出最大的txid及其服务器id
		long txid = 0;
		int leader = 0;
		for (Map.Entry<Integer, Notification> entry : vote.entrySet()) {
			if (entry.getValue().txid > txid) {
				leader = entry.getKey();
				txid = entry.getValue().txid;
			}
		}
		// 计算出最大的txid有几个
		Map<Integer, Notification> vte = new TreeMap<Integer, Notification>();
		for (Map.Entry<Integer, Notification> entry : vote.entrySet()) {
			if (entry.getValue().txid == txid) {
				vte.put(entry.getValue().id, entry.getValue());
			}
		}
		// 如果超过一个，则比较服务器id，推荐服务id最大的为leader
		if (vte.size() > 1) {
			for (Map.Entry<Integer, Notification> entry : vte.entrySet()) {
				if (entry.getValue().id > leader)
					leader = entry.getKey();
			}
		}

		return leader;
	}
    
	/**
	 * 设置自己的状态
	 * @param leader
	 */
	public void setMyState(int leader) {
		if (leader == My.myid) {
			My.myServerState = ServerState.LEADING;
		} else {
			My.myServerState = ServerState.FLLOWING;
		}
		My.leader = leader;
	}
}
