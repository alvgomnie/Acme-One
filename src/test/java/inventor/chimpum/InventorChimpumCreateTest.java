package inventor.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorChimpumCreateTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/createchimpum.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void inventorCreateItemPositive(final int testIndex, final String title, final String code,
		final String description, final String budget, final String creationMoment, final String finishingDate,
		final String link) {
				
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "Chimpum");
		super.checkListingExists();
		
		super.clickOnButton("Create");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("finishingDate", finishingDate);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Inventor", "Chimpum");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(testIndex);
				
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("finishingDate", finishingDate);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/createchimpumnegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void inventorCreateItemNegative(final int testIndex, final String title, final String code,
		final String description, final String budget, final String creationMoment, final String finishingDate,
		final String link) {
				
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "Chimpum");
		super.checkListingExists();
		
		super.clickOnButton("Create");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("finishingDate", finishingDate);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
		super.signOut();
	
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/chimpum/create");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/chimpum/create");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("provider1", "provider1");
		super.navigate("/inventor/chimpum/create");
		super.checkPanicExists();
		super.signOut();
		
	}
	
}
