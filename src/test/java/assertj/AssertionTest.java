//: assertj.BooleanAssertionTest.java


package assertj;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Learning Assertions - ")
public class AssertionTest {

	@Nested
	@DisplayName("When boolean is true - ")
	class BooleanAssertionTest {
		
		@DisplayName("True should be true - ")
		@Test
		void shouldBeTrue() {
			assertThat(true).as("Check true").isTrue();
		}
		
		@DisplayName("False should be false - ")
		@Test
		void shouldBeFalse() {
			assertThat(false).as("Check false").isFalse();
		}
		
	}// End of BooleanAssertionTest
	
	@Nested
	@DisplayName("Comparing Objects - ")
	class ObjectAssertionTest {
		
		private final Object nullObj = null;
		
		@DisplayName("Null Object should be null - ")
		@Test
		void shouldBeNull() {
			assertThat(nullObj).as("Check null object").isNull();
		}
		
		@DisplayName("New Object should not be null - ")
		@Test
		void shouldNotBeNull() {
			assertThat(new Object()).as("Check non-null object").isNotNull();
		}
		
		@DisplayName("When two objects are equal - ")
		@Nested
		class ObjectEqualAssertionTest {
			
			@DisplayName("When two objects are Integers - ")
			@Nested
			class WhenObjectsAreIntegers {
				
				private final Integer actual = 9;
	            private final Integer expected = 9;
	            private final Integer notExpected = 10;
				
	            @DisplayName("Should be equal - ")
	            @Test
	            void shouldBeEqual() {
	            	assertThat(actual).as("Check Integer Compariable Equal")
	            			.isEqualByComparingTo(expected);
	            	assertThat(actual).as("Check Integer Compariable Not Equal")
	            			.isNotEqualByComparingTo(notExpected);
	            }
	           
			}//: End of WhenObjectsAreIntegers
			
		}//: End of ObjectEqualAssertionTest
		
		@DisplayName("When two objects refer to the same object - ")
		@Nested
		class WhenTwoObjectsReferToSameObject {
			
			private Object actual;
			private Object expected;
			
			@BeforeEach
			void setUp() {
				this.actual = new Object();
				this.expected = this.actual;
			}
			
			@Test
			@DisplayName("Should refer to the same object - ")
			void shouldReferSameObject() {
				/*
				 * Verifies that the actual value is the same as the given one 
				 * by using == comparison.
				 */
				assertThat(actual).as("Check actual object")
						.isSameAs(this.expected);
			}
			
		}//: End of WhenTwoObjectsReferToSameObject
		
	}///: End of ObjectAssertionTest
	
	@DisplayName("Assertions for Arrays")
	@Nested
	class WhenArraysEqual {
		
		@Nested
		@DisplayName("When arrays contain Integers - ")
		class WhenArraysContainIntegers {
			
			private int[] actual;
			private int[] expected;
			private int[] unexpected;
			
			@BeforeEach
			void setUp() {
				this.actual = new int[] {
						2, 5, 7, 8,  
				};
				this.expected = new int[] {
						2, 5, 7, 8, 
				};
				this.unexpected = new int[] {
						1, 2, 3, 4, 5, 
				};
			}
			
			/*
			 * Two arrays are considered as equal if: 
			 *   - They are both null or empty.
			 *   - Both arrays contain the “same” objects or values. 
			 *   - To be more specific, JUnit 5 iterates both arrays one 
			 *     element at a time and ensures that the elements found from 
			 *     the given index are equal.
			 */
			@Test
			@DisplayName("Should contain the same integers - ")
			void shouldContainSameIntegers() {
				assertThat(actual).as("Two arrays contain same integers")
						.isEqualTo(this.expected);
			}
			
			@Test
			@DisplayName("Should not contain the same integers - ")
			void shouldNotContainSameIntegers() {
				assertThat(actual).as("Two arrays contain different integers")
						.isNotEqualTo(this.unexpected);
			}
			
		}//: End of WhenArraysContainIntegers
		
	}//: End of WhenArraysEqual
	
	@DisplayName("Assertions for lists - ")
	@Nested
	class ListAssertionTest {
		
		@DisplayName("Assertions for list size - ")
		@Nested
		class WhenComparingListSizes {
			
			private Object first;
			private Object second;
			private List<? super Object> list;
			
			@BeforeEach
			void setUp() {
				this.first = new Object();
				this.second = new Object();
				
				this.list = new ArrayList<>();
				this.list.add(this.first);
				this.list.add(this.second);
			}
		
			/*
			 * If we want to write an assertion which verifies that the size of 
			 * an iterable is correct, we can use one of these three options:
			 *   - isEmpty()
			 *   - isNotEmpty()
			 *   - hasSize() 
			 */
			@DisplayName("Should contain two element in list - ")
			@Test
			void shouldContainTwoElement() {
				// assertThat(this.list).as("The list is empty").isEmpty();
				assertThat(this.list).as("The list is not empty").isNotEmpty();
				assertThat(this.list).as("The list has two elements").hasSize(2);
			}
			
			@DisplayName("Should contain only expected elements in any order - ")
			@Test
			void shouldContainElements() {
				assertThat(this.list).as("Contains same elements in any order")
						.containsExactlyInAnyOrder(this.second, this.first);
			}
				
			/*
			 * If we want to ensure that an iterable contains ONLY the expected 
			 * elements in the given order, we can use containsExactly
			 */
			@DisplayName("Should contain elements in specified order - ")
			@Test
			void shouldContainElementsInASpecifiedOrder() {
				assertThat(this.list).as("Contains same elements and same order")
						.containsExactly(this.first, this.second);
			}
			
			/*
			 * If we want to ensure that an iterable contains the specified 
			 * element, using the containsOnlyOnce() method
			 */
			@DisplayName("Should contain the element only once - ")
			@Test
			void shouldContainSpecifiedElementOnce() {
				assertThat(this.list).as("Contains the element only once")
						.containsOnlyOnce(this.first);
			}
			
			/*
			 * If we want to ensure that an iterable doesn’t contain the 
			 * specified element, using the doesNotContain() method
			 */
			@DisplayName("Should not contain an incorrect element - ")
			@Test
			void shouldNotContainSpecifiedElement() {
				assertThat(this.list).as("Does not contains the element")
						.doesNotContain(new Object());
			}
			
			/*
			 * If we want to verify that two iterables are deeply equal, 
			 * using the isEqualTo() method
			 * 
			 * Two iterables are considered as equal if: 
			 *   - They are both null or empty.
			 *   - Both iterables contain the “same” objects or values. 
			 *       - To be more specific, JUnit 5 iterates both iterables 
			 *         one element at a time and ensures that the elements 
			 *         found from the given index are equal.
			 */
			@DisplayName("Two lists should contain the same element")
			@Test
			void whenCompareTwoLists() {
				
				// Given
				List<Integer> list_1 = IntStream.rangeClosed(1, 7)
						.boxed()
						.collect(Collectors.toList());
				List<Integer> list_2 = IntStream.rangeClosed(1, 7)
						.boxed()
						.collect(Collectors.toList());
				
				// When & Then
				assertThat(list_1).as("Two lists contain same elements")
						.isEqualTo(list_2);
			}
			
		}//: End of WhenComparingListSizes
		
	}
	
	@DisplayName("Assertions for Maps - ")
	@Nested
	class MapAssertionTest {
		
		private final String incorrectKey = "incorrectKey";
	    private final String key = "key";
	    private final String value = "value";
		
	    private Map<String, String> map;
	    
		@BeforeEach
		void setUp() {
			this.map = Map.of(this.key, this.value);
		}
		
		/*
		 * If we want to ensure that a map contains the specified key, 
		 * invoking the containsKey() method
		 * 
		 * If we want to ensure that a map doesn’t contain the specified key, 
		 * invoking the doesNotContainKey() method
		 */
		@DisplayName("Assert Map contains given key - ")
		@Test
		void shouldContainsCorrectkey() {
			assertThat(this.map).containsKey(this.key);
			assertThat(this.map).doesNotContainKey(this.incorrectKey);
		}
		
		/*
		 * If we want to ensure that a map contains the specified entry, 
		 * invoking the containsEntry() method
		 * 
		 * If we want to ensure that a map doesn’t contain the specified entry, 
		 * invoking the doesNotContainEntry() method
		 */
		@DisplayName("Verify the map conatins the given map-entry - ")
		@Test
		void shouldContainGivenEntry() {
			assertThat(this.map).containsEntry(this.key, this.value);
			assertThat(this.map).doesNotContainEntry(this.incorrectKey, 
					this.value);
		}
		
	}//: End of MapAssertionTest
	
	@DisplayName("Assertions for exceptions - ")
	@Nested
	class ExceptionAssertionTest {
		
		final String message = "Hello AssertJ!";
		
		/*
		 * If we have to get access to the actual exception object, 
		 * we must use the catchThrowable() method. Otherwise, we should write 
		 * our assertion by using the assertThatThrownBy() method.
		 * 
		 * If we want to verify that the system under throws the expected 
		 * exception, using the isExactlyInstanceOf() method of 
		 * AbstractThrowableAssert 
		 * 
		 * If we want to verify that the system under throws an exception that 
		 * has the expected message, using the hasMessage() method
		 */
		@DisplayName("Verify the thrown exception - ")
		@Test
		void shouldThrowCorrectException() {
			assertThatThrownBy(() -> { throw new NullPointerException(
							"Hello AssertJ!"); })
					.isExactlyInstanceOf(NullPointerException.class)
					.as("The thrown exception has correct message.")
					.hasMessage(message);
		}
		
		/*
		 * If we have to get access to the actual exception object, 
		 * we must use the catchThrowable() method. 
		 * Otherwise, we should write our assertion by using the 
		 * assertThatThrownBy() method.
		 * 
		 * Catch the thrown exception by using the static catchThrowable() 
		 * method Assertions class
		 * 
		 * If we want to verify that the system under throws the expected 
		 * exception, using the isExactlyInstanceOf()
		 * 
		 * If we want to verify that the system under throws an exception that 
		 * has the expected message, using the hasMessage() method of the 
		 * AbstractThrowableAssert class
		 */
		@DisplayName("Catch the thrown exception - ")
		@Test
		void shouldCatchCorrectException() {
			final Throwable thrown = catchThrowable(
					() -> {throw new NullPointerException("Hello AssertJ!");});
			assertThat(thrown).isExactlyInstanceOf(NullPointerException.class);
			assertThat(thrown.getMessage()).isEqualTo(this.message);
		}
		
	}//: End of ExceptionAssertionTest
	
	@DisplayName("Assertions for Optional objects - ")
	@Nested
	class OptionalAssertionTest {
		
		/*
		 * If we want to ensure that an Optional object is empty, 
		 * invoking the isEmpty() method
		 * 
		 * If we want to ensure that an Optional object is not empty, 
		 * invoking the isNotEmpty() method 
		 */
		@DisplayName("Verify the optional is empty - ")
		@Test
		void shouldBeEmpty() {
			assertThat(Optional.empty()).isEmpty();
			assertThat(Optional.of(new Object())).isNotEmpty();
		}
		
		/*
		 * If we want to ensure that an Optional object contains the expected 
		 * object, invoking the contains() method
		 */
		@DisplayName("Verify the optional contains correct object - ")
		@Test
		void shouldContainCorrectObject() {
			
			// Given
			Object obj = new Object();
			
			assertThat(Optional.of(obj)).contains(obj);
		}
		
	}//: End of OptonalAssertionTest
	
	@DisplayName("Using custom error message - ")
	@Nested
	class CustomErrorMessageTest {
		
		/*
		 * if we want to override only the description part of the shown error 
		 * message, invoking either the as() or the describeAs() method
		 */
		@DisplayName("Only override the description part - ")
		@Test
		void shouldBeTrueWithCustomErrorMessage() {
			assertThat(true)
					.as("The boolean is true")
					.isTrue();
		}
		
		/*
		 * If we want to override the entire error message, 
		 * invoking overridingErrorMessage() method
		 */
		@DisplayName("Override entire error message - ")
		@Test
		void shouldBeTrueWithOverridingEntireErrorMessage() {
			assertThat(true)
					.overridingErrorMessage("The boolean is true")
					.isTrue();
		}
		
	}//: End of CustomErrorMessageTest
	
	/*
	 * If we have to write an assertion for a state that requires multiple 
	 * assertions, it’s a good idea to run all assertions and report all 
	 * assertion failures after all assertions have been run. 
	 * 
	 */
	@DisplayName("Soft Assertions - ")
	@Nested
	class SoftAssertionTest {
		
		private String firstName;
		private String lastName;
		private Person person;
		
		@BeforeEach
		void setUp() {
			this.firstName = "Jane";
			this.lastName = "Dow"; 
			this.person = new Person(this.firstName, this.lastName);
		}

		@DisplayName("Verify the full name of the person - ")
		@Test
		void shouldHaveCorrectFullName() {
			
			// Given
			SoftAssertions softAssertions = new SoftAssertions();
			
			// When 
			softAssertions.assertThat(this.person.getFirstName())
					.overridingErrorMessage(
							"Expected the first name to be: %1$s but it was: %2$s", 
							this.firstName, 
							person.getFirstName())
					.isEqualTo(this.firstName);
			softAssertions.assertThat(this.person.getLastName())
				.overridingErrorMessage(
						"Expected the last name to be: %1$s but it was: %2$s", 
						this.lastName, 
						person.getLastName())
				.isEqualTo(this.lastName);
			
			// Then
			softAssertions.assertAll();
		}
	
	}//: End of SoftAssertionTest
	
}///:~