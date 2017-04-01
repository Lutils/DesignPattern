package com.ljc.factory;

/**
 * 产品抽象类
 */
abstract class Product{
	public abstract void method();
}
/**
 * 工厂抽象类
 */
abstract class Factory{
	public abstract Product createProduct();
}
/**
 * 产品A
 */
class ProductA extends Product{
	@Override
	public void method() {
		System.out.println("产品A");
	}
}
/**
 * 产品B
 */
class ProductB extends Product{
	@Override
	public void method() {
		System.out.println("产品B");
	}
}

/**
 * 工厂方法
 * 通过不同的返回值生产A或B (A/B为继承自Product的类)
 */
class MyFactory extends Factory{

	@Override
	public Product createProduct() {
		return new ProductA();	//生产产品A
//		return new ProductB();  //生产产品B
	}
}

/**
 * 简单工厂
 * 使用场景:工厂只有一个的时候
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
