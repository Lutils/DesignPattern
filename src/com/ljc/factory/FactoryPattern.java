package com.ljc.factory;

/**
 * ��Ʒ������
 */
abstract class Product{
	public abstract void method();
}
/**
 * ����������
 */
abstract class Factory{
	public abstract Product createProduct();
}
/**
 * ��ƷA
 */
class ProductA extends Product{
	@Override
	public void method() {
		System.out.println("��ƷA");
	}
}
/**
 * ��ƷB
 */
class ProductB extends Product{
	@Override
	public void method() {
		System.out.println("��ƷB");
	}
}

/**
 * ��������
 * ͨ����ͬ�ķ���ֵ����A��B (A/BΪ�̳���Product����)
 */
class MyFactory extends Factory{

	@Override
	public Product createProduct() {
		return new ProductA();	//������ƷA
//		return new ProductB();  //������ƷB
	}
}

/**
 * �򵥹���
 * ʹ�ó���:����ֻ��һ����ʱ��
 */
class SimpleFactory{
	public static Product createProduct() {
		return new ProductB();
	}
}



public class FactoryPattern {
	public static void main(String[] args) {
		new MyFactory().createProduct().method();
		SimpleFactory.createProduct().method();
	}
}
