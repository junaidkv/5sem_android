package com.pp.dbook;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "DBBook";
	// tasks table name
	private static final String TABLE_BOOK = "TBBook";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_BNAME = "bname";
	private static final String KEY_AUTH = "bauth"; //correct option
	
	private SQLiteDatabase dbase;
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_BOOK + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_BNAME
				+ " TEXT, " + KEY_AUTH+ " TEXT)";
		db.execSQL(sql);		
		//db.close();
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addBook(String bn,String an) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_BNAME, bn); 
		values.put(KEY_AUTH, an);
		
		// Inserting Row
		db.insert(TABLE_BOOK, null, values);		
	}
	public Book getOneBook(String id) {
		Book b = null;
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_BOOK + " where id=" + id;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				b = new Book();
				b.bname = cursor.getString(1);
				b.aname = cursor.getString(2);
				
			} while (cursor.moveToNext());
		}
		// return quest list
		return b;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_BOOK;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
}
