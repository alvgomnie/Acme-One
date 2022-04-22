package inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorComponentListTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/component.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void inventorListComponents(final int testIndex, final String name, final String price, final String type, final String code,
		final String technology, final String description, final String link) {
	
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, price);
		super.checkColumnHasValue(testIndex, 2, type);
		
		super.clickOnListingRecord(testIndex);
				
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("retailPrice", price);
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);
		
	}
	
}

