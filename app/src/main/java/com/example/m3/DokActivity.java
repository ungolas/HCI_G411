package com.example.m3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DokActivity extends AppCompatActivity {

    private ListView dokumentListView;
    private DokAdapter adapter;
    private List<Dokument> dokumentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dok);

        dokumentListView = findViewById(R.id.dok_list_view);
        dokumentList = new ArrayList<>();

        // 10 dummies
        for (int i = 1; i <= 20; i++) {
            dokumentList.add(new Dokument("Dokument " + i, "Link " + i, "01.06.20" + (40-i), "Category " + i));
        }

        adapter = new DokAdapter(this, dokumentList);
        dokumentListView.setAdapter(adapter);

        dokumentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openDokDetail(view);
            }
        });

    }


    public void openDokDetail(View view) {
        Intent intent = new Intent(this, DokDetailActivity.class);
        startActivity(intent);
    }

}