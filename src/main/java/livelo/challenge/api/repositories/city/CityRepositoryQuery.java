package livelo.challenge.api.repositories.city;

import java.util.List;

import livelo.challenge.api.entities.City;
import livelo.challenge.api.repositories.filters.CityFilter;

public interface CityRepositoryQuery {
	
	public List<City> findByNameOrCountry(CityFilter filter);

}
