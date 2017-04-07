package com.ljc.command;

/**
 * @author LJC
 * ����ģʽ����һ�������װ��һ�����󣬴Ӷ����û�ʹ�ò�ͬ������ѿͻ��˲�����
 * 		      �������Ŷӻ��߼�¼������־���Լ�֧�ֿɳ����Ĳ���
 * 		ʹ�ó�����
 * 			1. ��Ҫ�������ִ�еĲ�����Ȼ���Բ�������ʽ�ṩ����
 * 			2. �ڲ�ͬ��ʱ��ָ���������ִ������
 * 			3. ��Ҫִ��ȡ��������֧���޸���־���ܡ���Ҫ֧���������
 */


/**
 * ��������
 */
class Receiver {
	//����ִ�о����߼�����ķ���
	public void action() {
		System.out.println("ִ�о������");
	}
}

/**
* ����������
*/
class ConcreteCommand implements Command {
	//����һ���Խ����߶��������
	private Receiver receiver;
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		//���ý�������ط�����ִ�о����߼�
		receiver.action();
	}
	
}
/**
* ��������
*/
class Invoker {
	//����һ����������������
	private Command command;
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void action() {
		//���þ�������������ط�����ִ�о���ָ��
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
