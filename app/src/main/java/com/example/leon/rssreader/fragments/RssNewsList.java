package com.example.leon.rssreader.fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.example.leon.rssreader.R;
import com.example.leon.rssreader.content.RssChannel;
import com.example.leon.rssreader.content.RssNews;
import com.example.leon.rssreader.widgets.RssChannelsAdapter;

/**
 * Created by Leon on 21.10.2015.
 */
public class RssNewsList extends RssList {

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), RssNews.TABLE.getUri(), null, RssNews.Columns._ID + "=?",
                new String[]{String.valueOf(args.getLong(RssChannel.Columns._ID))}, null);
    }
}
