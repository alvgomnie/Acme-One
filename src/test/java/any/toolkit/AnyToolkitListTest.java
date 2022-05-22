package any.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyToolkitListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousListComponents(final int testIndex, final String title, final String code,
		final String description, final String assemblyNotes, final String link) {
		
		super.clickOnMenu("Toolkits", "List of Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, title);
		super.checkColumnHasValue(testIndex, 1, code);
		super.checkColumnHasValue(testIndex, 2, description);
		super.checkColumnHasValue(testIndex, 3, assemblyNotes);
		super.checkColumnHasValue(testIndex, 4, link);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("link", link);
		

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administratorListComponents(final int testIndex, final String title, final String code,
		final String description, final String assemblyNotes, final String link) {
		
		super.signIn("administrator", "administrator");
			
		super.clickOnMenu("Toolkits", "List of Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, title);
		super.checkColumnHasValue(testIndex, 1, code);
		super.checkColumnHasValue(testIndex, 2, description);
		super.checkColumnHasValue(testIndex, 3, assemblyNotes);
		super.checkColumnHasValue(testIndex, 4, link);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();

	}
	
}