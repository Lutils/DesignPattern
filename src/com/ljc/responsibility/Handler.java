package com.ljc.responsibility;
/**
 * ��������
 */
public abstract class Handler {
	// ��һ���Ĵ�����
	protected Handler successor;
	// ������
	public abstract void handleRequest(String condition);
}