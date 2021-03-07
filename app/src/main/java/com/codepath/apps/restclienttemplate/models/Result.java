package com.codepath.apps.restclienttemplate.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public void addFavoriteChannel(Channel channel) {
        favoriteChannel.add(channel);
    }

    public void addFavoriteGenre(String genre) {
        favoriteGenres.add(genre);
    }

    public void addFavoriteVideo(Video video) {
        favoriteVideos.add(video);
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

    public ArrayList<String> getTopThreeGenres() {
        //TODO Get top 3 Genres
        HashMap<String, Integer> genreMap = new HashMap<String, Integer>();
        for (String genre : favoriteGenres) {
            if (genreMap.get(genre) == null) {
                genreMap.put(genre, 1);
            } else {
                genreMap.put(genre, genreMap.get(genre) + 1);
            }
        }


        //THIS IDEA OR PAIRS
        ArrayList<String> topThreeGenres = new ArrayList<String>();

        Map<Integer, String> map = sortByValues(genreMap);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        Integer count = 0;
        while(iterator2.hasNext()) {
            if (count == 3) {
                break;
            }
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(me2.getKey() + ": ");
            System.out.println(me2.getValue());
            count += 1;
        }
        return topThreeGenres;

    }

    private HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public ArrayList<Channel> getTopThreeChannels() {
        //TODO Get top 3 Channels
        return favoriteChannel;
    }

    public ArrayList<Video> getTopThreeVideos() {
        //TODO Get top 3 Videos
        return favoriteVideos;
    }
}
