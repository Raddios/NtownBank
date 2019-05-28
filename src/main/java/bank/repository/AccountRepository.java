package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findById(int id);

}
