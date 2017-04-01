package com.ljc.facade;

/**
 * @author LJC
 * 门面模式(外观模式)：要求一个子系统外部与其内部的通信必须通过一个统一的对象进行，
 * 				      门面模式提供一个高层次的接口，使子系统更加易用
 * 使用场景：1.为一个复杂子系统提供一个简单接口
 * 		   2.当需构建一个层次结构的子系统时
 */

class PhoneImpl implements Phone {

	@Override
	public void dail() {
		System.out.println("打电话");
	}

	@Override
	public void hangUp() {
		System.out.println("挂断");
	}
}

class MyCamera implements Camera {

	@Override
	public void open() {
		System.out.println("打开相机");
	}

	@Override
	public void takePicture() {
		System.out.println("拍照");
	}

	@Override
	public void close() {
		System.out.println("关闭相机");
	}
}
/**
 * 手机类
 */
class MobilePhone {
	
	private Phone phone = new PhoneImpl();
	private Camera camera = new MyCamera();
	
	public void videoChat() {
		System.out.println("视频聊天接入中。。。");
		//调用对应的方法
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
