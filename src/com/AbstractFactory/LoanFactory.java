package com.AbstractFactory;

public class LoanFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		// TODO Auto-generated method stub
		if(loan==null) {
			return null;
					
		}
		if(loan.equalsIgnoreCase("HOME")) {
			return new HomeLoan();
			
		}
		if(loan.equalsIgnoreCase("BUSSINESSLOAN")) {
			return new BussinesLoan();
		}
		if(loan.equalsIgnoreCase("EDUCATIONALLOAN")) {
			return new EducationalLoan();
		}
				
		
		return null;
	}

	
	
}
