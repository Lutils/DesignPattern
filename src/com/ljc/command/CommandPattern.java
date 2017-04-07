package com.ljc.command;

/**
 * @author LJC
 * 命令模式：将一个请求封装成一个对象，从而让用户使用不同的请求把客户端参数化
 * 		      对请求排队或者记录请求日志，以及支持可撤销的操作
 * 		使用场景：
 * 			1. 需要抽象出待执行的操作，然后以参数的形式提供出来
 * 			2. 在不同的时刻指定、排序和执行请求
 * 			3. 需要执行取消操作、支持修改日志功能、需要支持事务操作
 */


/**
 * 接收者类
 */
class Receiver {
	//真正执行具体逻辑命令的方法
	public void action() {
		System.out.println("执行具体操作");
	}
}

/**
* 具体命令类
*/
class ConcreteCommand implements Command {
	//持有一个对接收者对象的引用
	private Receiver receiver;
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		//调用接收者相关方法来执行具体逻辑
		receiver.action();
	}
	
}
/**
* 请求者类
*/
class Invoker {
	//持有一个对命令对象的引用
	private Command command;
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void action() {
		//调用具体命令对象的相关方法，执行具体指令
		command.execute();
	}
}

public class CommandPattern {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.action();
	}

}
