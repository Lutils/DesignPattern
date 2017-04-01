package com.ljc.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJC
 * ���ģʽ����������ϳ����νṹ�Ա�ʾ"����-����"�Ĳ�νṹ��ʹ�öԵ����������϶����ʹ�þ���һ����
 * ʹ�ó�������ʾ����Ĳ���-�����νṹʱ���һ���������ܹ�����������ģ����ܵĳ���
 */

/**
 * ����֦�ɽ��
 */
class Composite extends Component {

	/**
	 * �洢��������
	 */
	private List<Component> list = new ArrayList<>();
	
	public Composite(String name) {
		super(name);
	}

	@Override
	public void doSomething() {
		System.out.println(name);
		if(list != null) {
			for (Component c : list) {
				c.doSomething();
			}
		}
	}

	@Override
	public void addChild(Component child) {
		list.add(child);
	}

	@Override
	public void removeChild(Component child) {
		list.remove(child);
	}

	@Override
	public Component getChild(int index) {
		return list.get(index);
	}
	
}

/**
 * Ҷ�ӽ��
 */
class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void doSomething() {
		System.out.println(name);
	}

	@Override
	public void addChild(Component child) {
		throw new UnsupportedOperationException("Ҷ�ӽ��û���ӽڵ�");
	}

	@Override
	public void removeChild(Component child) {
		throw new UnsupportedOperationException("Ҷ�ӽ��û���ӽڵ�");
	}

	@Override
	public Component getChild(int index) {
		throw new UnsupportedOperationException("Ҷ�ӽ��û���ӽڵ�");
	}
	
}


public class CompositePattern {

	public static void main(String[] args) {
		//����һ�������
		Component root = new Composite("Root");
		//����֦�ɽ��
		Component branch1 = new Composite("Branch1");
		Component branch2 = new Composite("Branch2");
		//����Ҷ�ӽ��
		Component leaf1 = new Leaf("Leaf1");
		Component leaf2 = new Leaf("Leaf2");
		//���
		branch1.addChild(leaf1);
		branch2.addChild(leaf2);
		root.addChild(branch1);
		root.addChild(branch2);
		//ִ�з���
		root.doSomething();
	}

}
