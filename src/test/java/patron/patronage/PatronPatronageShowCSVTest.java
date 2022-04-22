package patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageShowCSVTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronageTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String startingDate, final String finishingDate, final String link) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, status);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("startingDate", startingDate);
		super.checkInputBoxHasValue("finishingDate", finishingDate);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}

}