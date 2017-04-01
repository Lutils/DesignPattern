package com.ljc.bridge;


/**
 * @author LJC
 * 桥接模式：将抽象部分与实现部分分离，使他们都可以进行独立地变化
 * 使用场景：一个类存在二个独立变化的维度，且这二个维度都需要进行扩展
 * 		  对于那些不希望使用继承或者因为多层次继承导致系统类的个数急剧增加的系统，也可以使用
 */

/**
 * 具体实现类
 */
class ConcreteImplementor implements Implementor {

	@Override
	public void operate() {
		//...
	}
}

/**
 * 抽象部分子类
 */
class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}
	//对父类抽象部分的方法进行扩展
	public void refinedOperation() {
		//...
	}
	
}

public class BridgePattern {

	public static void main(String[] args) {
		//...
	}

}
