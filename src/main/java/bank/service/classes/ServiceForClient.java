package bank.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.entities.Account;
import bank.entities.Client;
import bank.repository.ClientRepository;
import bank.service.interfaces.ClientService;

@Service
public class ServiceForClient implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll() {
		
		return clientRepository.findAll();
	}

	@Override
	public void add(Client client) {
		clientRepository.save(client);
		
	}

	@Override
	public List<Account> getAccountByClient(int id) {
		Client client = clientRepository.findById(id);
		List<Account> accounts = client.getAccountList();
		return accounts;
	}

	@Override
	public Client getClientById(int id) {
		
		return clientRepository.findById(id);
	}

	@Override
	public void addAccount(int id, Account account) {
		Client client = clientRepository.findById(id);
		client.getAccountList().add(account);
		
	}

}
