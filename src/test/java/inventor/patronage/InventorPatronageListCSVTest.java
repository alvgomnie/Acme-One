package inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageListCSVTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String startingDate, final String finishingDate, final String link) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(0, 0, status);
		super.checkColumnHasValue(0, 1, code);
		super.checkColumnHasValue(0, 2, legalStuff);
		super.checkColumnHasValue(0, 3, budget);
		super.checkColumnHasValue(0, 4, startingDate);
		super.checkColumnHasValue(0, 5, finishingDate);
		super.checkColumnHasValue(0, 6, link);

		super.signOut();
	}

}