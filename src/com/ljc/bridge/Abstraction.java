package com.ljc.bridge;
/**
 * ���󲿷�ʵ��
 */
public abstract class Abstraction {
	//��������ʵ�ֲ��ֵĶ���
	private Implementor implementor;
	
	public Abstraction(Implementor implementor) {
		this.implementor = implementor;
	}
	// ͨ������ʵ�ֲ��ֵľ��巽��ʵ�־���Ĺ���
	public void operation() {
		implementor.operate();
	}
	
}