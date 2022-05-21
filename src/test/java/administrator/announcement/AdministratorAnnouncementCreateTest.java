package administrator.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/announcementPositiveCreate.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String title, final String date, final String body, final String link) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Create an announcement");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("creationMoment", date);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create an announcement");
		
		super.clickOnMenu("Account", "Announcement");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		
		
		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("link", link);
		

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/announcementNegativeCreate.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String title, final String date, final String body, final String link) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Create an announcement");
	
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("creationMoment", date);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create an announcement");
		
		super.checkErrorsExist();

		super.signOut();
	}


}
