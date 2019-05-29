package bank.service.interfaces;

import bank.entities.Account;
import bank.entities.Transactions;

public interface AccountService {

	void add(Account account);

	Account getAccountById(int id);

	void exchange(Transactions transaction);

	void increaseBalance(int balance, int id);

	void decreaseBalance(int balance, int id);

	void addAccounToClient(int balance, int id);

}
