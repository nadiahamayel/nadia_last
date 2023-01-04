package com.example.myapplication;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {
    public static final String DATA="DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnsaveOnclick(View view) {
        Book[] books= new Book[2];
        books[0]=new Book("java","jhon");
        books[1]=new Book("c++","mark");

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor =prefs.edit();
        Gson gson =new Gson();
        String booksString = gson.toJson(books);

        editor.putString(DATA,booksString);
        editor.commit();
        Toast.makeText(this, "Data Saved :\n" + booksString, Toast.LENGTH_SHORT).show();
    }

    public void btnloadOnclick(View view) {
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson =new Gson();
        String str =prefs.getString(DATA,"");
        if(!str.equals("")){
            Book[] books = gson.fromJson(str,Book[].class);
            Toast.makeText(this, "Data Found :\n" + books.length, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data Not Found :\n" , Toast.LENGTH_SHORT).show();
        }
    }
}