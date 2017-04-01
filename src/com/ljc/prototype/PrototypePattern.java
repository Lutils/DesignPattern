package com.ljc.prototype;

/**
 * ԭ��ģʽ 
 */

class Prototype implements Cloneable {
	public Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}

class ConcretePrototype extends Prototype {
	public void show() {
		System.out.println("ԭ��ģʽʵ����");
	}
}

public class PrototypePattern {
	public static void main(String[] args) {
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
			clonecp.show();
		}
	}
}