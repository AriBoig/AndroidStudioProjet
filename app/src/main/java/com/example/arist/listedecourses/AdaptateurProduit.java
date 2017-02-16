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

public class AdaptateurProduit extends ArrayAdapter<Produit>{

    public AdaptateurProduit(Context context, List<Produit> produit) {
        super(context, 0, produit);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_produit,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.emplacement = (TextView) convertView.findViewById(R.id.emplacement);
            viewHolder.prix= (TextView) convertView.findViewById(R.id.prix);
            viewHolder.codeBarre= (TextView) convertView.findViewById(R.id.codeBarre);
            viewHolder.quantite= (TextView) convertView.findViewById(R.id.quantite);
            viewHolder.promotion= (TextView) convertView.findViewById(R.id.promotion);


            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        Produit produit = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(produit.getNom());
        viewHolder.emplacement.setText(produit.getEmplacement());
        viewHolder.prix.setText(produit.getPrix());
        viewHolder.codeBarre.setText(produit.getCodeBarre());
        viewHolder.quantite.setText(produit.getQuantite());
        viewHolder.promotion.setText(produit.getPromotion());

        return convertView;
    }

    private class TweetViewHolder{
        public TextView emplacement;
        public TextView nom;
        public TextView prix;
        public TextView codeBarre;
        public TextView quantite;
        public TextView promotion;
    }
}
