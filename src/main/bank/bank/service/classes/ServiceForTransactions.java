package bank.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.entities.Transactions;
import bank.repository.TransactionRepository;
import bank.service.interfaces.TransactionsService;

@Service
public class ServiceForTransactions implements TransactionsService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Transactions> getAll() {
		
		return transactionRepository.findAll();
	}

	@Override
	public void add(Transactions transaction) {
		
		transactionRepository.save(transaction);
	}

}
