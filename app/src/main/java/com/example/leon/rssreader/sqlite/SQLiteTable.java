package com.example.leon.rssreader.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Leon on 19.10.2015.
 */
public abstract class SQLiteTable {

    private final String mName;

    private final Uri mUri;

    protected SQLiteTable(String authority, String name) {
        mName = name;
        mUri = new Uri.Builder()
                .scheme("content")
                .authority(authority)
                .appendPath(name)
                .build();

    }

    public Uri getUri() {
        return mUri;
    }

    public String getName() {
        return mName;
    }

    public Cursor query(SQLiteDatabase db, String[] columns, String where, String[] whereArgs, String orderBy) {
        return db.query(getName(), columns, where, whereArgs, null, null, orderBy);
    }

    public long insert(SQLiteDatabase db, ContentValues values) {
        return db.insert(getName(), BaseColumns._ID, values);
    }

    public int delete(SQLiteDatabase db, String where, String[] whereArgs) {
        return db.delete(getName(), where, whereArgs);
    }

    public int update(SQLiteDatabase db, ContentValues values, String where, String[] whereArgs) {
        return db.update(getName(), values, where, whereArgs);
    }

    public abstract void onCreate(SQLiteDatabase db);

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + getName() + ";");
        onCreate(db);
    }

}
