package acme.components;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AntiSpam {
	
	public static Boolean spamValidator(final String text, final List<String> weakSpamWords,
		final List<String> strongSpamWords, final double weakThreshold, final double strongThreshold) {
			
		final Boolean res;
		final Boolean weakSpamCondition;
		final Boolean strongSpamCondition;
		
		final String myRegexStrong = AntiSpam.regexBuilder(strongSpamWords);
		final String myRegexWeak = AntiSpam.regexBuilder(weakSpamWords);
		
		final Double strongPercentage = AntiSpam.percentageSpamWords(myRegexStrong, text);
		final Double weakPercentaje = AntiSpam.percentageSpamWords(myRegexWeak, text);
		
		strongSpamCondition = strongPercentage <= strongThreshold;
		weakSpamCondition = weakPercentaje <= weakThreshold;
		
		res = strongSpamCondition && weakSpamCondition;
		
		return res;
		
	}
	
	public static double percentageSpamWords(final String myRegex, final String text) {
		
		final Pattern pattern = Pattern.compile(myRegex, Pattern.CASE_INSENSITIVE);
		final Matcher matchResult = pattern.matcher(text);
		final int totalWords = AntiSpam.wordsInText(text);
		final int totalMatches = AntiSpam.countMatches(matchResult);
		
		return ((double)totalMatches/(double)totalWords) * 100.;
	}
	
	private static int countMatches(final Matcher matchResult) {
		
		int count = 0;
		while(matchResult.find()) {
			count++;
		}
		
		return count;
	}
	
	private static int wordsInText(final String text) {
		final String[] textLength = text.split(" ");
		return textLength.length;
	}
	
	private static String regexBuilder(final List<String>spamWords) {
		
		final StringBuilder regexBuilder = new StringBuilder();
		
		for(int i=0; i<spamWords.size(); i++) {
			
			final String word = spamWords.get(i);
			final String[] parts = word.split(" ");
			
			if(parts.length > 1) { 
				final StringBuilder auxBuilder = new StringBuilder();
				
				for(int j=0; j < parts.length; j++) {
					if(j == parts.length-1) {
						auxBuilder.append(parts[j]);
					}
					else {
						auxBuilder.append(parts[j]+"[^\\w]*");
					}
				}
				
				if(i == spamWords.size()-1) {
					regexBuilder.append(auxBuilder.toString());
				}
				else {
					regexBuilder.append(auxBuilder.toString()+"|");
				}
					
			}
			else {		
				if(i == spamWords.size()-1) {
					regexBuilder.append(word);
				}
				else {
					regexBuilder.append(word+"|");
				}
			}
		}
		
		return regexBuilder.toString();
	}

}
