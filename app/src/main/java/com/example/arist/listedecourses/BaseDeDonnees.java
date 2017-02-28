package com.example.arist.listedecourses;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arist on 15/02/2017.
 */

public class BaseDeDonnees extends SQLiteOpenHelper {

    private static final String NOM_TABLE = "table";

    //Table Vend-------------------------------------------------------------------------------------------------------------------------------------
    private static final String TABLE_VEND = "Vend";
    private static final String PRIX = "prix";
    private static final String UNITE = "unite";
    private static final String RAYON = "rayon";
    private static final String PROMOTION = "promotion";
    //Table Liste------------------------------------------------------------------------------------------------------------------------------------
    private static final String TABLE_LISTE = "Listes";
    private static final String ID_LISTE = "id_liste";
    private static final String QUANTITEE = "quantite";
    private static final String ACHETE = "achete";
    //Table Produit------------------------------------------------------------------------------------------------------------------------------------
    private static final String TABLE_PRODUIT = "Produits";
    private static final String ID_PRODUIT = "id_produit";
    private static final String CATEGORIE = "categorie";
    private static final String NOM_PRODUIT = "nom_produit";
    private static final String CODE_PRODUIT = "code_produit";
    //Table Magasin------------------------------------------------------------------------------------------------------------------------------------
    private static final String TABLE_MAGASIN = "Magasins";
    private static final String ID_MAGASIN = "id_magasin";
    private static final String NOM_MAGASIN = "nom_magasin";


    private static final String CREATE_TABLE_VEND = "CREATE TABLE " + TABLE_VEND
            + "(" + ID_PRODUIT + " INT PRIMARY, "
            + ID_MAGASIN + " INT, "
            + PRIX + " FLOAT, "
            + UNITE + " TEXT NOT NULL, "
            + RAYON + " TEXT, "
            + PROMOTION + " TEXT, "
            + " PRIMARY KEY('id_produit','id_magasin')); ";

    private static final String CREATE_TABLE_LISTE = "CREATE TABLE " + TABLE_LISTE
            + "(" + ID_LISTE + " INT PRIMARY KEY AUTOINREMENT, "
            + ID_PRODUIT + " INT, "
            + ID_MAGASIN + " INT, "
            + QUANTITEE + " FLOAT, "
            + ACHETE + " FLOAT, "
            + " PRIMARY KEY('id_liste','id_produit','id_magasin') "
            + " FOREIGN KEY(" + ID_PRODUIT + ") REFERENCES " + TABLE_VEND + "(" + ID_PRODUIT + "), "
            + " FOREIGN KEY(" + ID_MAGASIN + ") REFERENCES " + TABLE_VEND + "(" + ID_MAGASIN + "));";

    private static final String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT
            + "(" + ID_PRODUIT + " INT PRIMARY, "
            + CATEGORIE + " INT, "
            + NOM_PRODUIT + " TEXT NOT NULL, "
            + CODE_PRODUIT + " TEXT, "
            + " PRIMARY KEY('id_produit') "
            + " FOREIGN KEY(" + ID_PRODUIT + ") REFERENCES " + TABLE_PRODUIT + "(" + ID_PRODUIT + "), "
            + " FOREIGN KEY(" + ID_MAGASIN + ") REFERENCES " + TABLE_MAGASIN + "(" + ID_MAGASIN + "));";

    private static final String CREATE_TABLE_MAGASIN = "CREATE TABLE " + TABLE_MAGASIN
            + "(" + ID_MAGASIN + " INT PRIMARY KEY AUTOINREMENT, "
            + NOM_MAGASIN + " TEXT NOT NULL, "
            + " PRIMARY KEY('id_magasin') );";

    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("Création de la table");
        db.execSQL(CREATE_TABLE_VEND);
        db.execSQL(CREATE_TABLE_LISTE);
        db.execSQL(CREATE_TABLE_PRODUIT);
        db.execSQL(CREATE_TABLE_MAGASIN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_VEND + ";");
        db.execSQL("DROP TABLE " + TABLE_LISTE + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_MAGASIN + ";");
        onCreate(db);
    }


}
