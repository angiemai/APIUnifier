package examples.TwitterAPI;

import apiworld.APIBuilder;
import apiworld.APIReader;

import apiworld.APIKeyNotAssignedException;
import apiworld.BaseURLNotAssignedException;
import apiworld.UtilityFunctions;

public class BaseTwitterAPI {
	
	private static final String TWITTER_URL_PARAM = "api_key";
	private String baseURL = "http://search.twitter.com/";
	private String paramStart = "?";
	public APIReader fetchedResults;

	protected APIReader buildAPIReadyToExecute(String apiKey, String apiCommand, String paramStart,
			String[] arrayURLParamCodes, String... params) {
		APIBuilder apiBuilder = new APIBuilder();
		apiBuilder.addBaseURL(baseURL);
		apiBuilder.setCommand(apiCommand);
		apiBuilder.setParamStart(paramStart);
		apiBuilder.setNoAPIKeyRequired();
		int paramCtr = 0;
		for (String eachValue : params) {
			apiBuilder.addAURLParameter(arrayURLParamCodes[paramCtr++],
					UtilityFunctions.encodeToken(eachValue));
		}

		try {
			apiBuilder.build();
			return new APIReader(apiBuilder);
		} catch (BaseURLNotAssignedException | APIKeyNotAssignedException e) {
			System.out.format("%s", e.getMessage());
		}
		
		return new APIReader(baseURL);
	}
	
	public String getFetchedResults() {
		if (fetchedResults != null) {
			return fetchedResults.getFetchedResults();
		}
		return "";
	}
}