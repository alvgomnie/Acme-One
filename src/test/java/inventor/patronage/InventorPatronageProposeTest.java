package inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageProposeTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/patronageProposeTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String startingDate, final String finishingDate, final String link) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(1);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", "PROPOSED");
		super.fillInputBoxIn("status", "ACCEPTED");
		super.clickOnSubmit("Update");
		
		super.clickOnListingRecord(1);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", "ACCEPTED");
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/patronageProposeTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String startingDate, final String finishingDate, final String link) {

		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(2);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", "PROPOSED");
		super.fillInputBoxIn("status", "DENIED");
		super.clickOnSubmit("Update");
		
		super.clickOnListingRecord(2);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", "DENIED");
		
		super.signOut();
	}

}
