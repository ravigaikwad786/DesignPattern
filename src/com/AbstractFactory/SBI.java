package com.AbstractFactory;

public class SBI implements Bank{

	private final String BNAME;
	
	public SBI() {
		BNAME="SBI Bank";
	}
	
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return BNAME;
	}

}
