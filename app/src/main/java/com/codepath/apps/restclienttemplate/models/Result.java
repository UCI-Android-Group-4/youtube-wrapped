package com.codepath.apps.restclienttemplate.models;

import java.util.ArrayList;

public class Result {
    ArrayList<Channel> favoriteChannel;
    ArrayList<String> favoriteGenres;
    ArrayList<Video> favoriteVideos;

    public Result() {
        favoriteChannel = new ArrayList<Channel>();
        favoriteGenres = new ArrayList<String>();
        favoriteVideos = new ArrayList<Video>();
    }

    public ArrayList<Channel> getFavoriteChannel() {
        return favoriteChannel;
    }

    public ArrayList<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public ArrayList<Video> getFavoriteVideos() {
        return favoriteVideos;
    }

    public void setFavoriteChannel(ArrayList<Channel> favoriteChannel) {
        this.favoriteChannel = favoriteChannel;
    }

    public void setFavoriteGenres(ArrayList<String> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public void setFavoriteVideos(ArrayList<Video> favoriteVideos) {
        this.favoriteVideos = favoriteVideos;
    }
}
