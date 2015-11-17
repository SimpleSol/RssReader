package com.example.leon.rssreader.api;

import com.example.leon.rssreader.content.RssFeed;

import retrofit.http.GET;

/**
 * Created by Leon on 14.11.2015.
 */
public interface RssService {

    @GET("/index.rss")
    RssFeed feed();

}
