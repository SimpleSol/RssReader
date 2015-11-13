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
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.example.leon.rssreader.R;
import com.example.leon.rssreader.content.RssChannel;
import com.example.leon.rssreader.widgets.RssChannelsAdapter;

/**
 * Created by Leon on 21.10.2015.
 */
public class RssChannels extends RssList implements AdapterView.OnItemClickListener {

    @Override
    public void onResume() {
        super.onResume();
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mListView.setOnItemClickListener(null);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), RssChannel.TABLE.getUri(), null, null, null, null);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Bundle args = new Bundle();
        args.putLong(RssChannel.Columns._ID, id);
        final RssNewsList newsList = new RssNewsList();
        newsList.setArguments(args);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, newsList)
                .addToBackStack(RssNewsList.class.getName())
                .commit();
    }
}
