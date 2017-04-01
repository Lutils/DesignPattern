package com.ljc.adapter;

/**
 * @author LJC
 * ������ģʽ����һ����Ľӿڱ任�ɿͻ������ڴ�����һ�ֽӿڣ��Ӷ�ʹԭ����ӿڲ�ƥ����޷���һ�����Ķ������ܹ���һ����
 * ʹ�ó������ӿڲ����ݡ�����һ�����ظ�ʹ�õ�������������֮��ĺ�������Ҫһ��ͳһ������ӿڵ��������Ͳ���Ԥ֪
 */


/**
 * Adaptee����Ҫ������Ķ���
 */
class Volt200 {
	public int getVolt200(){
		return 200;
	}
}

/**
 * ��������ģʽ
 */

/**
 * Adapter��ɫ
 */
class VoltAdapter extends Volt200 implements FiveVolt {
	@Override
	public int getVolt5() {
		return 5;	
	}
}

/**
 * ����������ģʽ
 * Adapter����ʹ�ü̳й�ϵ���ӵ�Adaptee������ʹ����Ϲ�ϵ
 */
class VoltAdapter2 implements FiveVolt {

	private Volt200 mVolt200;

	public VoltAdapter2(Volt200 mVolt200) {
		this.mVolt200 = mVolt200;
	}

	public int getVolt200() {
		return mVolt200.getVolt200();
	}

	@Override
	public int getVolt5() {
		return 5;
	}
	
}


public class AdapterPattern {

	public static void main(String[] args) {
		System.out.println(new VoltAdapter().getVolt5());	//��������ģʽ
		System.out.println(new VoltAdapter2(new Volt200()).getVolt5());	//����������ģʽ
	}

}
