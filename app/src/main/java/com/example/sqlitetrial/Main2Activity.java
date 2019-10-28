package com.example.sqlitetrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button BnSave, BnView;
    public TextView nameView, emailView, idView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        BnSave=findViewById(R.id.save_btn);
        BnView=findViewById(R.id.button2);

        nameView=findViewById(R.id.name_view);
        emailView=findViewById(R.id.email_view);
        idView=findViewById(R.id.id_view);

        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1=nameView.getText().toString();
                String email1=emailView.getText().toString();
                String id1=idView.getText().toString();

                DBSchemaClass dbSchemaClass  = new DBSchemaClass(getApplicationContext());
                SQLiteDatabase database = dbSchemaClass.getWritableDatabase();

                dbSchemaClass.addContact(Integer.parseInt(id1),name1,email1,database);
                dbSchemaClass.close();

                Toast.makeText(getApplicationContext(),"Row added successfully",Toast.LENGTH_SHORT).show();

            }
        });


        BnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });

    }
}
