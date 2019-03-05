//: guru.springframework.sfgpetclinic.controllers.IndexControllerTest.java


package guru.springframework.sfgpetclinic.controllers;


import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.assertj.core.api.Assertions.*;


@Tag("controllers")
class IndexControllerTest {
	
	IndexController controller;
	
	@BeforeEach
	void setUp() {
		this.controller = new IndexController();
	}

	@DisplayName("Test proper view name is returned from index.")
	@Test
	void testIndex() {
		assertEquals("index", this.controller.index());
		assertEquals("index", this.controller.index(), 
				() -> "Wrong view name returned!");
	}
	
	@DisplayName("AssertJ: Test proper view name returned from index.")
	@Test
	void testIndexWithAssertionJ() { 
		
		// Given
		String actualViewName = this.controller.index(); 
		
		assertThat(actualViewName)
				.as("Wrong view name: '%s' returned!", actualViewName)
				.isEqualTo("indes");
	}
	
	@Test
	@DisplayName("Test Exception")
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class, controller::oopsHandler);
	}
	
	@Disabled
	@Test
	void testTimeout() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(3000);
			System.out.println("I got here.");
		});
	}
	
	/*
	 * Note: the executable will be executed in a different thread than
	 * that of the calling code. 
	 * Furthermore, execution of the executable will be preemptively aborted 
	 * if the timeout is exceeded. 
	 */
	@Disabled
	@Test
	void testTimeoutPreemptively() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(3000);
			System.out.println("I got here Preemptively.");
		});
	}
	
	/*
	 * Failed assumptions do not result in a test failure; rather, 
	 * a failed assumption results in a test being aborted.
	 */
	@Test
	void testAssumptionTrueForFailedSituation() {
		assumeTrue("Ubuntu_16".equalsIgnoreCase(System.getenv("OS")));
	}
	
	@Test
	void testAssumptionTrueForReal() {
		// Given
		String os = "Ubuntu_16";
		assumeTrue("Ubuntu_16".equalsIgnoreCase(os));
	}
	
	@EnabledOnOs(OS.MAC)
	@Test
	void testMeOnMacOs() {
	}
	
	@EnabledOnOs(OS.WINDOWS)
	@Test
	void testMeOnWindows() {
	}
	
	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void testMeOnJava8() {
	}
	
	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testMeOnJava11() {
	}
	
	@EnabledIfEnvironmentVariable(named = "username", matches = "yul")
	@Test
	void testIfUserIsYul() {
	}
	
	@EnabledIfEnvironmentVariable(named = "username", matches = "joel")
	@Test
	void testIfUserIsJoel() {
	}

}///:~