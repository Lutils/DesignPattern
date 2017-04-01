package com.ljc.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJC
 * 组合模式：将对象组合成树形结构以表示"整体-部分"的层次结构，使得对单个对象和组合对象的使用具有一致性
 * 使用场景：表示对象的部分-整体层次结构时或从一个整体中能够独立出部分模块或功能的场景
 */

/**
 * 具体枝干结点
 */
class Composite extends Component {

	/**
	 * 存储结点的容器
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
 * 叶子结点
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
		throw new UnsupportedOperationException("叶子结点没有子节点");
	}

	@Override
	public void removeChild(Component child) {
		throw new UnsupportedOperationException("叶子结点没有子节点");
	}

	@Override
	public Component getChild(int index) {
		throw new UnsupportedOperationException("叶子结点没有子节点");
	}
	
}


public class CompositePattern {

	public static void main(String[] args) {
		//构造一个根结点
		Component root = new Composite("Root");
		//构造枝干结点
		Component branch1 = new Composite("Branch1");
		Component branch2 = new Composite("Branch2");
		//构造叶子结点
		Component leaf1 = new Leaf("Leaf1");
		Component leaf2 = new Leaf("Leaf2");
		//添加
		branch1.addChild(leaf1);
		branch2.addChild(leaf2);
		root.addChild(branch1);
		root.addChild(branch2);
		//执行方法
		root.doSomething();
	}

}
