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

public class ChatList extends AppCompatActivity {

    private ListView chatListView;
    private DokAdapter adapter;
    private List<Dokument> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        chatListView = findViewById(R.id.chat_list_view);
        chatList = new ArrayList<>();

        // 10 dummies
        for (int i = 1; i <= 20; i++) {
            chatList.add(new Dokument("Doktor:in " + i, "Link " + i, "01.06.20" + (40-i), "Fachärzt:in im Bereich " + i));
        }

        adapter = new DokAdapter(this, chatList);
        chatListView.setAdapter(adapter);

        chatListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openChatDetail(view);
            }
        });

    }


    public void openChatDetail(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

}