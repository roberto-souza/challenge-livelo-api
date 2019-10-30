package livelo.challenge.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import livelo.challenge.api.entities.City;
import livelo.challenge.api.services.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public List<City> findByNameOrCountry(@RequestParam(name = "name", required = false) String name, 
			@RequestParam(name = "country", required = false) String country) {
		return this.cityService.findByNameOrCountry(name, country);
	}
	
	@PostMapping
	public ResponseEntity<City> create(@RequestBody City city) {
		City citySaved = this.cityService.create(city);
		return ResponseEntity.status(HttpStatus.CREATED).body(citySaved);
	}

}
