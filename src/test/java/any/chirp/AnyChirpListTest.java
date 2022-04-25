package any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/chirp.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousListComponents(final int testIndex, final String title, final String author, final String moment, final String body, final String email) {
	
		super.clickOnMenu("Chirps", "List chirps");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, title);
		super.checkColumnHasValue(testIndex, 1, author);
		super.checkColumnHasValue(testIndex, 2, moment);
		super.checkColumnHasValue(testIndex, 3, body);
		super.checkColumnHasValue(testIndex, 4, email);
		
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/chirp.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administratorListComponents(final int testIndex, final String title, final String author, final String moment, final String body, final String email) {

		super.signIn("administrator", "administrator");
	
		super.clickOnMenu("Chirps", "List chirps");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, title);
		super.checkColumnHasValue(testIndex, 1, author);
		super.checkColumnHasValue(testIndex, 2, moment);
		super.checkColumnHasValue(testIndex, 3, body);
		super.checkColumnHasValue(testIndex, 4, email);

	
		super.signOut();
		
	}
}