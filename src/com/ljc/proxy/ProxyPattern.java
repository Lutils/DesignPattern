package com.ljc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LJC
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问
 * 使用场景：当不想直接访问某个对象或访问存在困难时，可以通过一个代理对象来间接访问，
 * 		      为了保证客户端使用的透明性，委托对向与代理对象需要实现相同的接口。
 */


/**
 * 被代理类
 */
class A implements ProxyInterface {
	@Override
	public void test() {
		System.out.println("被代理类");
	}
}

/**
 * 静态代理 
 * 代理者的代码由程序员自己或通过一些自动化工具生成的固定代码，再对其进行编译，
 * 即我们的代码在运行前代理类的class编译文件就已经存在。
 */

/**
 * 静态代理类
 */
class MyProxy implements ProxyInterface {
	
	private ProxyInterface m;
	//需实现相同的接口，注入被代理类
	public MyProxy(ProxyInterface m) {
		this.m = m;
	}
	@Override
	public void test() {
		System.out.println("静态代理=>前执行");
		m.test();	//代用被代理类方法
		System.out.println("静态代理=>后执行");
	}
	
}


/**
 * 动态代理
 * 通过反射机制动态的生成代理者的对象
 * jdk动态代理、cglib动态代理
 */

/**
 * 动态代理类
 */
class DynamicProxy implements InvocationHandler {

	private Object obj;
	public DynamicProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("动态代理=>前执行");
		//调用被代理类对象的方法
		Object result = method.invoke(obj, args);
		System.out.println("动态代理=>后执行");
		return result;
	}
	
}


public class ProxyPattern {

	public static void main(String[] args) {
		A a = new A();
		new MyProxy(a).test();	//静态代理
		System.out.println();
		//动态代理
		InvocationHandler invocationHandler = new DynamicProxy(a);
		ProxyInterface mProxy = (ProxyInterface) Proxy.newProxyInstance(
				a.getClass().getClassLoader(),
				a.getClass().getInterfaces(),
				invocationHandler);
		mProxy.test();
	}

}
