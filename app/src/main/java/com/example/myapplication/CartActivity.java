package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    DatabaseHelper db;

    ArrayList<String> orderlist;
    ArrayAdapter adapter;

    ListView listView1;

    Button orderBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        db = new DatabaseHelper(this);

        orderBtn = findViewById(R.id.orderbtn);
        listView1 = findViewById(R.id.orderlistview);

        vieworder();
    }

    private void vieworder() {
        Cursor cursor = db.viewCartData();
        if (cursor.getCount()==0){
            Toast.makeText(this,"No Item Selected",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                orderlist.add(cursor.getString(1));
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orderlist);
            listView1.setAdapter(adapter);

        }
    }
}
