package com.example.sqlitetrial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSchemaClass extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table "+ContractDBClass.ContactEntry.TABLE_NAME+"("+ContractDBClass.ContactEntry.COLUMN_ID+
            " number,"+ ContractDBClass.ContactEntry.COLUMN_NAME+" text,"+ ContractDBClass.ContactEntry.COLUMN_EMAIL+" text);";

    public static final String DROP_TABLE = "drop table if exists "+ ContractDBClass.ContactEntry.TABLE_NAME;


    public DBSchemaClass(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void addContact(int id, String name, String email, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContractDBClass.ContactEntry.COLUMN_ID,id);
        contentValues.put(ContractDBClass.ContactEntry.COLUMN_NAME,name);
        contentValues.put(ContractDBClass.ContactEntry.COLUMN_EMAIL,email);

        sqLiteDatabase.insert(ContractDBClass.ContactEntry.TABLE_NAME,null,contentValues);
    }

    public Cursor readContact(SQLiteDatabase database)
    {
        String[] projections={ContractDBClass.ContactEntry.COLUMN_ID, ContractDBClass.ContactEntry.COLUMN_NAME, ContractDBClass.ContactEntry.COLUMN_EMAIL};

        Cursor cursor=database.query(ContractDBClass.ContactEntry.TABLE_NAME,projections,null,null,null
        ,null,null,null);

        return cursor;
    }
}
