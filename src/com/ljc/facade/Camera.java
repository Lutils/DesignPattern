package com.ljc.facade;
/**
 * 相机接口
 */
public interface Camera {
	//打开
	void open();
	//拍照
	void takePicture();
	//关闭
	void close();
}