package com.example.munira.notebooklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Munira on 24-Feb-18.
 */
/*step:1 create SQLiteHelper*/
public class DatabaseHelper extends SQLiteOpenHelper {


    /*step:2 declare object And Create Database*/

     /*step:3 SQL statement to create DATABASE table */
    final static String DATABASE_NOTEDB="NotebookListDB";
    final static String TABLE_NAME="item_table";
    /*step:2 declare object*/
    final static String INCOME_ID="id";
    final static String INCOME_TITLE="title";
    final static String INCOME_AMOUNT="amount";
    final static String INCOME_DATE="date";







    /*next time use for create context*/
    Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NOTEDB, null, 1);

    }





    @Override
    public void onCreate(SQLiteDatabase db) {

        //db=this.getWritableDatabase();

         String CREATE_DATABASE_QUERY="create table "+TABLE_NAME + "(" +
                INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                INCOME_TITLE + " TEXT, " +
                INCOME_AMOUNT + " TEXT, " +
                INCOME_DATE + " INTEGER  )";

         /*create income table run*/
        db.execSQL(CREATE_DATABASE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /*step:4 SQL statement to Drop DATABASE table */
         String ON_UPGRADE_QUERY="DROP TABLE" +DATABASE_NOTEDB;
        /*DROP INCOME  TABLE RUN*/
        db.execSQL(ON_UPGRADE_QUERY);
        /*again create table*/
        onCreate(db);

    }

        /*step:5 Insert data to table */
      public boolean  insertData(String title,String amount,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(INCOME_TITLE,title);
        contentValues.put(INCOME_AMOUNT,amount);
        contentValues.put(INCOME_DATE,date);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
            else
                return true;

    }


    /*step:6 Update data to table */
    public boolean  updateData(String id,String title,String amount,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(INCOME_TITLE,title);
        contentValues.put(INCOME_AMOUNT,amount);
        contentValues.put(INCOME_DATE,date);
        long result=db.update(DATABASE_NOTEDB, contentValues,"ID = ?",new String[]{id});

            return true;

    }


/*
    *//* step:7 List to normal show data*//*
    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM " + DATABASE_NOTEDB,null);
        return res;
    }*/

    /* step:7 List to multi show data*/
    public List<Item> getAllData() {
        List<Item> itemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String amount = cursor.getString(2);
                String date = cursor.getString(3);
                Item item = new Item();
                item.setWishId(id);
                item.setWishString(title);
                item.setAmountInteger(amount);
                item.setNoteDate(date);
                itemList.add(item);
            }

        }
        db.close();
        return itemList;
    }


    /* step:7 List to show data*/
    public Integer deleteData (int id) {
        String ids=""+id;
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {ids});

    }





}
