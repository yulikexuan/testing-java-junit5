//: guru.springframework.sfgpetclinic.model.OwnerTest.java


package guru.springframework.sfgpetclinic.model;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
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
	
	@DisplayName("ValueSource Tests - ")
	@ParameterizedTest(name = "{displayName} [{index}] {arguments}")
	@ValueSource(strings = {"Spring", "Framework", "Guru"})
	void testValueSource(String value) {
		//Given
		String[] expectedArgs = {"Spring", "Framework", "Guru"};
		assertThat(value).as("The parameter value should be %s.", value)
				.isIn(Arrays.asList(expectedArgs));
	}
	
	@DisplayName("Test Enum Parameters: OwnerType - ")
	@ParameterizedTest(name = "{displayName} [{index}] {arguments}")
	@EnumSource(OwnerType.class)
	void testOwnerType(OwnerType ownerType) {
		assertThat(ownerType)
				.as("The param should be %s!", 
						OwnerType.class.getSimpleName())
				.isInstanceOf(OwnerType.class);
	}
	
	@DisplayName("Test CSV Parameters - ")
	@ParameterizedTest(name = "{displayName} [{index}] {arguments}")
	@CsvSource({
		"FL, 1, 2", 
		"OH, 3, 4", 
		"MI, 5, 6", 
	})
	void testCsvInput(String stateName, int val1, int val2) {
		assertAll(
				() ->assertThat(stateName)
						.as("The state name should be %1$s", stateName)
						.isEqualTo(stateName), 
				() ->assertThat(val1)
						.as("The 1st. val should be %1$d", val1)
						.isEqualTo(val1), 
				() ->assertThat(val2)
						.as("The 2nd. val should be %1$d", val2)
						.isEqualTo(val2)
		);
	}

}///:~