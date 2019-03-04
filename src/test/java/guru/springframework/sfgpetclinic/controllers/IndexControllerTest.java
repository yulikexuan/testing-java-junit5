//: guru.springframework.sfgpetclinic.controllers.IndexControllerTest.java


package guru.springframework.sfgpetclinic.controllers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class IndexControllerTest {
	
	IndexController controller;
	
	@BeforeEach
	void setUp() {
		this.controller = new IndexController();
	}

	@Test
	void testIndes() {
		assertEquals("index", this.controller.index());
		assertEquals("index", this.controller.index(), 
				() -> "Wrong view name returned!");
	}
	
	@Test
	void testOupsHandler() {
		assertTrue("notimplemented".equals(this.controller.oupsHandler()), 
				() -> "This is some expensive Message to build for this test");
	}

}///:~