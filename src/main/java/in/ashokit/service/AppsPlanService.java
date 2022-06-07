package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.AppsPlans;

public interface AppsPlanService  {
   
	//String save(AppsPlans plan);
	
	String upsert (AppsPlans plan);
	List<AppsPlans>  getallPlans();
	
	String deletePlan(int planId); 
	String deletePlanHardDlt(int planId);
	
}
