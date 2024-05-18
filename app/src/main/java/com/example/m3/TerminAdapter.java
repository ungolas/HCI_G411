package com.example.m3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class TerminAdapter extends BaseAdapter {

    private Context context;
    private List<Termin> terminList;

    public TerminAdapter(Context context, List<Termin> terminList) {
        this.context = context;
        this.terminList = terminList;
    }

    @Override
    public int getCount() {
        return terminList.size();
    }

    @Override
    public Object getItem(int position) {
        return terminList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_terminliste, parent, false);
        }

        Termin termin = terminList.get(position);

        TextView doctorNameTextView = convertView.findViewById(R.id.doctor_name);
        TextView serviceTagsTextView = convertView.findViewById(R.id.service_tags);
        TextView terminDateTimeTextView = convertView.findViewById(R.id.termin_date_time);

        doctorNameTextView.setText(termin.getDoctorName());
        serviceTagsTextView.setText(termin.getServiceTags());
        terminDateTimeTextView.setText(termin.getDate() + " " + termin.getTime());

        return convertView;
    }
}
