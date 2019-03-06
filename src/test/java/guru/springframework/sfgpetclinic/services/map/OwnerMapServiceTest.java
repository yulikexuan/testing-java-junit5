//: guru.springframework.sfgpetclinic.services.map.OwnerMapServiceTest.java


package guru.springframework.sfgpetclinic.services.map;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ServiceTest;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;


/*
 * All nested test classes must be non-static inner classes.
 * 
 * We have annotate our nested test classes with the @Nested annotation. 
 * This annotation ensures that JUnit 5 recognizes our nested test classes.
 * 
 * There is no limit for the depth of the class hierarchy.
 * 
 * By default, a nested test class can contain test methods, 
 * one @BeforeEach method, and one @AfterEach method.
 * 
 * Because Java doesn’t allow static members in inner classes, 
 * the @BeforeAll and @AfterAll methods don’t work by default.
 * 
 */
@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest implements ServiceTest {
	
	OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

	@BeforeEach
	void setUp() throws Exception {
		this.petTypeService = new PetTypeMapService();
		this.petService = new PetMapService();
		this.ownerMapService = new OwnerMapService(this.petTypeService, 
				this.petService);
	}

	@DisplayName("Initially Verify Zero Owners")
	@Test
	void ownersAreZero() {
		// When 
		int ownerCount = this.ownerMapService.findAll().size();
		
		// Then
		assertThat(ownerCount).isZero();
	}

	@DisplayName("Pet Type - ")
	@Nested
	class TestCreatePetTypes {
		
		@BeforeEach
		void setUp() {
			PetType petType = new PetType(1L, "Dog");
			PetType petType2 = new PetType(2L, "Cat");
			petTypeService.save(petType);
			petTypeService.save(petType2);
		}
		
		@DisplayName("Test Pet Count")
		@Test
		void testPetTypeCount() {
			int petTypeCount = petTypeService.findAll().size();
			assertThat(petTypeCount).isNotZero().isEqualTo(2);
		}
		
		@DisplayName("Save Owners Tests - ")
		@Nested
		class SaveOwnersTests {
			
			@BeforeEach
			void setUp() {
				ownerMapService.save(new Owner(1L, "Before", "Each"));
			}
			
			@DisplayName("Test Saving Owner")
			@Test
			void testSaveOwner() {
				// Given
				Owner owner = new Owner(2L, "Joe", "Buck");
				
				// When
				Owner savedOwner = ownerMapService.save(owner);
				
				// Then
				assertThat(savedOwner).isNotNull();
			}
			
			@DisplayName("Find Owners Tests - ")
			@Nested
			class FindOwnersTest {
				
				@DisplayName("Find Owner")
				@Test
				void findOwner() {
					// When
					Owner foundOwner = ownerMapService.findById(1L);
					
					// Then
					assertThat(foundOwner).isNotNull();
					
				}
				
				@DisplayName("Test Owner Not Found")
				@Test
				void findOwnerNotFount() {
					// When
					Owner foundOwner = ownerMapService.findById(2L);
					
					// Then
					assertThat(foundOwner).isNull();
				}
			}
			
		}// End of SaveOwnersTests
		
	}// End of TestCreatePetTypes

	@DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

}///:~