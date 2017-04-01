package com.ljc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LJC
 * ����ģʽ��Ϊ���������ṩһ�ִ����Կ��ƶ��������ķ���
 * ʹ�ó�����������ֱ�ӷ���ĳ���������ʴ�������ʱ������ͨ��һ�������������ӷ��ʣ�
 * 		      Ϊ�˱�֤�ͻ���ʹ�õ�͸���ԣ�ί�ж�������������Ҫʵ����ͬ�Ľӿڡ�
 */


/**
 * ��������
 */
class A implements ProxyInterface {
	@Override
	public void test() {
		System.out.println("��������");
	}
}

/**
 * ��̬���� 
 * �����ߵĴ����ɳ���Ա�Լ���ͨ��һЩ�Զ����������ɵĹ̶����룬�ٶ�����б��룬
 * �����ǵĴ���������ǰ�������class�����ļ����Ѿ����ڡ�
 */

/**
 * ��̬������
 */
class MyProxy implements ProxyInterface {
	
	private ProxyInterface m;
	//��ʵ����ͬ�Ľӿڣ�ע�뱻������
	public MyProxy(ProxyInterface m) {
		this.m = m;
	}
	@Override
	public void test() {
		System.out.println("��̬����=>ǰִ��");
		m.test();	//���ñ������෽��
		System.out.println("��̬����=>��ִ��");
	}
	
}


/**
 * ��̬����
 * ͨ��������ƶ�̬�����ɴ����ߵĶ���
 * jdk��̬����cglib��̬����
 */

/**
 * ��̬������
 */
class DynamicProxy implements InvocationHandler {

	private Object obj;
	public DynamicProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("��̬����=>ǰִ��");
		//���ñ����������ķ���
		Object result = method.invoke(obj, args);
		System.out.println("��̬����=>��ִ��");
		return result;
	}
	
}


public class ProxyPattern {

	public static void main(String[] args) {
		A a = new A();
		new MyProxy(a).test();	//��̬����
		System.out.println();
		//��̬����
		InvocationHandler invocationHandler = new DynamicProxy(a);
		ProxyInterface mProxy = (ProxyInterface) Proxy.newProxyInstance(
				a.getClass().getClassLoader(),
				a.getClass().getInterfaces(),
				invocationHandler);
		mProxy.test();
	}

}
