package com.ljc.builder;

/**
 * �����computer��
 */
class MacBook extends Computer {
	protected MacBook() {}
}

/**
 * ����Builder��
 */
class MacBookBuilder extends Builder {

	private Computer mac = new MacBook();
	@Override
	public Builder setBoard(String board) {
		mac.setBoard(board);
		return this;
	}

	@Override
	public Builder setDisplay(String display) {
		mac.setDisplay(display);
		return this;
	}

	@Override
	public Builder setOS(String os) {
		mac.setOs(os);
		return this;
	}

	@Override
	public Computer build() {
		return mac;
	}
	
}


public class BuilderPattern {
	public static void main(String[] args) {
		Computer mac = new MacBookBuilder()
				.setBoard("core")
				.setDisplay("retina")
				.setOS("mac os")
				.build();
		System.out.println(mac);
	}
}
