package inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListCSVTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReportTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String automaticSeqNumber, final String creationMoment, final String memorandum, final String link) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Patronage Report");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(0, 0, automaticSeqNumber);
		super.checkColumnHasValue(0, 1, creationMoment);
		super.checkColumnHasValue(0, 2, memorandum);
		super.checkColumnHasValue(0, 3, link);

		super.signOut();
	}

}
