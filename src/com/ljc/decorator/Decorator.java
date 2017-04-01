package com.ljc.decorator;
/**
 * 抽象装饰类
 */
public abstract class Decorator extends Component {
	
	private Component component; //必须
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void operate() {
		component.operate();
	}
}