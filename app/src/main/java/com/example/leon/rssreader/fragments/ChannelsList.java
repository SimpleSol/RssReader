package com.example.leon.rssreader.fragments;

import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.leon.rssreader.R;
import com.example.leon.rssreader.content.RssNews;
import com.example.leon.rssreader.loader.YandexLoader;

/**
 * Created by Leon on 21.10.2015.
 */
public class ChannelsList extends RssList implements AdapterView.OnItemClickListener {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(0, Bundle.EMPTY, this);
        super.onActivityCreated(savedInstanceState);
    }

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
        return new YandexLoader(getActivity());
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Bundle args = new Bundle();
        args.putLong(RssNews.Columns.CHANNEL_ID, id);
        final NewsList newsList = new NewsList();
        newsList.setArguments(args);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, newsList)
                .addToBackStack(NewsList.class.getName())
                .commit();
    }
}
