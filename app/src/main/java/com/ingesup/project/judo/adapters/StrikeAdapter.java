package com.ingesup.project.judo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.beans.Strike;

import java.util.List;

/**
 * Created by clément on 11/02/2015.
 */
public class StrikeAdapter extends ArrayAdapter {

    private List<Strike> mStrikes;

    @SuppressWarnings("unchecked")
    public StrikeAdapter(Context context, List<Strike> strikes) {
        super(context, -1, strikes);

        this.mStrikes = strikes;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_strike, parent, false);

        final Strike currentStrike = mStrikes.get(position);

        TextView textViewTitre = (TextView) convertView.findViewById(R.id.tv_strike_name);
        textViewTitre.setText(currentStrike.getName() + " - " + currentStrike.getCategory().getName());

        return convertView;
    }
}
