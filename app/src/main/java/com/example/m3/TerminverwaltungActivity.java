package com.example.m3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

public class TerminverwaltungActivity extends AppCompatActivity {

    private ListView terminListView;
    private TerminAdapter adapter;
    private List<Termin> terminList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminverwaltung);

        terminListView = findViewById(R.id.termin_list_view);
        terminList = new ArrayList<>();

        // Dummy data
        terminList.add(new Termin("Dr. Müller", "Kontrolle", "01.06.2024", "10:00", "Herbststraße 33", "+43 664 65278177"));
        terminList.add(new Termin("Dr. Walcher", "Vorsorgeuntersuchung", "02.06.2024", "11:00", "Hauptplatz 3", "+43 664 65278177"));

        adapter = new TerminAdapter(this, terminList);
        terminListView.setAdapter(adapter);

        terminListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showTerminDetails(terminList.get(position));
            }
        });

        terminListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                confirmAndDeleteTermin(position);
                return true;
            }
        });
    }

    private void showTerminDetails(Termin termin) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(termin.getDoctorName());

        String message =termin.getServiceTags() +
                "\nDatum: " + termin.getDate() +
                "\nUhrzeit: " + termin.getTime() +
                "\nAdresse: " + termin.getAddress() +
                "\nKontaktdaten: " + termin.getContact();

        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void confirmAndDeleteTermin(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Termin stornieren");
        builder.setMessage("Möchten Sie diesen Termin wirklich stornieren?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                terminList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Nein", null);
        builder.show();
    }
}
