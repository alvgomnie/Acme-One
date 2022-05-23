package authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedAnnouncementListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousListAnnouncements(final int testIndex, final String creationMoment, final String title, final String body, final String link) {
	
		//Announcement 2 -> Invetor 1
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Account", "Announcement");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 1, creationMoment);
		super.checkColumnHasValue(testIndex, 0, title);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("link", link);

	}
	
}