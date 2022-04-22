package anonymous.useraccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnonymousUserAccountListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/useraccount/user-account.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousListComponents(final int testIndex, final String name, final String surname, final String email, final String username) {
	
		//                    PATRON                     //
		
		super.clickOnMenu("Users", "List all patrons");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, surname);
		super.checkColumnHasValue(testIndex, 2, email);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("surname", surname);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("username", username);
		
		//                   INVENTOR                    //
		
		super.clickOnMenu("Users", "List all inventors");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, surname);
		super.checkColumnHasValue(testIndex, 2, email);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("surname", surname);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("username", username);
		
		//                   CONSUMER                    //
				
		super.clickOnMenu("Users", "List all consumers");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, surname);
		super.checkColumnHasValue(testIndex, 2, email);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("surname", surname);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("username", username);
		
		//                   PROVIDER                   //
				
		super.clickOnMenu("Users", "List all providers");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, surname);
		super.checkColumnHasValue(testIndex, 2, email);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("surname", surname);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("username", username);
		
	}
}
