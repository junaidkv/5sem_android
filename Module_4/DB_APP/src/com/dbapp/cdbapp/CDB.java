package com.dbapp.cdbapp;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CDB extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 1;
	 
    private static final String DATABASE_NAME = "UserDb";
    
    private static final String TABLE_NAME = "UserDt";
    
    private static final String KEY_ID = "id";
    private static final String KEY_UNAME = "uname";
    private static final String KEY_NAME = "name";


	public CDB(Context context)
	{
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table " + TABLE_NAME + "(id integer primary key autoincrement,uname text,name text)");
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int ov, int nv) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS UserDet");
        onCreate(db);

	}
	void add(CUser rec)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues objRec = new ContentValues();
		objRec.put(KEY_UNAME, rec.uname);
		objRec.put(KEY_NAME, rec.name);
		db.insert(TABLE_NAME, null, objRec);
		db.close();
	}
	CUser getOneContact(int id)
	{
		CUser rec = null;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
                KEY_UNAME,KEY_NAME }, KEY_ID + "=?", new String[] { String.valueOf(id) },
                null, null, null, null);
        if (cursor != null && cursor.getCount() !=0 ) 
        {
        	rec = new CUser();
            cursor.moveToFirst();
            rec.id = id;
            rec.uname = cursor.getString(1);
            rec.name = cursor.getString(2);
        }
		return rec;
	}
	// Deleting single record
    public int delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,  KEY_ID + " = ?", new String[] { String.valueOf(id) });
    }
    public void update(CUser rec)
    {
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(KEY_UNAME, rec.uname);
        values.put(KEY_NAME,rec.name);
        
 
        // updating row
        db.update(TABLE_NAME, values, KEY_ID + " = ?",new String[] { String.valueOf(rec.id) });

    }
    
    public List<CUser> getAllvalues() {
        List<CUser> recList = new ArrayList<CUser>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CUser rec = new CUser();
                rec.id = Integer.parseInt(cursor.getString(0));
                rec.uname = cursor.getString(1);
                rec.name =  cursor.getString(2);
                recList.add(rec);
            } while (cursor.moveToNext());
        }
 
        return recList;
    }

}
