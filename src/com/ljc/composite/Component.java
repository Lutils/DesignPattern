package com.ljc.composite;
/**
 * ������ڵ�
 */
public abstract class Component {
	
	protected String name;
	public Component(String name) {
		this.name = name;
	}
	public abstract void doSomething();	//�����߼�����������ʵ��
	/**
	 * ����ӽڵ�
	 * @param child
	 */
	public abstract void addChild(Component child);
	/**
	 * �Ƴ��ӽڵ�
	 * @param child
	 */
	public abstract void removeChild(Component child);
	/**
	 * ��ȡ�ӽڵ�
	 * @param child
	 */
	public abstract Component getChild(int index);
	
}