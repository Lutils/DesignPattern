package com.ljc.builder;
/**
 * 计算机抽象类
 */
public abstract class Computer {
	
	private String board;
	private String display;
	private String os;
	public void setBoard(String board) {
		this.board = board;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public void setOs(String os) {
		this.os = os;
	}
	@Override
	public String toString() {
		return "Computer [board=" + board + ", display=" + display + ", os="
				+ os + "]";
	}
}