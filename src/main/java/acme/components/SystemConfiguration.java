package acme.components;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class SystemConfiguration {
	
	@NotBlank
	protected static final SystemCurrency defaultCurrency = SystemCurrency.EUR;
	
	@NotBlank
	protected static final List<String> acceptedCurrenciesList = Arrays.asList(SystemCurrency.EUR.toString(), SystemCurrency.USD.toString(), SystemCurrency.GBP.toString());
	
	@NotBlank
	protected static final List<String> strongSpamTermsList = Arrays.asList("sex", "hard core", "viagra", "cialis");
	
	@NotBlank
	protected static final List<String> strongSpamTermsTranslate = Arrays.asList("sex", "hard core", "viagra", "cialis");
	
	@NotBlank
	protected static final Double strongSpamThreshold = 0.1;
	
	@NotBlank
	protected static final List<String> weakSpamTermsList= Arrays.asList("sexy", "nigeria", "you´ve won", "one million");
	
	@NotBlank
	protected static final List<String> weakSpamTermsTranslate = Arrays.asList("sexy", "nigeria", "has ganado", "un millón");
	
	@NotBlank
	protected static final Double weakSpamThreshold = 0.25;
	
}
