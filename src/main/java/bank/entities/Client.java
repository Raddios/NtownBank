package bank.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 9202075532063725943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Client_Id")
	private int id;

	@Column(name = "Client_Name")
	private String name;

	@Column(name = "Client_Adress")
	private String adress;

	@Column(name = "Client_Age")
	private int age;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
	private List<Account> account;

	public Client() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Account> getAccountList() {
		return account;
	}

	public void setAccountList(List<Account> account) {
		this.account = account;
	}

}
