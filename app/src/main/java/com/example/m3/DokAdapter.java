package com.example.m3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class DokAdapter extends BaseAdapter {

    private Context context;
    private List<Dokument> dokList;

    public DokAdapter(Context context, List<Dokument> dokList) {
        this.context = context;
        this.dokList = dokList;
    }

    @Override
    public int getCount() {
        return dokList.size();
    }

    @Override
    public Object getItem(int position) {
        return dokList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_dokliste, parent, false);
        }

        Dokument dokument = dokList.get(position);

        TextView dokNameTextView = convertView.findViewById(R.id.dok_name);
        TextView dokDatumTextView = convertView.findViewById(R.id.dok_datum);
        TextView dokKategorieTextView = convertView.findViewById(R.id.dok_kategorie);

        dokNameTextView.setText(dokument.getDokName());
        dokDatumTextView.setText(dokument.getDate());
        dokKategorieTextView.setText(dokument.getCategory());

        return convertView;
    }
}
