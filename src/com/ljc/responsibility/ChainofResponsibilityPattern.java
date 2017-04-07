package com.ljc.responsibility;

/**
 * @author LJC
 * ������ģʽ��ʹ��������л��ᴦ�����󣬴Ӷ�����������ķ����ߺͺͽ�����֮�����Ϲ�ϵ
 * 			����Щ��������һ��������������������������ֱ���ж�������Ϊֹ
 * 		ʹ�ó�����
 * 			1. ���������Դ���ͬһ�����󣬵������ĸ��������ڴ����ж�̬����
 * 			2. ���������߲���ȷ����������������е�һ���ύһ������
 * 			3. ��Ҫ��ָ̬��һ�����������
 */


/**
 * ���崦����1
 */
class ConcreteHandler1 extends Handler {

	@Override
	public void handleRequest(String condition) {
		if(condition.equals("ConcreteHandler1")) {
			System.out.println("ConcreteHandler1 Handled");
			return;
		}else{
			//������һ���Ĵ�����
			successor.handleRequest(condition);
		}
	}
}
/**
 * ���崦����2
 */
class ConcreteHandler2 extends Handler {

	@Override
	public void handleRequest(String condition) {
		if(condition.equals("ConcreteHandler2")) {
			System.out.println("ConcreteHandler2 Handled");
			return;
		}else{
			//������һ���Ĵ�����
			successor.handleRequest(condition);
		}
	}
}


public class ChainofResponsibilityPattern {

	public static void main(String[] args) {
		ConcreteHandler1 handler1 = new ConcreteHandler1();
		ConcreteHandler2 handler2 = new ConcreteHandler2();
		//handler1����һ���
		handler1.successor = handler2;
		//��������
		handler1.handleRequest("ConcreteHandler2");
	}

}
