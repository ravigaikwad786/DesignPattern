package com.FactoryMethod;

public class GetPlanFactory {

		public Plan getPlan(String planType) {
			if(planType==null) {
				return null;
			}
			if(planType.equalsIgnoreCase("DOMESTICPLAN")){
				return new DomesticPlan();
						
			}
			if(planType.equalsIgnoreCase("COMMERTIALPLAN")) {
				return new CommercialPlan();
			}
			if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
				return new InstitutionPlan();
			}
			return null;
			
		}
		
		
		
		
}
