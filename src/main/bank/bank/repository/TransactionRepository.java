package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.entities.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
