package com.ljc.responsibility;
/**
 * 抽象处理者
 */
public abstract class Handler {
	// 下一结点的处理者
	protected Handler successor;
	// 请求处理
	public abstract void handleRequest(String condition);
}