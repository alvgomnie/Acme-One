package inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolsListTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/tool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void inventorListTools(final int testIndex, final String name, final String price, final String type) {
	
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "My tools");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, price);
		super.checkColumnHasValue(testIndex, 2, type);
		
		super.clickOnListingRecord(testIndex);
				
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("type", type);
		
	}
	
}
