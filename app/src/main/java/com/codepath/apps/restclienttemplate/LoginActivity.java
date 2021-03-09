package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.codepath.apps.restclienttemplate.models.SampleModel;
import com.codepath.apps.restclienttemplate.models.SampleModelDao;

import com.codepath.oauth.OAuthLoginActionBarActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends OAuthLoginActionBarActivity<YoutubeClient> implements GoogleApiClient.OnConnectionFailedListener {

	public static final String TAG = "LoginActivity";
	SampleModelDao sampleModelDao;
	private Button loginButton;
	private GoogleApiClient googleApiClient;
	private static final int RC_SIGN_IN = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		/*
		final SampleModel sampleModel = new SampleModel();
		sampleModel.setName("CodePath");

		sampleModelDao = ((YoutubeApplication) getApplicationContext()).getMyDatabase().sampleModelDao();

		AsyncTask.execute(new Runnable() {
			@Override
			public void run() {
				sampleModelDao.insertModel(sampleModel);
			}
		});

		*/
		loginButton = findViewById(R.id.loginButton);

		GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
				.requestIdToken("703717598440-3818vuqml3e2f3j923jfmtesa0fr4c1a.apps.googleusercontent.com")
				.requestEmail()
				.build();
		googleApiClient = new GoogleApiClient.Builder(this)
			.enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
				startActivityForResult(i, RC_SIGN_IN);
				googleApiClient.connect();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==RC_SIGN_IN){
			GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
			handleSignInResult(result);
		}
	}

	private void handleSignInResult(GoogleSignInResult result){
		Log.i(TAG, String.valueOf(result.getStatus()));
		if(result.isSuccess()){
			gotoResults();
		}else{
			Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
		}
	}

	private void gotoResults(){
		Intent intent=new Intent(LoginActivity.this, ResultsActivity.class);
		startActivity(intent);
	}

	// Inflate the menu; this adds items to the action bar if it is present.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	// OAuth authenticated successfully, launch primary authenticated activity
	// i.e Display application "homepage"
	@Override
	public void onLoginSuccess() {
		Intent i = new Intent(this, ResultsActivity.class);
		startActivity(i);
		Log.i(TAG, "LoginSuccess");
	}

	// OAuth authentication flow failed, handle the error
	// i.e Display an error dialog or toast
	@Override
	public void onLoginFailure(Exception e) {
		e.printStackTrace();
		Log.e(TAG, "LoginFailure");
	}

	// Click handler method for the button used to start OAuth flow
	// Uses the client to initiate OAuth authorization
	// This should be tied to a button used to login
	public void loginToRest(View view) {
		getClient().connect();
		Log.i(TAG, "Login to rest");

	}


	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}
}
