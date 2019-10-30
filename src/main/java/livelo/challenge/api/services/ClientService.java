package livelo.challenge.api.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import livelo.challenge.api.dtos.ClientUpdateDTO;
import livelo.challenge.api.entities.Client;
import livelo.challenge.api.exceptions.ApiException;
import livelo.challenge.api.repositories.ClientRepository;
import livelo.challenge.api.repositories.filters.ClientFilter;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client findById(Long id) {
		Optional<Client> client = this.clientRepository.findById(id);
		
		if (!client.isPresent()) {
			throw new ApiException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}
		
		return client.get();
		
	}
	
	public List<Client> findByName(String name) {
		ClientFilter filter = ClientFilter.builder().name(name).build();
		return this.clientRepository.filterByName(filter);
	}
	
	public Client create(Client client) {
		this.calculateAge(client);		
		return this.clientRepository.save(client);
	}
	
	public Client updateName(Long id, ClientUpdateDTO clientDto) {
		Client client = this.findById(id);
		client.setName(clientDto.getName());
		
		this.calculateAge(client);
		
		return this.clientRepository.save(client);
	}
	
	public void delete(Long id) {
		this.clientRepository.deleteById(id);
	}
	
	private void calculateAge(Client client) {
		if (!Objects.isNull(client.getBirthDay())) {			
			Integer age = Period.between(client.getBirthDay(), LocalDate.now()).getYears();
			
			if (client.getBirthDay().isAfter(LocalDate.now())) {
				age -= 1;
			}
			
			client.setAge(age);
		}
	}

}
