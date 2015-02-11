package com.ingesup.project.judo.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.beans.Takedown;

import java.util.List;

/**
 * Created by clément on 11/02/2015.
 */
public class PriseAdapter extends ArrayAdapter{
    private Context mContext;
    private int mRessource;
    private List<Takedown> mPrises;

    public PriseAdapter(Context mContext, int mRessource, List<Takedown> mPrises) {
        super(mContext,mRessource,mPrises);

        this.mContext = mContext;
        this.mRessource = mRessource;
        this.mPrises = mPrises;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(mRessource,parent,false);
        }

        final Takedown priseEnCours = mPrises.get(position);

        TextView textViewTitre = (TextView) convertView.findViewById(R.id.tv_item_titre);
        textViewTitre.setText(priseEnCours.getName());
        return convertView;
    }
}
