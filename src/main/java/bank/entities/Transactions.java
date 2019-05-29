package bank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transactions")
public class Transactions implements Serializable{
	
	
	private static final long serialVersionUID = 121396714532782638L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Transaction_Id")
	private int id;
	
	@Column(name = "sender_account_ID")
	private int senderAccountID;
	
	@Column(name = "recipient_account_ID")
	private int recipientAccountId;
	
	@Column(name = "sender_ID")
	private int senderId;
	
	@Column(name = "recipient_ID")
	private int recipientId;
	
	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	@Column(name = "Summ")
	private int summOfTransaction;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateOfTransaction;
	
	public Transactions() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderAccountID() {
		return senderAccountID;
	}

	public void setSenderAccountID(int senderAccountID) {
		this.senderAccountID = senderAccountID;
	}

	public int getRecipientAccountId() {
		return recipientAccountId;
	}

	public void setRecipientAccountId(int recipientAccountId) {
		this.recipientAccountId = recipientAccountId;
	}

	public int getSummOfTransaction() {
		return summOfTransaction;
	}

	public void setSummOfTransaction(int summOfTransaction) {
		this.summOfTransaction = summOfTransaction;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	
	@PrePersist
	public void setDateOfTransaction() {
		dateOfTransaction = new Date();
	};
	
	
}
