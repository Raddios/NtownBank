package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findById(int id);

}
