package patron.patronage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronagesCreateTest extends TestHarness{
	
	
	LocalDateTime startingTime = LocalDateTime.now().plusMonths(2);
    LocalDateTime finishingTime = LocalDateTime.now().plusMonths(4);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String startingDate = this.startingTime.format(this.formatter);
    String finishingDate = this.finishingTime.format(this.formatter);
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronageTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String link) {
		
		super.signIn("patron3", "patron3");
	
		super.clickOnMenu("Patron", "Patronages");
		super.checkListingExists();
		super.clickOnButton("Create");
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("startingDate", this.startingDate);
		super.fillInputBoxIn("finishingDate", this.finishingDate);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create");
		
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("startingDate", this.startingDate);
		super.checkInputBoxHasValue("finishingDate", this.finishingDate);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativePatronageTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String link) {
		
		
		super.signIn("patron3", "patron3");
		
		super.clickOnMenu("Patron", "Patronages");
		super.clickOnButton("Create");
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("startingDate", this.startingDate);
		super.fillInputBoxIn("finishingDate", this.finishingDate);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create");
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
