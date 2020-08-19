package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer getCustomer(UUID id) {
		// TODO Auto-generated method stub
		return Customer.builder().id(UUID.randomUUID()).name("ABCD").build();
	}

	@Override
	public Customer saveNewUser(Customer customerId) {
		return Customer.builder().id(UUID.randomUUID()).name("New Saved User").build();
	}

	@Override
	public void updateUser(UUID customerId, Customer beerDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(UUID customerId) {
		// TODO Auto-generated method stub

	}

}
