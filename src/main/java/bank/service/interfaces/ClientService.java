package bank.service.interfaces;

import java.util.List;

import bank.entities.Account;
import bank.entities.Client;

public interface ClientService {

	List<Client> getAll();

	void add(Client client);

	List<Account> getAccountByClient(int id);

	Client getClientById(int id);

	void addAccount(int id, Account account);

}
