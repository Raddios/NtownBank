package bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bank.entities.Account;
import bank.entities.Client;
import bank.entities.Transactions;
import bank.service.interfaces.AccountService;
import bank.service.interfaces.ClientService;
import bank.service.interfaces.TransactionsService;

@Controller
@RequestMapping("/")
public class ClientController {

	private ClientService clientService;
	private AccountService accountService;
	TransactionsService transactionsService;

	@Autowired
	public ClientController(ClientService clientService, AccountService accountService,
			TransactionsService transactionsService) {
		this.clientService = clientService;
		this.accountService = accountService;
		this.transactionsService = transactionsService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:index";

	};
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String clients(Model model) {
		List<Client> clients = clientService.getAll();
		model.addAttribute("clients", clients);
		return "index";
	}

	@RequestMapping(value = "/newclient", method = RequestMethod.GET)
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "newclient";

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client) {
		clientService.add(client);
		return "redirect:index";

	};

	@RequestMapping(value = "{id}/accountlist", method = RequestMethod.GET)
	public String getClientAccounts(@PathVariable("id") int id, Model model) {
		List<Account> accounts = clientService.getAccountByClient(id);
		model.addAttribute("accounts", accounts);
		return "accountlist";
	}

	@RequestMapping(value = "{id}/newaccount", method = RequestMethod.GET)
	public String addAccount(Model model) {
		model.addAttribute("account", new Account());
		return "newaccount";
	}

	@RequestMapping(value = "{id}/accountlist", method = RequestMethod.POST)
	public String addAccount(@ModelAttribute("account") Account account, @PathVariable("id") int id) {
		account.setClientId(clientService.getClientById(id));
		
		accountService.add(account);
		
		return "redirect:accountlist";
	}
	
	@RequestMapping(value = "{id}/accountincrease", method = RequestMethod.GET)
	public String increaseAccount(Model model) {
		model.addAttribute("account", new Account());
		return "accountincrease";
	}
	
	@RequestMapping(value = "{id}/accountincrease", method = RequestMethod.POST)
	public String increaseAccount(@RequestParam("balance") int balance , @PathVariable("id") int id) {
		
		accountService.increaseBalance(balance, id);
		
		return "redirect:accountlist";
	}
	@RequestMapping(value = "{id}/accountdecrease", method = RequestMethod.GET)
	public String decreaseAccount(Model model) {
		model.addAttribute("account", new Account());
		return "accountdecrease";
	}
	
	@RequestMapping(value = "{id}/accountdecrease", method = RequestMethod.POST)
	public String decreaseAccount(@RequestParam("balance") int balance , @PathVariable("id") int id) {
		
		accountService.decreaseBalance(balance, id);
		
		return "redirect:accountlist";
	}

	@RequestMapping(value = "transactions", method = RequestMethod.GET)
	public String transactions(Model model) {
		List<Transactions> transactions = transactionsService.getAll();
		model.addAttribute("transactions", transactions);
		return "transactions";
	}

	@RequestMapping(value = "/newtransaction", method = RequestMethod.GET)
	public String addTransaction(Model model) {
		model.addAttribute("transaction", new Transactions());
		return "newtransaction";
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.POST)
	public String addTransaction(@ModelAttribute("transaction") Transactions transaction) {
		accountService.exchange(transaction);
		transactionsService.add(transaction);
		return "redirect:transactions";
	}
}
