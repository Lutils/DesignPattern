package com.ljc.adapter;

/**
 * @author LJC
 * 适配器模式：把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的二个类能够在一起工作
 * 使用场景：接口不兼容、建立一个可重复使用的类用于类与类之间的合作、需要一个统一的输出接口但输入类型不可预知
 */


/**
 * Adaptee，需要被适配的对象
 */
class Volt200 {
	public int getVolt200(){
		return 200;
	}
}

/**
 * 类适配器模式
 */

/**
 * Adapter角色
 */
class VoltAdapter extends Volt200 implements FiveVolt {
	@Override
	public int getVolt5() {
		return 5;	
	}
}

/**
 * 对象适配器模式
 * Adapter不是使用继承关系连接到Adaptee，而是使用组合关系
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
		System.out.println(new VoltAdapter().getVolt5());	//类适配器模式
		System.out.println(new VoltAdapter2(new Volt200()).getVolt5());	//对象适配器模式
	}

}
