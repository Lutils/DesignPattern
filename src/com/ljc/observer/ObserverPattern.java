package com.ljc.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author LJC 
 * 观察者模式：定义对象间一种一对多的依赖关系，使得每当一个对象发生改变时，所有依赖于他的对象都会得到通知并被自动更新
		使用场景
			1. 关联行为场景（关联行为可拆分，不是组合关系）
			2. 事件多级触发场景
			3. 跨系统的消息交换场景（如消息队列、事件总线的处理机制）
 */

/**
 * 观察者
 */
class Coder implements Observer {

	private String name;

	public Coder(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("用户名：" + name + ",发布内容" + arg);
	}

}

/**
 * 被观察的角色
 */
class Poster extends Observable {

	public void post(String content) {
		// 标识状态或者内容发生改变
		setChanged();
		// 通知所有观察者
		notifyObservers(content);
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		// 被观察角色
		Poster poster = new Poster();
		// 观察者
		Coder bob = new Coder("Bob");
		Coder jack = new Coder("Jack");
		// 注册观察者列表
		poster.addObserver(bob);
		poster.addObserver(jack);
		// 发布消息
		poster.post("发布新的内容了！");

	}

}
