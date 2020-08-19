package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.Customer;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {

		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);

		// return new ResponseEntity<>(customerService);

	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody Customer customerId) {
		Customer saveDto = customerService.saveNewUser(customerId);
		HttpHeaders header = new HttpHeaders();
		header.add("Location:", "/api/v1/customer" + saveDto.getId().toString());
		return new ResponseEntity(header, HttpStatus.CREATED);

	}

	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {
		customerService.updateUser(customerId, customer);
		// return new ResponseEntity(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteUser(customerId);

	}

}
