package livelo.challenge.api.repositories.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import livelo.challenge.api.entities.Client;
import livelo.challenge.api.repositories.filters.ClientFilter;

public class ClientRepositoryImpl implements ClientRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Client> filterByName(ClientFilter filter) {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
		Root<Client> root = criteria.from(Client.class);
		
		if (StringUtils.isNotBlank(filter.getName())) {
			criteria.where(builder.like(builder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));			
		}
		
		TypedQuery<Client> query = this.manager.createQuery(criteria);
		return query.getResultList();
	}

}
