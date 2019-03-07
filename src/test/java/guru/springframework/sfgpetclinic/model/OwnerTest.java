//: guru.springframework.sfgpetclinic.model.OwnerTest.java


package guru.springframework.sfgpetclinic.model;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import guru.springframework.sfgpetclinic.ModelTest;


class OwnerTest implements ModelTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@DisplayName("Verify JUnit5 Dependent Assertions")
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
	
	@DisplayName("Verify test parameters - ")
	@ParameterizedTest
	@ValueSource(strings = {"Spring", "Framework", "Guru"})
	void testValueSource(String value) {
		//Given
		String[] expectedArgs = {"Spring", "Framework", "Guru"};
		assertThat(value).as("The parameter value should be %s.", value)
				.isIn(Arrays.asList(expectedArgs));
	}

}///:~