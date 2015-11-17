package com.example.leon.rssreader.loader;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;

import com.example.leon.rssreader.api.RssService;
import com.example.leon.rssreader.content.RssChannel;
import com.example.leon.rssreader.content.RssNews;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by Leon on 14.11.2015.
 */
public class YandexLoader extends CursorLoader {

    private RssService mApi;

    public YandexLoader(Context context) {
        super(context, RssChannel.TABLE.getUri(), null, null, null, null);
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://news.yandex.ru/")
                .setConverter(new SimpleXMLConverter())
                .build();
        mApi = restAdapter.create(RssService.class);
    }

    @Override
    public Cursor loadInBackground() {
        RssChannel channel = mApi.feed().getChannel();

        getContext().getContentResolver().delete(RssChannel.TABLE.getUri(), null, null);
        Uri uri = getContext().getContentResolver().insert(RssChannel.TABLE.getUri(), channel.toContentValues());

        String channelId = uri.getLastPathSegment();
        List<RssNews> newsList = channel.getmNews();
        getContext().getContentResolver().delete(RssNews.TABLE.getUri(), null, null);
        for (final RssNews news : newsList) {
            getContext().getContentResolver().insert(RssNews.TABLE.getUri(), news.toContentValues(channelId));
        }
        return super.loadInBackground();
    }
}
