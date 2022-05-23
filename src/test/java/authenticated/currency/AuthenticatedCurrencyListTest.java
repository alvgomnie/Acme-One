package authenticated.currency;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedCurrencyListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/currency/currency.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void authenticatedListCurrency(final int testIndex, final String name, final String onDefault, final String accepted) {
	
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Account", "Currency List");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(testIndex, 0, name);
		super.checkColumnHasValue(testIndex, 1, onDefault);
		
		super.clickOnListingRecord(testIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("onDefault", onDefault);
		super.checkInputBoxHasValue("accepted", accepted);
		
	}

}
