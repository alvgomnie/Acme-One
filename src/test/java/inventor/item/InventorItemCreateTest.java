package inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/items.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void inventorCreateItemPositive(final int testIndex, final String name, final String type,
		final String code, final String technology, final String description,
		final String retailPrice, final String link, final String published) {
		
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "My components");
		super.checkListingExists();
		
		super.clickOnButton("Create");
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("published", published);
		super.clickOnSubmit("Create");
		
		if(type.equals("COMPONENT")) {
			super.clickOnMenu("Inventor", "My components");
			super.checkListingExists();
			super.sortListing(0, "asc");
			super.clickOnListingRecord(testIndex);
		}
		else {
			super.clickOnMenu("Inventor", "My tools");
			super.checkListingExists();
			super.sortListing(0, "asc");
			super.clickOnListingRecord(testIndex);
		}
				
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("published", published);
		super.checkInputBoxHasValue("link", link);		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/negativeItem.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void inventorCreateItemNegative(final int testIndex, final String name, final String type,
		final String code, final String technology, final String description,
		final String retailPrice, final String link, final String published) {
		
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "My components");
		super.checkListingExists();
		
		super.clickOnButton("Create");
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("published", published);
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
		super.signOut();
		
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/item/create");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/item/create");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("provider1", "provider1");
		super.navigate("/inventor/item/create");
		super.checkPanicExists();
		super.signOut();
		
	}

}
