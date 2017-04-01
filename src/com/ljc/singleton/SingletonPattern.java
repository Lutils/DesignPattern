package com.ljc.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 饿汉模式
 */
class Singleton1 {

	// 构造函数私有化
	private Singleton1() {}
	// 共有静态方法、暴露获取单例对象接口
	private static Singleton1 instance = new Singleton1();

	public static Singleton1 getInstance() {
		return instance;
	}
}

/**
 * 懒汉模式
 * 优点:单例只有在使用时才会被实例化
 * 缺点:第一次加载时反应稍慢;每次调用getInstance都进行同步,造成不必要的同步开销
 */
class Singleton2 {

	private static Singleton2 instance;
	// 构造函数私有化
	private Singleton2() {}
	//添加了synchronized关键字,保证多线程单例对象唯一
	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

/**
 * Double Check Lock(DCL)模式
 * 优点:解决了懒汉模式的大部分缺点、资源利用率高
 * 缺点:第一次加载时反应稍慢
 */
class Singleton3 {

	private volatile static Singleton3 instance = null;
	// 构造函数私有化
	private Singleton3() {}
	public static Singleton3 getInstance() {
		//第一次判空:避免不必要的同步
		if (instance == null) {
			synchronized (Singleton3.class) {
				//第二次判空:创建实例
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}

/**
 * 静态内部类模式
 * 优点:确保线程安全、保证单例、延迟了单例的实例化
 */
class Singleton4 {

	// 构造函数私有化
	private Singleton4() {}
	public static Singleton4 getInstance() {
		return SingletonHolder.instance;
	}
	// 静态内部类
	private static class SingletonHolder{
		private static final Singleton4 instance = new Singleton4();
	}
}

/* 
          以上单例方法在反序列化情况需加入以下方法

	private Object readResolve() throws ObjectStreamException {
		//反序列化直接返回对象,而不是生成新对象
		return instance;
	}
	
	因为序列化可以将一个单例的实例对象写入磁盘,然后再读出来,从而有效的获取一个实例,
	即使构造函数私有,反序列化依旧可以通过特殊途径获得新的实例

 */

/**
 * 枚举单例
 * 线程安全且单例,反序列化情况也不会生成新的实例
 */
/*
	public enum Singleton {
		INSTANCE;
	}
*/

/**
 * 使用容器实现单例模式
 * 优点:可管理多种类型的单例,并在使用时可使用统一的接口进行操作
 */

class Singleton5 {
	private static Map<String,Object> map = new HashMap<String,Object>();
	// 构造函数私有化
	private Singleton5() {}
	public static void registerInstance(String key, Object instance){
		if(!map.containsKey(key)){
			map.put(key, instance);
		}
	}
	public static Object getInstance(String key){
		return map.get(key);
	}
}


public class SingletonPattern {

	public static void main(String[] args) {
		System.out.println(Singleton4.getInstance().hashCode());
		System.out.println(Singleton4.getInstance().hashCode());
	}
}


