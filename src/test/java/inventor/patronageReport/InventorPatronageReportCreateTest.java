package inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/patronageReportPositiveCreate.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String automaticSeqNum, final String creationMoment, final String memorandum, final String link) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Create a Patronage Report");
	
		super.fillInputBoxIn("automaticSeqNum", automaticSeqNum);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create Patronage Report");
		
		super.clickOnMenu("Inventor", "Patronage Report");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, automaticSeqNum);
		super.checkColumnHasValue(recordIndex, 1, creationMoment);
		super.checkColumnHasValue(recordIndex, 2, memorandum);
		super.checkColumnHasValue(recordIndex, 3, link);
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("automaticSeqNum", automaticSeqNum);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/patronageReportNegativeCreate.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String automaticSeqNum, final String creationMoment, final String memorandum, final String link) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Create a Patronage Report");
	
		super.fillInputBoxIn("automaticSeqNum", automaticSeqNum);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create Patronage Report");
		
		super.checkErrorsExist();
	
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("provider1", "provider1");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		super.signOut();
		
	}

}
