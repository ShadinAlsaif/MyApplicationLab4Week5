package com.example.myapplicationlab4week5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String STUDENT_TABLE = "Student_Table";
    public static final String COLUMN_STUDENT_NAME = "STUDENT_NAME";
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStaement  = "CREATE TABLE " + STUDENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STUDENT_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT )";

        sqLiteDatabase.execSQL(createTableStaement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addOne(StudentMod StudentMod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_STUDENT_NAME, StudentMod.getName());
        cv.put(COLUMN_CUSTOMER_AGE, StudentMod.getAge());
        long insert = db.insert(STUDENT_TABLE,null ,cv);

        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public List<StudentMod> getEveryone()
    {
        List<StudentMod> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + STUDENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do{
                int studentID = cursor.getInt(0);
                String studentName = cursor.getString(1);
                int studentAge = cursor.getInt(2);


                StudentMod newStudent = new StudentMod(studentName, studentID, studentAge );
                returnList.add(newStudent);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return returnList;
    }

}
