package com.ljc.facade;

/**
 * @author LJC
 * ����ģʽ(���ģʽ)��Ҫ��һ����ϵͳ�ⲿ�����ڲ���ͨ�ű���ͨ��һ��ͳһ�Ķ�����У�
 * 				      ����ģʽ�ṩһ���߲�εĽӿڣ�ʹ��ϵͳ��������
 * ʹ�ó�����1.Ϊһ��������ϵͳ�ṩһ���򵥽ӿ�
 * 		   2.���蹹��һ����νṹ����ϵͳʱ
 */

class PhoneImpl implements Phone {

	@Override
	public void dail() {
		System.out.println("��绰");
	}

	@Override
	public void hangUp() {
		System.out.println("�Ҷ�");
	}
}

class MyCamera implements Camera {

	@Override
	public void open() {
		System.out.println("�����");
	}

	@Override
	public void takePicture() {
		System.out.println("����");
	}

	@Override
	public void close() {
		System.out.println("�ر����");
	}
}
/**
 * �ֻ���
 */
class MobilePhone {
	
	private Phone phone = new PhoneImpl();
	private Camera camera = new MyCamera();
	
	public void videoChat() {
		System.out.println("��Ƶ��������С�����");
		//���ö�Ӧ�ķ���
		camera.open();
		phone.dail();
	}
	
}
public class FacadePattern {

	public static void main(String[] args) {
		MobilePhone phone = new MobilePhone();
		phone.videoChat();
	}

}
