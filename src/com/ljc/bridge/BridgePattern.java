package com.ljc.bridge;


/**
 * @author LJC
 * �Ž�ģʽ�������󲿷���ʵ�ֲ��ַ��룬ʹ���Ƕ����Խ��ж����ر仯
 * ʹ�ó�����һ������ڶ��������仯��ά�ȣ��������ά�ȶ���Ҫ������չ
 * 		  ������Щ��ϣ��ʹ�ü̳л�����Ϊ���μ̳е���ϵͳ��ĸ����������ӵ�ϵͳ��Ҳ����ʹ��
 */

/**
 * ����ʵ����
 */
class ConcreteImplementor implements Implementor {

	@Override
	public void operate() {
		//...
	}
}

/**
 * ���󲿷�����
 */
class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}
	//�Ը�����󲿷ֵķ���������չ
	public void refinedOperation() {
		//...
	}
	
}

public class BridgePattern {

	public static void main(String[] args) {
		//...
	}

}
