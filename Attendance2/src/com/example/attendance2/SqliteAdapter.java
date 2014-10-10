package com.example.attendance2;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteAdapter extends SQLiteOpenHelper {

	private static String DATABASE_NAME="students";
	private static int DATABASE_VERSION=1;
	private static String TABLE_NAME="studentsdetails";
	private static String TABLE_DATE="date";
	private static String TABLE_MAIN="attendance";
	private static String ID="id";
	private static String NAME="name";
	private static String DATE="date";
	private static String NAME_ID="name_id";
	private static String DATE_ID="date_id";
	private static String ATTEND="attend";
	
	public SqliteAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE=" CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT " + ")";  
		
		db.execSQL(CREATE_TABLE);
		
		String CREATE_DATE=" CREATE TABLE " + TABLE_DATE + "(" + ID + " INTEGER PRIMARY KEY, " + DATE + " TEXT " + ")";
		db.execSQL(CREATE_DATE);
	
		String MAIN_TABLE=
		" CREATE TABLE " + TABLE_MAIN + "(" + ID + " INTEGER PRIMARY KEY, " + NAME_ID + " TEXT," + DATE_ID + " TEXT," + ATTEND + " INTEGER " + ")";  
		
		db.execSQL(MAIN_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
		db.execSQL(" DROP TABLE IF EXISTS " + TABLE_DATE);
		onCreate(db);
		db.execSQL(" DROP TABLE IF EXISTS " + TABLE_MAIN);
		onCreate(db);
	}

	public long addStudent(Student student){
		
		SQLiteDatabase db=this.getWritableDatabase();
		
		ContentValues values=new ContentValues();
		
		values.put(NAME,student.getName());
		
		 long name_id=db.insert(TABLE_NAME, null, values);
		
		db.close();
		return name_id;
		
	}
	public ArrayList<Student> getAllStudents(){
		
		ArrayList<Student> listNames=new ArrayList<Student>();
		
		String selectQuery=" SELECT * FROM " + TABLE_NAME;
		
		SQLiteDatabase db=this.getWritableDatabase();
		
		
		Cursor cursor=db.rawQuery(selectQuery, null);	
		
		if(cursor.moveToFirst()){
			do{
				Student student=new Student();
				student.setId(Integer.parseInt(cursor.getString(0)));
				student.setName(cursor.getString(1));
				listNames.add(student);
			
			}while(cursor.moveToNext());
		}
	
		
		return listNames;
		
	}
	
	public long addDATE(DateData datedata){
		
		SQLiteDatabase db=this.getWritableDatabase();
		
		ContentValues values=new ContentValues();
		
		values.put(DATE,datedata.getDate());
		long date_id=db.insert(TABLE_DATE, null, values);
		db.close();
		return date_id;
	}

	public void updateDATA(long name_id,long date_id,Boolean attend) {
		// TODO Auto-generated method stub
	
	        SQLiteDatabase db = this.getWritableDatabase();
	 
	     ContentValues values = new ContentValues();
	     values.put(NAME_ID, name_id);
	     values.put(DATE_ID, date_id);
		
		if(attend==true){
			
			values.put(ATTEND, 1);
			
			
		}
		else{
			values.put(ATTEND, 0);
			
		}
	        // updating row
	        db.update(TABLE_MAIN, values, NAME_ID + " = ?",
	                new String[] {String.valueOf(name_id)});
	    
	}
	
	public void addPresent(long name_id,long date_id,Boolean attend){
		
		SQLiteDatabase db=this.getWritableDatabase();
		
		ContentValues values=new ContentValues();
		values.put(NAME_ID, name_id);
		values.put(DATE_ID, date_id);
		
	Log.e("insert", "work hard");
		
		
		if(attend==true){
			
			values.put(ATTEND, 1);
			
			
		}
		else{
			values.put(ATTEND, 0);
			
		}
		
		db.insert(TABLE_MAIN, null, values);
	}
}
