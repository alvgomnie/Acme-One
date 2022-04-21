package any.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyComponentListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/component.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousListComponents(final int testIndex, final String name, final String type) {
	
		super.clickOnMenu("Items", "List of Components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, type);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("type", type);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/component.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administratorListComponents(final int testIndex, final String name, final String type) {

		super.signIn("administrator", "administrator");
	
		super.clickOnMenu("Items", "List of Components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, type);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("type", type);

	
		super.signOut();
		
	}
}