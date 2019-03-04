//: guru.springframework.sfgpetclinic.services.springdatajpa.OwnerSDJpaServiceTest.java


package guru.springframework.sfgpetclinic.services.springdatajpa;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;


@Disabled(value = "Disabled until we learn Mocking!")
class OwnerSDJpaServiceTest {
	
	OwnerSDJpaService service;

	@BeforeEach
	void setUp() throws Exception {
		this.service = new OwnerSDJpaService(null, null, null);
	}

	@Disabled
	@Test
	void testFindByLastdName() {
		Owner foundOwner = this.service.findByLastName("Buck");
	}
	
	@Test
	void testFindAllByLastNameLike() {
		
	}

}///:~