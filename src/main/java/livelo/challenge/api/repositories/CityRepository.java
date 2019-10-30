package livelo.challenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livelo.challenge.api.entities.City;
import livelo.challenge.api.repositories.city.CityRepositoryQuery;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, CityRepositoryQuery {


}
