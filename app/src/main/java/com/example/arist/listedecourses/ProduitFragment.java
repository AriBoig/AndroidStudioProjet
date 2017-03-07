package com.example.arist.listedecourses;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProduitFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    ListView mListView;
    public ProduitFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_produits, container, false);

        mListView = (ListView) v.findViewById(R.id.listeProduits);
        //List<Produit> tweets = genererProduit();
        //AdaptateurProduit adapter = new AdaptateurProduit(getContext(), tweets);
        BaseDeDonnees obj = new BaseDeDonnees(getContext(),"listeCourse.db", null, 32);
        List<Produit> produit = obj.createProduits();
        AdaptateurProduit adapter = new AdaptateurProduit(getContext(), produit);

        mListView.setAdapter(adapter);
        return v;
    }

    private List<Produit> genererProduit(){
        List<Produit> produit = new ArrayList<Produit>();
        produit.add(new Produit("Pain","5","baguette","||| || ||","5","2","Boulangerie"));
        produit.add(new Produit("ylol","8","chocolat","||| |||| ||","8","3","Chocolat"));
        return produit;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Liste de produits");
    }
}
