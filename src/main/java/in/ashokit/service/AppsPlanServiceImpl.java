package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.AppsPlans;
import in.ashokit.repository.AppsPlansRepo;

@Service
public class AppsPlanServiceImpl implements AppsPlanService {

	@Autowired
	private AppsPlansRepo repo;

	/*
	 * @Override public String save(AppsPlans plan) { AppsPlans save =
	 * repo.save(plan); return "Record saved suucessfully"; }
	 */

	@Override
	public String upsert(AppsPlans plan) {
		plan.setActive_Status("Y");
		repo.save(plan);
		return "SUCCESS";
	}

	@Override
	public List<AppsPlans> getallPlans() {
		List<AppsPlans> allPlans = repo.findAll();
		return allPlans;
	}

	// This method is for hard deletd

	@Override
	public String deletePlanHardDlt(int planId) {

		repo.deleteById(planId);
		return "record deleeted ";
	}

	// this method is for soft delete
	@Override
	public String deletePlan(int planId) {
		Optional<AppsPlans> findById = repo.findById(planId);

		if (findById.isPresent()) {
			AppsPlans plan = findById.get();
			plan.setActive_Status("N");
			repo.save(plan);
		}
		return "record deleted ";
	}

}
