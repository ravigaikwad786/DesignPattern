package com.FactoryMethod;

abstract class Plan {

	protected double rate;
	
	abstract void getRate();

	public void CalculateBill(int units) {
		System.out.println(units*rate);
	}
}
