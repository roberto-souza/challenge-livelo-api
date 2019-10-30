package livelo.challenge.api.repositories.city;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import livelo.challenge.api.entities.City;
import livelo.challenge.api.repositories.filters.CityFilter;

public class CityRepositoryImpl implements CityRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;	

	@Override
	public List<City> findByNameOrCountry(CityFilter filter) {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<City> criteria = builder.createQuery(City.class);
		Root<City> root = criteria.from(City.class);
	
		Predicate[] where = this.createWhere(filter, builder, root);
		criteria.where(where);
		
		TypedQuery<City> query = this.manager.createQuery(criteria);
		return query.getResultList();
	}
	

	private Predicate[] createWhere(CityFilter filter, CriteriaBuilder builder, Root<City> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (StringUtils.isNotBlank(filter.getName())) {
			predicates.add(builder.like(builder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));	
		}
		
		if (StringUtils.isNotBlank(filter.getCountry())) {
			predicates.add(builder.like(builder.lower(root.get("country")), "%" + filter.getCountry().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
