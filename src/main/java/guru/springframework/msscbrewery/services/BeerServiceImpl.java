package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.log4j.Log4j2;

/**
 * Created by jt on 2019-04-20.
 */
@Service
@Log4j2
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDto saveNewUser(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("New Saved User").beerStyle("High Alcohol").build();
	}

	@Override
	public void updateUser(UUID uuid, BeerDto beerDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("deleting user", beerId.toString());

	}
}
