package com.ljc.factory;

/**
 * 抽象产品A
 */
abstract class AbstractProudctA {
	public abstract void method();
}

/**
 * 抽象产品B
 */
abstract class AbstractProudctB {
	public abstract void method();
}

/**
 * 具体产品A1
 */
class ProductA1 extends AbstractProudctA {
	@Override
	public void method() {
		System.out.println("具体产品A1");
	}
}

/**
 * 具体产品A2
 */
class ProductA2 extends AbstractProudctA {
	@Override
	public void method() {
		System.out.println("具体产品A2");
	}
}

/**
 * 具体产品B1
 */
class ProductB1 extends AbstractProudctB {
	@Override
	public void method() {
		System.out.println("具体产品B1");
	}
}

/**
 * 具体产品B2
 */
class ProductB2 extends AbstractProudctB {
	@Override
	public void method() {
		System.out.println("具体产品B2");
	}
}

/**
 * 抽象工厂
 */
abstract class AbstractFactroy {
	//创建产品A
	public abstract AbstractProudctA createProductA();
	//创建产品B
	public abstract AbstractProudctB createProductB();
}

/**
 * 生产产品1
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
 * 生产产品2
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
