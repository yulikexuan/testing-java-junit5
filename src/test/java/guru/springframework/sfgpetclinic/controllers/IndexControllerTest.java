//: guru.springframework.sfgpetclinic.controllers.IndexControllerTest.java


package guru.springframework.sfgpetclinic.controllers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class IndexControllerTest {
	
	IndexController controller;
	
	@BeforeEach
	void setUp() {
		this.controller = new IndexController();
	}

	@DisplayName("Test proper view name is returned from index.")
	@Test
	void testIndes() {
		assertEquals("index", this.controller.index());
		assertEquals("index", this.controller.index(), 
				() -> "Wrong view name returned!");
	}
	
	@Test
	@DisplayName("Test Exception")
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class, controller::oopsHandler);
	}

}///:~