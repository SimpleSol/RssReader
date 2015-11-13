package com.example.leon.rssreader.content;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.leon.rssreader.sqlite.SQLiteProvider;
import com.example.leon.rssreader.sqlite.SQLiteTable;

/**
 * Created by Leon on 19.10.2015.
 */
public class RssNews {

    public static final SQLiteTable TABLE = new SQLiteTable(SQLiteProvider.AUTHORITY, "news") {
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + getName() + "(" +
                    "_id INTEGER PRIMARY KEY, " +
                    "title TEXT, " +
                    "link TEXT, " +
                    "channel_id INTEGER);");
        }
    };

    public String getTitle() {
        return "";
    }

    public String getLink() {
        return "";
    }

    public long getId() {
        return 0;
    }

    public long getChannelId() {
        return 0;
    }

    public interface Columns extends BaseColumns{
        String TITLE = "title";
        String LINK = "link";
        String CHANNEL_ID = "channel_id";
    }

}
