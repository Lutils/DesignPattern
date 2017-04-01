package com.ljc.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ģʽ
 */
class Singleton1 {

	// ���캯��˽�л�
	private Singleton1() {}
	// ���о�̬��������¶��ȡ��������ӿ�
	private static Singleton1 instance = new Singleton1();

	public static Singleton1 getInstance() {
		return instance;
	}
}

/**
 * ����ģʽ
 * �ŵ�:����ֻ����ʹ��ʱ�Żᱻʵ����
 * ȱ��:��һ�μ���ʱ��Ӧ����;ÿ�ε���getInstance������ͬ��,��ɲ���Ҫ��ͬ������
 */
class Singleton2 {

	private static Singleton2 instance;
	// ���캯��˽�л�
	private Singleton2() {}
	//�����synchronized�ؼ���,��֤���̵߳�������Ψһ
	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

/**
 * Double Check Lock(DCL)ģʽ
 * �ŵ�:���������ģʽ�Ĵ󲿷�ȱ�㡢��Դ�����ʸ�
 * ȱ��:��һ�μ���ʱ��Ӧ����
 */
class Singleton3 {

	private volatile static Singleton3 instance = null;
	// ���캯��˽�л�
	private Singleton3() {}
	public static Singleton3 getInstance() {
		//��һ���п�:���ⲻ��Ҫ��ͬ��
		if (instance == null) {
			synchronized (Singleton3.class) {
				//�ڶ����п�:����ʵ��
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}

/**
 * ��̬�ڲ���ģʽ
 * �ŵ�:ȷ���̰߳�ȫ����֤�������ӳ��˵�����ʵ����
 */
class Singleton4 {

	// ���캯��˽�л�
	private Singleton4() {}
	public static Singleton4 getInstance() {
		return SingletonHolder.instance;
	}
	// ��̬�ڲ���
	private static class SingletonHolder{
		private static final Singleton4 instance = new Singleton4();
	}
}

/* 
          ���ϵ��������ڷ����л������������·���

	private Object readResolve() throws ObjectStreamException {
		//�����л�ֱ�ӷ��ض���,�����������¶���
		return instance;
	}
	
	��Ϊ���л����Խ�һ��������ʵ������д�����,Ȼ���ٶ�����,�Ӷ���Ч�Ļ�ȡһ��ʵ��,
	��ʹ���캯��˽��,�����л����ɿ���ͨ������;������µ�ʵ��

 */

/**
 * ö�ٵ���
 * �̰߳�ȫ�ҵ���,�����л����Ҳ���������µ�ʵ��
 */
/*
	public enum Singleton {
		INSTANCE;
	}
*/

/**
 * ʹ������ʵ�ֵ���ģʽ
 * �ŵ�:�ɹ���������͵ĵ���,����ʹ��ʱ��ʹ��ͳһ�Ľӿڽ��в���
 */

class Singleton5 {
	private static Map<String,Object> map = new HashMap<String,Object>();
	// ���캯��˽�л�
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


