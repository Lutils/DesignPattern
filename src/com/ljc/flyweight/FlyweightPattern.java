package com.ljc.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ��Ԫģʽ�����Ծ����ܼ����ڴ�ʹ������ʹ�ù���������Ч֧�ִ�����ϸ���ȶ���
            ʹ�ó���
		1. ϵͳ�д��ڴ��������ƶ���
		2. ϸ���ȵĶ��󶼾߱��Ͻӽ����ⲿ״̬�������ڲ�״̬�뻷���޹�
		3. ��Ҫ����صĳ���
 */


/**
 * ��Ʊ
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
 * ��Ԫģʽ
 * ����
 */
class TicketFactroy {
	//map��Ϊ��������
	static Map<String,Ticket> map = new ConcurrentHashMap<>();
	public static Ticket getTicket(String from ,String to) {
		String key = from + "-" + to;
		if(map.containsKey(key)) {
			//ʹ�û���
			return map.get(key);
		}else{
			//���޻��������´���һ������
			TrainTicket ticket = new TrainTicket(from, to);
			//���뻺��
			map.put(key, ticket);
			return ticket;
		}
	}
}

public class FlyweightPattern {

	public static void main(String[] args) {
		new TrainTicket("����", "�Ϻ�").showTicketInfo();
	}

}
