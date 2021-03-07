package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Video {
    String thumbnail;
    String videoTitle;
    String channelName;
    String genre;

    public Video(JSONObject jsonObject) throws JSONException {
        thumbnail = jsonObject.getJSONObject("thumbnails").getString("url");
        videoTitle = jsonObject.getString("title");
        channelName = jsonObject.getString("channelTitle");

        //TODO MAKE A GENRE CALL
        String categoryId = jsonObject.getString("categoryId");
        // genre = genreCall(categoryId)
        genre = categoryId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
