package inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitListCSVTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkitTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String publish, final String link) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(0, 0, code);
		super.checkColumnHasValue(0, 1, title);
		super.checkColumnHasValue(0, 2, description);
		super.checkColumnHasValue(0, 3, assemblyNotes);
		super.checkColumnHasValue(0, 4, publish);
		super.checkColumnHasValue(0, 5, link);
	
		super.signOut();
	}

}
