package com.ljc.builder;
/**
 * ����Builder��
 */
public abstract class Builder {
	// ��������
	public abstract Builder setBoard(String board);
	// ������ʾ��
	public abstract Builder setDisplay(String display);
	// ���ò���ϵͳ
	public abstract Builder setOS(String os);
	// ����computer
	public abstract Computer build();
}