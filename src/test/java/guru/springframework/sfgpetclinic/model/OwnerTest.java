//: guru.springframework.sfgpetclinic.model.OwnerTest.java


package guru.springframework.sfgpetclinic.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OwnerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void dependentAssertions() {
		Owner owner = new Owner(1L, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("(123)456-7890");
		
		// Then
		assertAll("Properties Test", 
				() -> {
					assertEquals("Joe", owner.getFirstName(), 
							() -> "First Name Failed!");
					assertEquals("Buck", owner.getLastName(), 
							() -> "Last Name Failed!"); 

				}, 
				() -> {
					assertEquals("Key West", owner.getCity(), 
								() -> "City Failed!");
					assertEquals("(123)456-7890", owner.getTelephone(), 
								() -> "Telephone Failed!");
				});
	}

}///:~