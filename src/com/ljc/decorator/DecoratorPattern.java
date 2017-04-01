package com.ljc.decorator;

/**
 * @author LJC
 * װ��ģʽ����̬�ĸ�һ���������һЩ�����ְ���Ǽ̳й�ϵ�������ʽ֮һ
 * ʹ�ó�������Ҫ��̬��͸������չ��Ĺ���ʱ
 */


/**
 * ����ʵ����
 */
class ConcreteComponent extends Component {
	@Override
	public void operate() {
		System.out.println("��װ�εķ���");
	}
}

/**
 * װ����ʵ����
 */
class ConcreteDecorator extends Decorator {

	public ConcreteDecorator(Component component) {
		super(component);
	}
	@Override
	public void operate() {
		System.out.println("װ�η���=>ǰ������");
		super.operate();
		System.out.println("װ�η���=>�󡣡���");
	}
}



public class DecoratorPattern {

	public static void main(String[] args) {
		//���챻װ�ε��������
		Component component = new ConcreteComponent();
		//װ��ģʽ
		Decorator decorator = new ConcreteDecorator(component);
		decorator.operate();
	}

}
