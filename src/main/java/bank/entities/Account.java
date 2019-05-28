package bank.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	
	
	private static final long serialVersionUID = 2288610915256447075L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Account_Id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "Client_Id")
	private Client client;;
	
	@Column(name = "balance")
	private int balance;
	
	public Account() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client client) {
		this.client = client;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	};
	
	
}
