package com.ljc.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式：用以尽可能减少内存使用量，使用共享对象可有效支持大量的细粒度对象
            使用场景
		1. 系统中存在大量的相似对象
		2. 细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关
		3. 需要缓冲池的场景
 */


/**
 * 火车票
 */
class TrainTicket implements Ticket {

	private String from;
	private String to;
	
	public TrainTicket(String from, String to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void showTicketInfo() {
		System.out.println(from+"=>"+to);
	}
	
}

/**
 * 享元模式
 * 举例
 */
class TicketFactroy {
	//map作为缓存容器
	static Map<String,Ticket> map = new ConcurrentHashMap<>();
	public static Ticket getTicket(String from ,String to) {
		String key = from + "-" + to;
		if(map.containsKey(key)) {
			//使用缓存
			return map.get(key);
		}else{
			//若无缓存则重新创建一个对象
			TrainTicket ticket = new TrainTicket(from, to);
			//加入缓存
			map.put(key, ticket);
			return ticket;
		}
	}
}

public class FlyweightPattern {

	public static void main(String[] args) {
		new TrainTicket("安徽", "上海").showTicketInfo();
	}

}
