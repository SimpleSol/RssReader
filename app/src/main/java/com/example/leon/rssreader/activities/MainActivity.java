package com.example.leon.rssreader.activities;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.leon.rssreader.R;
import com.example.leon.rssreader.content.RssChannel;
import com.example.leon.rssreader.content.RssNews;
import com.example.leon.rssreader.fragments.RssChannels;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, new RssChannels())
                    .commit();
        }

//        final ContentValues values = new ContentValues();
//        values.put(RssChannel.Columns.TITLE, "Яндекс.Новости: Hardware");
//        values.put(RssChannel.Columns.LINK, "https://news.yandex.ru/hardware.html");
//        getContentResolver().insert(RssChannel.TABLE.getUri(), values);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }


}
