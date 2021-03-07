package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.apps.restclienttemplate.models.Channel;
import com.codepath.apps.restclienttemplate.models.Result;
import com.codepath.apps.restclienttemplate.models.Video;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Headers;

public class ResultsActivity extends AppCompatActivity {

    public static final String TAG = "ResultsActivity";
    Result result;

    YoutubeClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }


    private void findRecentLikedVideos(){
        // 1. Send an API request to retrieve appropriate paginated data
        client.getLastLikedVideos(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.i(TAG, "onSuccess for findRecentLikedVideos "+ json.toString());
                JSONObject results_object = json.jsonObject;

                try {
                    JSONArray results = results_object.getJSONArray("items");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject object = results.getJSONObject(i);
                        Video video = new Video(object);
                        Channel channel = new Channel(object);
                        result.addFavoriteChannel(channel);
                        result.addFavoriteVideo(video);
                        result.addFavoriteGenre(video.getGenre());
                    }
                } catch (JSONException jsonException) {
                    jsonException.printStackTrace();
                }

            }


            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "onFailure for findRecentLikedVideos "+response, throwable);
            }

        });
    }
}