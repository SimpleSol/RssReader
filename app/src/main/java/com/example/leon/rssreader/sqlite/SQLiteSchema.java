package com.example.leon.rssreader.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Leon on 19.10.2015.
 */
public class SQLiteSchema extends SQLiteOpenHelper {

    private final Map<Uri, SQLiteTable> mTableMap = new ConcurrentHashMap<Uri, SQLiteTable>();

    public SQLiteSchema(Context context, String name, int version) {
        super(context, name, null, version);
    }

    public SQLiteSchema addTable(Uri uri, SQLiteTable table) {
        mTableMap.put(uri, table);
        return this;
    }

    public SQLiteTable acquireTable(Uri uri) {
        SQLiteTable table = mTableMap.get(uri);
        if (table == null) {
            throw new SQLiteException("No such table for " + uri);
        }
        return table;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (final SQLiteTable table : mTableMap.values()) {
            table.onCreate(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (final SQLiteTable table : mTableMap.values()) {
            table.onUpgrade(db, oldVersion, newVersion);
        }
    }
}
