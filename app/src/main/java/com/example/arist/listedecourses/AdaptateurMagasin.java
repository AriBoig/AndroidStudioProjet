package com.example.arist.listedecourses;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arist on 08/02/2017.
 */

public class AdaptateurMagasin extends ArrayAdapter<Magasin>{

    public AdaptateurMagasin(Context context, List<Magasin> magasin) {
        super(context, 0, magasin);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_magasin,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.magasin = (TextView) convertView.findViewById(R.id.magasin);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        Magasin mag = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.magasin.setText(mag.getMagasin());


        return convertView;
    }

    private class TweetViewHolder{
        public TextView magasin;
    }
}
