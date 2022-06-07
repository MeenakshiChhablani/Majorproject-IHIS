package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.CaseWorkersAccount;

public interface CaseWorkerAccountService {

	String createAccountUpsert(CaseWorkersAccount account);
	List<CaseWorkersAccount> allAccounts();
	String deleteAcc(int accId);
	String permanentDeleteAcc(int accId);
}

