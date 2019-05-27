package bank.service.interfaces;

import java.util.List;

import bank.entities.Transactions;

public interface TransactionsService {

	List<Transactions> getAll();

	void add(Transactions transaction);

}
