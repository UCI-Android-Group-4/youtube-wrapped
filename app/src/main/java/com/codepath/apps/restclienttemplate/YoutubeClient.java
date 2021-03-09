package com.codepath.apps.restclienttemplate;

import android.content.Context;

import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.BaseApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/scribejava/scribejava/tree/master/scribejava-apis/src/main/java/com/github/scribejava/apis
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */

public class YoutubeClient extends OAuthBaseClient {
	public static final BaseApi REST_API_INSTANCE = GoogleApi20.instance(); // Change this
	public static final String REST_URL = "https://accounts.google.com/o/oauth2/v2/auth"; // Change this, base API URL
	public static final String BASE_URL = "https://www.googleapis.com/youtube/v3";
	public static final String REST_CONSUMER_KEY = BuildConfig.CONSUMER_KEY;       // Change this inside apikey.properties
	public static final String REST_CONSUMER_SECRET = BuildConfig.CONSUMER_SECRET; // Change this inside apikey.properties

	// Landing page to indicate the OAuth flow worked in case Chrome for Android 25+ blocks navigation back to the app.
	public static final String FALLBACK_URL = "https://codepath.github.io/android-rest-client-template/success.html";

	// See https://developer.chrome.com/multidevice/android/intents
	public static final String REST_CALLBACK_URL_TEMPLATE = "intent://%s;action=android.intent.action.VIEW;scheme=%s;package=%s;S.browser_fallback_url=%s;end";

	public YoutubeClient(Context context) {
		super(context, REST_API_INSTANCE,
				REST_URL,
				REST_CONSUMER_KEY,
				REST_CONSUMER_SECRET,
				"https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fyoutube.readonly",  // OAuth2 scope, null for OAuth1
				String.format(REST_CALLBACK_URL_TEMPLATE,
						"cprest", "oauth", context.getPackageName(), FALLBACK_URL));
	}
	// CHANGE THIS
	// DEFINE METHODS for different API endpoints here
	public void getOAuth(JsonHttpResponseHandler handler) {
		// 	scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fyoutube.readonly&response_type=code&state=security_token%3D138r5719ru3e1%26url%3Dhttps%3A%2F%2Foauth2.example.com%2Ftoken&redirect_uri={redirect_uri}client_id={client_id}
		String apiUrl = getApiUrl("?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fyoutube.readonly&response_type=code&state=security_token%3D138r5719ru3e1%26url%3Dhttps%3A%2F%2Foauth2.example.com%2Ftoken&redirect_uri={redirect_uri}client_id={client_id}");
		// Can specify query string params directly or through RequestParams.
		RequestParams params = new RequestParams();
		params.put("format", "json");
		params.put("scope", "https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fyoutube.readonly");
		client.get(apiUrl, params, handler);
	}
	public void getLastLikedVideos(JsonHttpResponseHandler handler) {
		String apiUrl = getApiUrl(BASE_URL);
		// Can specify query string params directly or through RequestParams.
		RequestParams params = new RequestParams();
		params.put("part", "snippet");
		params.put("myRating", "like");
		params.put("maxResults", 50);
		client.get(apiUrl, params, handler);
	}
	public void getChannelData(JsonHttpResponseHandler handler, String id) {
		String apiUrl = getApiUrl(BASE_URL);
		// Can specify query string params directly or through RequestParams.
		RequestParams params = new RequestParams();
		params.put("part", "snippet");
		params.put("id", id);
		client.get(apiUrl, params, handler);
	}


	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}
