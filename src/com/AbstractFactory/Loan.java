package com.AbstractFactory;

abstract class Loan {
	
	protected double rate;
	
	abstract void getInterestRate(double rate);
	
	public void calculateLoanAmount(double loanamount,int years) {
		
		
		double EMI;
		int n;
		
		n=years*10;
		rate=rate/1200;
		
		EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;  
		
		System.out.println("Your Monthly EMI is"+EMI+"For the AMount"+loanamount+"You Have Borrowed");
	}
	
}
