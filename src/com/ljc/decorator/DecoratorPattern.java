package com.ljc.decorator;

/**
 * @author LJC
 * 装饰模式：动态的给一个对象添加一些额外的职责，是继承关系的替代方式之一
 * 使用场景：需要动态且透明的扩展类的功能时
 */


/**
 * 具体实现类
 */
class ConcreteComponent extends Component {
	@Override
	public void operate() {
		System.out.println("被装饰的方法");
	}
}

/**
 * 装饰者实现类
 */
class ConcreteDecorator extends Decorator {

	public ConcreteDecorator(Component component) {
		super(component);
	}
	@Override
	public void operate() {
		System.out.println("装饰方法=>前。。。");
		super.operate();
		System.out.println("装饰方法=>后。。。");
	}
}



public class DecoratorPattern {

	public static void main(String[] args) {
		//构造被装饰的组件对象
		Component component = new ConcreteComponent();
		//装饰模式
		Decorator decorator = new ConcreteDecorator(component);
		decorator.operate();
	}

}
