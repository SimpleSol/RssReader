package com.example.leon.rssreader.views;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leon.rssreader.content.RssChannel;

/**
 * Created by Leon on 21.10.2015.
 */
public class RssChannelItem extends LinearLayout {

    private TextView mTitle;
    private TextView mLink;

    public RssChannelItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void bindCursor(Cursor cursor) {
        mTitle.setText(cursor.getString(cursor.getColumnIndex(RssChannel.Columns.TITLE)));
        mLink.setText(cursor.getString(cursor.getColumnIndex(RssChannel.Columns.LINK)));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTitle = (TextView) findViewById(android.R.id.text1);
        mLink = (TextView) findViewById(android.R.id.text2);
    }
}
