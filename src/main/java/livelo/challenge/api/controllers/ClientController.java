package livelo.challenge.api.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import livelo.challenge.api.dtos.ClientUpdateDTO;
import livelo.challenge.api.entities.Client;
import livelo.challenge.api.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> findByName(@RequestParam(name = "name", required = false) String name) {
		return this.clientService.findByName(name);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client client = this.clientService.findById(id);
		return Objects.isNull(client) ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
	}
	
	@PostMapping
	public ResponseEntity<Client> create(@RequestBody Client client) {
		Client clientSaved = this.clientService.create(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody ClientUpdateDTO clientDto) {
		Client clientSaved = this.clientService.updateName(id, clientDto);
		return ResponseEntity.ok(clientSaved);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> delete(@PathVariable Long id) {
		this.clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
