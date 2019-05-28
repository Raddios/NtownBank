package bank.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.entities.Account;
import bank.entities.Transactions;
import bank.repository.AccountRepository;
import bank.service.interfaces.AccountService;
import bank.service.interfaces.TransactionsService;

@Service
public class ServiceForAccount implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionsService transactionsService;
	

	@Override
	public void add(Account account) {
		
		accountRepository.save(account);
		
		
	}


	@Override
	public Account getAccountById(int id) {
	
		return accountRepository.findById(id);
	}


	@Override
	public void exchange(Transactions transaction) {
		Account senderAccount = accountRepository.findById(transaction.getSenderId());
		Account recipientAccount = accountRepository.findById(transaction.getRecipientId());
		senderAccount.setBalance(senderAccount.getBalance() - transaction.getSummOfTransaction());
		recipientAccount.setBalance(recipientAccount.getBalance() + transaction.getSummOfTransaction());
		accountRepository.save(senderAccount);
		accountRepository.save(recipientAccount);
	}


	@Override
	public void increaseBalance(int balance, int id) {
		Account account = accountRepository.findById(id);
		int old_balance = account.getBalance();
		account.setBalance(old_balance + balance);
		Transactions transaction = new Transactions();
		transaction.setSenderId(id);
		transaction.setRecipientId(0);
		transaction.setSummOfTransaction(balance);
		transactionsService.add(transaction);
		accountRepository.save(account);
		
	}


	@Override
	public void decreaseBalance(int balance, int id) {
		Account account = accountRepository.findById(id);
		int old_balance = account.getBalance();
		account.setBalance(old_balance - balance);
		Transactions transaction = new Transactions();
		transaction.setSenderId(id);
		transaction.setRecipientId(0);
		transaction.setSummOfTransaction(balance);
		accountRepository.save(account);
		
	}

}
