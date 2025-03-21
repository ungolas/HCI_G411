package com.example.m3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openTerminverwaltung(View view) {
        Intent intent = new Intent(this, TerminverwaltungActivity.class);
        startActivity(intent);
    }

    public void openProfil(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void openDoks(View view) {
        Intent intent = new Intent(this, DokActivity.class);
        startActivity(intent);
    }

    public void openChat(View view) {
        Intent intent = new Intent(this, ChatList.class);
        startActivity(intent);
    }

    public void openSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
