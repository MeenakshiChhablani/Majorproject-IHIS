package in.ashokit.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CaseWorkersAccount;

import in.ashokit.repository.CaseWorkersAccountRepo;
import in.ashokit.util.EmailUtils;

@Service
public class CaseWorkerAccountServiceImpl implements CaseWorkerAccountService {

	@Autowired
	private CaseWorkersAccountRepo repo;

	@Autowired
	private EmailUtils emailUtil;

	@Override
	public String createAccountUpsert(CaseWorkersAccount account) {

		// account.setActiveStatus("Y");
		// repo.save(account);

		account.setPwd(getRandomPassword());
		// BeanUtils.copyProperties(account, );
		CaseWorkersAccount save = repo.save(account);

//  *****email functionality *****

		String email = account.getEmailId();
		String subject = "CaseWorker Account Creation - Email";
		String fileName = "EmailSending.txt";
		String body = readMailBodyContent(fileName, account);
		boolean isSent = emailUtil.sendEmail(email, subject, body);

		// if(CaseWorkersAccount.getUserId()!=null && | isSent) {
		if (save.getAcc_id() != null && isSent) {

			return "SUCCESS";
		}

		return "FAIL";

	}

	@Override
	public List<CaseWorkersAccount> allAccounts() {
		List<CaseWorkersAccount> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public String deleteAcc(int accId) {
		Optional<CaseWorkersAccount> findById = repo.findById(accId);

		if (findById.isPresent()) {
			CaseWorkersAccount workersAccount = findById.get();
			workersAccount.setActiveStatus("N");
			repo.save(workersAccount);

		}
		return "Record Deleted suuccessfully";
	}

	@Override
	public String permanentDeleteAcc(int accId) {
		repo.deleteById(accId);
		return "Account deleted Permananetly";
	}

	private String getRandomPassword() {
		// public void getRandomPassword() {

		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		// System.out.println(generatedString);
		return generatedString;
	}

	// email functionality

	private String readMailBodyContent(String fileName, CaseWorkersAccount acc) {

		String mailBody = null;
		try {
			// sonar qube tells use stringbuilder bcos string builder is assync
			// StringBuffer sb=new StringBuffer();

			StringBuilder sb = new StringBuilder();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();

			}

			mailBody = sb.toString(); //
			mailBody = mailBody.replace("{FNAME}", acc.getFullName());

			mailBody = mailBody.replace("{TEMP-PWD}", acc.getPwd());
			mailBody = mailBody.replace("{EMAIL}", acc.getEmailId());
			// mailBody = mailBody.replace("{PWD}",acc.getPwd());
			br.close();

		} catch (Exception e) {
			e.printStackTrace(); // acc to sonarqube
			// logger.error(e.getMessage()); //acc to sonarqube change
		}

		/*
		 * finally {
		 * 
		 * fr.close();
		 * 
		 * }
		 */
		return null;

	}

}
