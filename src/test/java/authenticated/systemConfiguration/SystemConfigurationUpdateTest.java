package authenticated.systemConfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class SystemConfigurationUpdateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/systemConfiguration/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSystemConfigurationTest(final String strongSpamTreshold, final String weakSpamTreshold) {
		
		super.signIn("administrator", "administrator");
	
		super.clickOnMenu("Administrator", "System Configuration");
		super.fillInputBoxIn("strongSpamTreshold", strongSpamTreshold);
		super.fillInputBoxIn("weakSpamTreshold", weakSpamTreshold);
		super.clickOnSubmit("Update");
		
		super.clickOnMenu("Administrator", "System Configuration");
		super.checkInputBoxHasValue("strongSpamTreshold", strongSpamTreshold);
		super.checkInputBoxHasValue("weakSpamTreshold", weakSpamTreshold);
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/systemConfiguration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeSystemConfigurationTest(final String strongSpamTreshold, final String weakSpamTreshold) {
			
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "System Configuration");
		super.fillInputBoxIn("strongSpamTreshold", strongSpamTreshold);
		super.fillInputBoxIn("weakSpamTreshold", weakSpamTreshold);
		super.clickOnSubmit("Update");
		
		super.checkErrorsExist();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();
		
	}
}

