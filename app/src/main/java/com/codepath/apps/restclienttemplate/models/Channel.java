package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Channel {
    String thumbnail;
    String name;

    public Channel(JSONObject jsonObject) throws JSONException {
        thumbnail = jsonObject.getJSONObject("thumbnails").getString("url");
        name = jsonObject.getString("title");
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }
}
