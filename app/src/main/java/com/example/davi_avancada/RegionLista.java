package com.example.davi_avancada;

import com.example.mylibraryRegion.Region;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class RegionLista extends ArrayAdapter<Region> {
    public RegionLista(Context context, List<Region> regioes) {
        super(context, 0, regioes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Region regiao = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_regioes, parent, false);
        }

        TextView nomeRegiao = convertView.findViewById(R.id.textVRegion);
        TextView coordenadasRegiao = convertView.findViewById(R.id.textVCoordenadas);

        nomeRegiao.setText(regiao.getName());
        coordenadasRegiao.setText(String.format("Lat: %.2f, Lng: %.2f", regiao.getLatitude(), regiao.getLongitude()));

        return convertView;
    }
}
