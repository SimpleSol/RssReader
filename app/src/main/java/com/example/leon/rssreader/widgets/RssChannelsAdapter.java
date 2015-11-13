package com.example.leon.rssreader.widgets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.example.leon.rssreader.R;
import com.example.leon.rssreader.views.RssChannelItem;

/**
 * Created by Leon on 21.10.2015.
 */
public class RssChannelsAdapter extends CursorAdapter {

    public RssChannelsAdapter(Context context) {
        super(context, null, FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.li_rss_channel, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((RssChannelItem) view).bindCursor(cursor);
    }
}
