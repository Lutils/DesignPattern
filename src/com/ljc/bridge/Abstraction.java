package com.ljc.bridge;
/**
 * 抽象部分实现
 */
public abstract class Abstraction {
	//用于引用实现部分的对象
	private Implementor implementor;
	
	public Abstraction(Implementor implementor) {
		this.implementor = implementor;
	}
	// 通过调用实现部分的具体方法实现具体的功能
	public void operation() {
		implementor.operate();
	}
	
}