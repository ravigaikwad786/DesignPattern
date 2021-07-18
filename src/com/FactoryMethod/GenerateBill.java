package com.FactoryMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.attribute.IntegerSyntax;

public class GenerateBill {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		GetPlanFactory planFactory = new GetPlanFactory();
		System.out.println("Enter Name of plan Which bill will be generated");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String planName= br.readLine();
		
		System.out.println("Enter th Consumption Of unit");
		int units=Integer.parseInt(br.readLine());
		
		Plan p=planFactory.getPlan(planName);
		
		System.out.println("Bill amount for "+planName+" of  "+units+" units is: ");
		p.getRate();
		p.CalculateBill(units);
	}

}
