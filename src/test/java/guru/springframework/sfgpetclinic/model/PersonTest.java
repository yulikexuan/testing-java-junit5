//: guru.springframework.sfgpetclinic.model.PersonTest.java


package guru.springframework.sfgpetclinic.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ModelTest;


class PersonTest implements ModelTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void groupAssertions() {
		// Given
		Person person = new Person(1l, "Joe", "Buck");
		
		// When
		
		// Then
		assertAll("Test Props Set", 
				() -> assertEquals(person.getFirstName(), "Joe"), 
				() -> assertEquals(person.getLastName(), "Buck"));
	}
	
	@Test
	void groupAssertionsMsgs() {
		// Given
		Person person = new Person(1l, "Joe", "Buck");
		
		// When
		
		// Then
		assertAll("Test Props Set", 
				() -> assertEquals(person.getFirstName(), "Joe", 
						() -> "First Name Failed!"), 
				() -> assertEquals(person.getLastName(), "Buck", 
						() -> "Last Name Failed!"));
	}
	
	@DisplayName("Run this test multiple times")
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
	void repeatedTest() {
	}

}///:~