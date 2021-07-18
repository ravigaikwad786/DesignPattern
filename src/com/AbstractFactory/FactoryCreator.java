package com.AbstractFactory;

public class FactoryCreator {
	
	public static AbstractFactory getFactory(String choice) {
		
		if(choice.equalsIgnoreCase("BANK")) {
			return new BankFactory();
		}
		if(choice.equalsIgnoreCase("LOAN")) {
			return new LoanFactory();
					
		}
		
		
		return null;
		
	}

}
