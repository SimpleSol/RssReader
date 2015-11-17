package com.example.leon.rssreader.content;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.leon.rssreader.sqlite.SQLiteProvider;
import com.example.leon.rssreader.sqlite.SQLiteTable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Leon on 19.10.2015.
 */
@Root(strict = false)
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

    @Element(name = "title")
    String mTitle;

    @Element(name = "link")
    String mLink;

    @Override
    public String toString() {
        return mTitle;
    }

    public ContentValues toContentValues(String channelId) {
        final ContentValues values = new ContentValues();
        values.put(Columns.TITLE, mTitle);
        values.put(Columns.LINK, mLink);
        values.put(Columns.CHANNEL_ID, channelId);
        return values;
    }

    public interface Columns extends BaseColumns {
        String TITLE = "title";
        String LINK = "link";
        String CHANNEL_ID = "channel_id";
    }

}
