package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.AppsPlans;
import in.ashokit.service.AppsPlanServiceImpl;

@RestController
public class AppsPlansRestController {

	@Autowired
	private AppsPlanServiceImpl service;

	@PostMapping("/savePlan")
	public ResponseEntity<String> savePlans(@RequestBody AppsPlans plan) {
		String save = service.upsert(plan);
		return new ResponseEntity<>(save, HttpStatus.CREATED);

	}

	@GetMapping("/getplan")
	public ResponseEntity<List<AppsPlans>> getAllPlans() {
		List<AppsPlans> getallPlans = service.getallPlans();

		return new ResponseEntity<>(getallPlans, HttpStatus.OK);

	}

	@DeleteMapping("/deleteplan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		String deletePlan = service.deletePlan(planId);

		return new ResponseEntity<>(deletePlan, HttpStatus.OK);

	}

	@DeleteMapping("/harddeleteplan/{planId}")
	public ResponseEntity<String> harddeletePlan(@PathVariable Integer planId) {
		// String deletePlan = service.deletePlan(planId);
		String deletePlanHardDlt = service.deletePlanHardDlt(planId);
		return new ResponseEntity<>(deletePlanHardDlt, HttpStatus.OK);

	}

}
