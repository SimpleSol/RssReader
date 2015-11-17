package com.example.leon.rssreader.content;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.leon.rssreader.sqlite.SQLiteProvider;
import com.example.leon.rssreader.sqlite.SQLiteTable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Leon on 19.10.2015.
 */
@Root(strict = false)
public class RssChannel {

    public static final SQLiteTable TABLE = new SQLiteTable(SQLiteProvider.AUTHORITY, "channels") {
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + getName() + "(" +
                    "_id INTEGER PRIMARY KEY, " +
                    "title TEXT, " +
                    "link TEXT);");
        }
    };

    @Element(name = "title")
    String mTitle;

    @Element(name = "link")
    String mLink;

    @ElementList(entry = "item", inline = true)
    List<RssNews> mNews;

    public List<RssNews> getmNews() {
        return mNews;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public ContentValues toContentValues() {
        final ContentValues values = new ContentValues();
        values.put(Columns.TITLE, mTitle);
        values.put(Columns.LINK, mLink);
        return values;
    }

    public interface Columns extends BaseColumns {
        String TITLE = "title";
        String LINK = "link";
    }

}
