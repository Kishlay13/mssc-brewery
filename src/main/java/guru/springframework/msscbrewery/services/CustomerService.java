package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.Customer;

public interface CustomerService {

	Customer getCustomer(UUID id);

	Customer saveNewUser(Customer customerId);

	void updateUser(UUID customerId, Customer beerDto);

	void deleteUser(UUID customerId);
}
