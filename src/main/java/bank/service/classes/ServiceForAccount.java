package bank.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.entities.Account;
import bank.entities.Client;
import bank.entities.Transactions;
import bank.repository.AccountRepository;
import bank.service.interfaces.AccountService;
import bank.service.interfaces.ClientService;
import bank.service.interfaces.TransactionsService;

@Service
public class ServiceForAccount implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionsService transactionsService;
	@Autowired
	private ClientService clientService;

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
		Account senderAccount = accountRepository.findById(transaction.getSenderAccountID());
		Account recipientAccount = accountRepository.findById(transaction.getRecipientAccountId());
		senderAccount.setBalance(senderAccount.getBalance() - transaction.getSummOfTransaction());
		recipientAccount.setBalance(recipientAccount.getBalance() + transaction.getSummOfTransaction());
		transaction.setSenderId(senderAccount.getClientId().getId());
		transaction.setRecipientId(recipientAccount.getClientId().getId());
		transactionsService.add(transaction);
		accountRepository.save(senderAccount);
		accountRepository.save(recipientAccount);
	}

	@Override
	public void increaseBalance(int balance, int id) {
		Account account = accountRepository.findById(id);
		int old_balance = account.getBalance();
		account.setBalance(old_balance + balance);
		Transactions transaction = new Transactions();
		transaction.setSenderAccountID(id);
		transaction.setSenderId(account.getClientId().getId());
		transaction.setRecipientAccountId(0);
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
		transaction.setSenderAccountID(id);
		transaction.setSenderId(account.getClientId().getId());
		transaction.setRecipientAccountId(0);
		transaction.setRecipientId(0);
		transaction.setSummOfTransaction(balance);
		accountRepository.save(account);

	}

	@Override
	public void addAccounToClient(int balance, int id) {

		Client client = clientService.getClientById(id);
		Account account = new Account();
		account.setBalance(balance);
		account.setClientId(client);
		accountRepository.save(account);
		client.getAccountList().add(account);
		clientService.add(client);

	}

}
