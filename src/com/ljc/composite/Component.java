package com.ljc.composite;
/**
 * 抽象根节点
 */
public abstract class Component {
	
	protected String name;
	public Component(String name) {
		this.name = name;
	}
	public abstract void doSomething();	//具体逻辑方法由子类实现
	/**
	 * 添加子节点
	 * @param child
	 */
	public abstract void addChild(Component child);
	/**
	 * 移除子节点
	 * @param child
	 */
	public abstract void removeChild(Component child);
	/**
	 * 获取子节点
	 * @param child
	 */
	public abstract Component getChild(int index);
	
}