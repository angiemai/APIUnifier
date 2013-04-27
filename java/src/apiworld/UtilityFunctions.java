package apiworld;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;

public final class UtilityFunctions {
	public static String dropTrailingSeparator(String urlParameterTokens,
			String paramSeparator) {
		int lastCharIndex = urlParameterTokens.length()
				- paramSeparator.length();
		if (lastCharIndex > 0) {
			String trailingString = urlParameterTokens.substring(lastCharIndex,
					lastCharIndex + paramSeparator.length());
			if (trailingString.equals(paramSeparator)) {
				return urlParameterTokens.substring(0, lastCharIndex);
			}
		}
		return urlParameterTokens;
	}

	public static boolean doesHaveSeparator(String urlString,
			String commandUrlSeparator) {
		int lastCharIndex = urlString.length() - commandUrlSeparator.length();
		if (lastCharIndex > 0) {
			String trailingString = urlString.substring(lastCharIndex,
					lastCharIndex + commandUrlSeparator.length());
			return trailingString.equals(commandUrlSeparator);
		}
		return false;
	}

	public static boolean doesNotHaveTrailingSeparator(String urlString,
			String commandUrlSeparator) {
		return !doesHaveSeparator(urlString, commandUrlSeparator);
	}

	@SuppressWarnings("deprecation")
	public static String encodeToken(String value) {
		if (value == null) {
			return null;
		}
		return URLEncoder.encode(value);
	}

	public static boolean isNotNull(Object value) {
		return value != null;
	}

}