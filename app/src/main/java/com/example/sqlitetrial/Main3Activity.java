package com.example.sqlitetrial;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        TextView textView = findViewById(R.id.textView);

        DBSchemaClass dbSchemaClass = new DBSchemaClass(this);
        SQLiteDatabase database = dbSchemaClass.getReadableDatabase();

        Cursor cursor = dbSchemaClass.readContact(database);

        String info="";

        while (cursor.moveToNext())
        {
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContractDBClass.ContactEntry.COLUMN_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContractDBClass.ContactEntry.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContractDBClass.ContactEntry.COLUMN_EMAIL));

            info+="\n\n"+"id: "+id+"\nName: "+name+"\nEmail: "+email;
        }

        textView.setText(info);


    }
}
