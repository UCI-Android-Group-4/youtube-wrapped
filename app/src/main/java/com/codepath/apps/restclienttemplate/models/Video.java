package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Video {
    String thumbnail;
    String videoTitle;
    String channelName;

    public Video(JSONObject jsonObject) throws JSONException {
        thumbnail = jsonObject.getJSONObject("thumbnails").getString("url");
        videoTitle = jsonObject.getString("title");
        channelName = jsonObject.getString("channelTitle");
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

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
}
