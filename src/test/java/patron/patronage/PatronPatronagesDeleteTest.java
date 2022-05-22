package patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronagesDeleteTest extends TestHarness{
	
	@ParameterizedTest
	@Order(10)
	@CsvFileSource(resources = "/patron/delete.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positivePatronageTest(final int recordIndex) {
		
		super.signIn("patron2", "patron2");
		
		super.clickOnMenu("Patron", "Patronages");
		super.clickOnListingRecord(recordIndex);
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		super.checkListingEmpty();
		super.signOut();
	}
	
	@Test
	@Order(20)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage/delete");
		super.checkPanicExists();
		
	}

}
