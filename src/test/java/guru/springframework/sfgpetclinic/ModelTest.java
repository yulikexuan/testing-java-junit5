//: guru.springframework.sfgpetclinic.ModelTest.java


package guru.springframework.sfgpetclinic;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;


@Tag("model")
public interface ModelTest {
	
	@BeforeEach
	default void beforeEachConsoleOutputer(TestInfo testInfo) {
		System.out.println("Running Test - " + testInfo.getDisplayName() + " ... ");
	}
	
}///:~