package com.example.leon.rssreader.fragments;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import com.example.leon.rssreader.content.RssNews;

/**
 * Created by Leon on 21.10.2015.
 */
public class NewsList extends RssList {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(0, getArguments(), this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), RssNews.TABLE.getUri(), null, RssNews.Columns.CHANNEL_ID + "=?",
                new String[]{String.valueOf(args.getLong(RssNews.Columns.CHANNEL_ID))}, null);
    }
}
