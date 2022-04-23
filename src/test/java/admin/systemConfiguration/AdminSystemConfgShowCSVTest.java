package admin.systemConfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdminSystemConfgShowCSVTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/admin/systemConfigurationTest.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String defaultCurrency, final String acceptedCurrenciesList, final String strongSpamTermsList,
		final String strongSpamTermsTranslate, final String strongSpamTreshold, final String weakSpamTermsList,
		final String weakSpamTermsTranslate, final String weakSpamThreshold) {
		super.signIn("admin1", "admin1");

		super.clickOnMenu("Administrator", "System Configuration");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, defaultCurrency);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("defaultCurrency", defaultCurrency);
		super.checkInputBoxHasValue("acceptedCurrenciesList", acceptedCurrenciesList);
		super.checkInputBoxHasValue("strongSpamTermsList", strongSpamTermsList);
		super.checkInputBoxHasValue("strongSpamTermsTranslate", strongSpamTermsTranslate);
		super.checkInputBoxHasValue("strongSpamTreshold", strongSpamTreshold);
		super.checkInputBoxHasValue("weakSpamTermsList", weakSpamTermsList);
		super.checkInputBoxHasValue("weakSpamTermsTranslate", weakSpamTermsTranslate);
		super.checkInputBoxHasValue("weakSpamThreshold", weakSpamThreshold);

		super.signOut();
	}

}
