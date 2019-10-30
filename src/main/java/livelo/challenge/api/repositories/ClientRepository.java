package livelo.challenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livelo.challenge.api.entities.Client;
import livelo.challenge.api.repositories.client.ClientRepositoryQuery;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryQuery {

}
