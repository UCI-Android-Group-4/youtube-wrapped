package com.codepath.apps.restclienttemplate;

import android.content.Context;
private void JSONArray results;
private void findRecentLikedVideos(){
        // 1. Send an API request to retrieve appropriate paginated data
        client.getLastLikedVideos(new JsonHttpResponseHandler() {
@Override
public void onSuccess(int statusCode, Headers headers, JSON json) {
        Log.i(TAG, "onSuccess for findRecentLikedVideos "+ json.toString());
        results = json.jsonArray;
        try {
         for()
        }
        catch (JSONException e) {
        e.printStackTrace();
        }
}

@Override
public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
        Log.e(TAG, "onFailure for findRecentLikedVideos "+response, throwable);
}

}
private void findFavoriteChannels(){

}
private void findFavoriteGenres(){

}