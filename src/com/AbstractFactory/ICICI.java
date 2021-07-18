package com.AbstractFactory;

public class ICICI implements Bank {

	private final String BNAME;
	
	public ICICI() {
		BNAME="ICICI Bank";
	}
	
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return BNAME;
	}

}
