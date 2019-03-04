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
				/*
				 * Within a CODE BLOCK, if an assertion fails, 
				 * the subsequent code in the same block will be skipped 
				 */
				() -> {
					assertEquals("Joe", owner.getFirstName(), 
							() -> "First Name Failed!");
					/*
					 * Executed only if the previous first name assertion is 
					 * valid.
					 */
					assertEquals("Buck", owner.getLastName(), 
							() -> "Last Name Failed!"); 

				}, 
				/*
				 * Within a CODE BLOCK, if an assertion fails, 
				 * the subsequent code in the same block will be skipped 
				 */
				() -> {
					assertEquals("Key West", owner.getCity(), 
								() -> "City Failed!");
					/*
					 * Executed only if the previous city assertion is 
					 * valid.
					 */
					assertEquals("(123)456-7890", owner.getTelephone(), 
								() -> "Telephone Failed!");
				});
	}

}///:~