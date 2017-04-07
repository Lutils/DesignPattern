package com.ljc.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author LJC 
 * �۲���ģʽ����������һ��һ�Զ��������ϵ��ʹ��ÿ��һ���������ı�ʱ���������������Ķ��󶼻�õ�֪ͨ�����Զ�����
		ʹ�ó���
			1. ������Ϊ������������Ϊ�ɲ�֣�������Ϲ�ϵ��
			2. �¼��༶��������
			3. ��ϵͳ����Ϣ��������������Ϣ���С��¼����ߵĴ�����ƣ�
 */

/**
 * �۲���
 */
class Coder implements Observer {

	private String name;

	public Coder(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("�û�����" + name + ",��������" + arg);
	}

}

/**
 * ���۲�Ľ�ɫ
 */
class Poster extends Observable {

	public void post(String content) {
		// ��ʶ״̬�������ݷ����ı�
		setChanged();
		// ֪ͨ���й۲���
		notifyObservers(content);
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		// ���۲��ɫ
		Poster poster = new Poster();
		// �۲���
		Coder bob = new Coder("Bob");
		Coder jack = new Coder("Jack");
		// ע��۲����б�
		poster.addObserver(bob);
		poster.addObserver(jack);
		// ������Ϣ
		poster.post("�����µ������ˣ�");

	}

}
