package com.ljc.factory;

/**
 * �����ƷA
 */
abstract class AbstractProudctA {
	public abstract void method();
}

/**
 * �����ƷB
 */
abstract class AbstractProudctB {
	public abstract void method();
}

/**
 * �����ƷA1
 */
class ProductA1 extends AbstractProudctA {
	@Override
	public void method() {
		System.out.println("�����ƷA1");
	}
}

/**
 * �����ƷA2
 */
class ProductA2 extends AbstractProudctA {
	@Override
	public void method() {
		System.out.println("�����ƷA2");
	}
}

/**
 * �����ƷB1
 */
class ProductB1 extends AbstractProudctB {
	@Override
	public void method() {
		System.out.println("�����ƷB1");
	}
}

/**
 * �����ƷB2
 */
class ProductB2 extends AbstractProudctB {
	@Override
	public void method() {
		System.out.println("�����ƷB2");
	}
}

/**
 * ���󹤳�
 */
abstract class AbstractFactroy {
	//������ƷA
	public abstract AbstractProudctA createProductA();
	//������ƷB
	public abstract AbstractProudctB createProductB();
}

/**
 * ������Ʒ1
 */
class MyFactory1 extends AbstractFactroy {

	@Override
	public AbstractProudctA createProductA() {
		return new ProductA1();
	}

	@Override
	public AbstractProudctB createProductB() {
		return new ProductB1();
	}
	
}

/**
 * ������Ʒ2
 */
class MyFactory2 extends AbstractFactroy {

	@Override
	public AbstractProudctA createProductA() {
		return new ProductA2();
	}

	@Override
	public AbstractProudctB createProductB() {
		return new ProductB2();
	}
	
}


public class AbstractFactoryPattern {
	public static void main(String[] args) {
		new MyFactory1().createProductA().method();
		new MyFactory1().createProductB().method();
		new MyFactory2().createProductA().method();
		new MyFactory2().createProductB().method();
	}
}
