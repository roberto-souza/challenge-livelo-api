package livelo.challenge.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livelo.challenge.api.entities.City;
import livelo.challenge.api.repositories.CityRepository;
import livelo.challenge.api.repositories.filters.CityFilter;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public City create(City city) {
		return this.cityRepository.save(city);
	}
	
	public List<City> findByNameOrCountry(String name, String country) {
		CityFilter filter = CityFilter.builder().name(name).country(country).build();
		return this.cityRepository.findByNameOrCountry(filter);
	}	

}
