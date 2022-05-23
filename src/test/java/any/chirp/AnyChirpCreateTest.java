package any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/chirp-createpositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositiveChirp(final int testIndex, final String title, final String author, final String moment, final String body, final String email) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Chirps", "List chirps");
		
		super.checkListingExists();
		super.clickOnButton("New Chirp");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirm", "true");
		super.clickOnSubmit("Create Chirp");
		
		super.clickOnMenu("Chirps", "List chirps");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, title);
		super.checkColumnHasValue(testIndex, 1, author);
		super.checkColumnHasValue(testIndex, 3, body);
		super.checkColumnHasValue(testIndex, 4, email);
		
		super.signOut();
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/chirp-createnegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String title,final String author, final String body,final String email) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Chirps", "List chirps");
	

		super.clickOnButton("New Chirp");
		super.fillInputBoxIn("title",title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body",body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirm", "true");
		super.clickOnSubmit("Create Chirp");
		
		super.checkErrorsExist();

		super.signOut();
	}
	
	

}