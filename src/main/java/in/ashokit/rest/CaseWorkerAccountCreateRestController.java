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

import in.ashokit.entity.CaseWorkersAccount;
import in.ashokit.service.CaseWorkerAccountServiceImpl;

@RestController

public class CaseWorkerAccountCreateRestController {

	@Autowired
	private CaseWorkerAccountServiceImpl service;

	@PostMapping("/account")
	public ResponseEntity<String> createAcc(@RequestBody CaseWorkersAccount acc) {

		String createAccount = service.createAccountUpsert(acc);
		return new ResponseEntity<String>(createAccount, HttpStatus.CREATED);

	}

	@GetMapping("/getAcc")
	public ResponseEntity<List<CaseWorkersAccount>> getAcc() {

		List<CaseWorkersAccount> allAccounts = service.allAccounts();

		return new ResponseEntity<>(allAccounts, HttpStatus.OK);

	}

	@DeleteMapping("/deleteAcc/{accId}")
	public ResponseEntity<String> delelteAcc(@PathVariable Integer accId) {

		String deleteAcc = service.deleteAcc(accId);

		return new ResponseEntity<>(deleteAcc, HttpStatus.OK);

	}
	
	@DeleteMapping("/deleteAccPermanent/{accId}")
	public ResponseEntity<String> delelteAccPermanent(@PathVariable Integer accId) {

		//String deleteAcc = service.deleteAcc(accId);
		String permanentDeleteAcc = service.permanentDeleteAcc(accId);

		return new ResponseEntity<>(permanentDeleteAcc, HttpStatus.OK);

	}
	
	
}
