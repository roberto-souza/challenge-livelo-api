package livelo.challenge.api.repositories.client;

import java.util.List;

import livelo.challenge.api.entities.Client;
import livelo.challenge.api.repositories.filters.ClientFilter;

public interface ClientRepositoryQuery {
	
	public List<Client> filterByName(ClientFilter filter);

}
