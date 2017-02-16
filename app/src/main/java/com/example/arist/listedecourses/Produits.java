package com.example.arist.listedecourses;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Produits extends AppCompatActivity {

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mListView = (ListView) findViewById(R.id.listeProduits);
        List<Produit> tweets = genererProduit();

        AdaptateurProduit adapter = new AdaptateurProduit(Produits.this, tweets); 


        mListView.setAdapter(adapter);
    }

    private List<Produit> genererProduit(){
        List<Produit> produit = new ArrayList<Produit>();
        produit.add(new Produit("Pain","5","baguette","","5","2","Boulangerie"));
        return produit;
    }
}
