package com.ljc.responsibility;

/**
 * @author LJC
 * 责任链模式：使多个对象都有机会处理请求，从而避免了请求的发送者和和接收者之间的耦合关系
 * 			将这些对象连成一条链，并沿着这条链传递请求，直到有对象处理他为止
 * 		使用场景：
 * 			1. 多个对象可以处理同一个请求，但具体哪个对象则在处理中动态决定
 * 			2. 在请求处理者不明确的情况下向多个对象中的一个提交一个请求
 * 			3. 需要动态指定一组对象处理请求
 */


/**
 * 具体处理者1
 */
class ConcreteHandler1 extends Handler {

	@Override
	public void handleRequest(String condition) {
		if(condition.equals("ConcreteHandler1")) {
			System.out.println("ConcreteHandler1 Handled");
			return;
		}else{
			//交付下一结点的处理者
			successor.handleRequest(condition);
		}
	}
}
/**
 * 具体处理者2
 */
class ConcreteHandler2 extends Handler {

	@Override
	public void handleRequest(String condition) {
		if(condition.equals("ConcreteHandler2")) {
			System.out.println("ConcreteHandler2 Handled");
			return;
		}else{
			//交付下一结点的处理者
			successor.handleRequest(condition);
		}
	}
}


public class ChainofResponsibilityPattern {

	public static void main(String[] args) {
		ConcreteHandler1 handler1 = new ConcreteHandler1();
		ConcreteHandler2 handler2 = new ConcreteHandler2();
		//handler1的下一结点
		handler1.successor = handler2;
		//处理请求
		handler1.handleRequest("ConcreteHandler2");
	}

}
