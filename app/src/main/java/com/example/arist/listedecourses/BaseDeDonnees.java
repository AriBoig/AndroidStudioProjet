package com.example.arist.listedecourses;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arist on 15/02/2017.
 */

public class BaseDeDonnees extends SQLiteOpenHelper {

    private static final String NOM_TABLE = "table";

    //Table Vend-------------------------------------------------------------------------------------------------------------------------------------
    private static final String TABLE_VEND = "Vendeur";
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
    private static final String TABLE_PRODUIT = "Produit";
    private static final String ID_PRODUIT = "id_produit";
    private static final String CATEGORIE = "categorie";
    private static final String NOM_PRODUIT = "nom_produit";
    private static final String CODE_PRODUIT = "code_produit";
    //Table Magasin------------------------------------------------------------------------------------------------------------------------------------
    private static final String TABLE_MAGASIN = "Magasin";
    private static final String ID_MAGASIN = "id_magasin";
    private static final String NOM_MAGASIN = "nom_magasin";
    private static final String IMAGE_MAGASIN = "image_magasin";


    //Création de tables
    private static final String CREATE_TABLE_VEND = "CREATE TABLE " + TABLE_VEND
            + "(" + ID_PRODUIT + " INTEGER, "
            + ID_MAGASIN + " INTEGER, "
            + PRIX + " FLOAT, "
            + UNITE + " TEXT NOT NULL, "
            + RAYON + " TEXT, "
            + PROMOTION + " TEXT, "
            + " PRIMARY KEY('id_produit','id_magasin')); ";

    private static final String CREATE_TABLE_LISTE = "CREATE TABLE " + TABLE_LISTE
            + "(" + ID_LISTE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ID_PRODUIT + " INTEGER, "
            + ID_MAGASIN + " INTEGER, "
            + QUANTITEE + " FLOAT, "
            + ACHETE + " FLOAT, "
            //+ " PRIMARY KEY('id_liste','id_produit','id_magasin') "
            + " FOREIGN KEY(" + ID_PRODUIT + ") REFERENCES " + TABLE_VEND + "(" + ID_PRODUIT + "), "
            + " FOREIGN KEY(" + ID_MAGASIN + ") REFERENCES " + TABLE_VEND + "(" + ID_MAGASIN + "));";

    private static final String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT
            + "(" + ID_PRODUIT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CATEGORIE + " INTEGER, "
            + NOM_PRODUIT + " TEXT NOT NULL, "
            + CODE_PRODUIT + " TEXT); ";
            //+ " PRIMARY KEY('id_produit') ";
            //+ " FOREIGN KEY(" + ID_PRODUIT + ") REFERENCES " + TABLE_PRODUIT + "(" + ID_PRODUIT + "), "
            //+ " FOREIGN KEY(" + ID_MAGASIN + ") REFERENCES " + TABLE_MAGASIN + "(" + ID_MAGASIN + "));";

    private static final String CREATE_TABLE_MAGASIN = "CREATE TABLE " + TABLE_MAGASIN
            + "(" + ID_MAGASIN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOM_MAGASIN + " TEXT NOT NULL,"
            + IMAGE_MAGASIN + " INTEGER); ";
            //+ " PRIMARY KEY('id_magasin'));";
            //+ ");";

    //Insertion de données
    final String prod1="INSERT INTO Produit(categorie,nom_produit,code_produit) VALUES('Pain','Pain de mie','|| || |||')";
    final String prod2="INSERT INTO Produit(categorie,nom_produit,code_produit) VALUES('Chocolat','Tablette Milka','|| || |||')";
    final String prod3="INSERT INTO Produit(categorie,nom_produit,code_produit) VALUES('Chips','Chips Barbecus','|| || |||')";

    final String mag1="INSERT INTO Magasin (nom_magasin,image_magasin) VALUES('E.Leclerc','"+R.drawable.leclerc+"')";
    final String mag2="INSERT INTO Magasin (nom_magasin,image_magasin) VALUES('Carrefour market','"+R.drawable.carrefour+"')";
    final String mag3="INSERT INTO Magasin (nom_magasin,image_magasin) VALUES('Intermarché','"+R.drawable.intermarche+"')";
    final String mag4="INSERT INTO Magasin (nom_magasin,image_magasin) VALUES('Auchan','"+R.drawable.auchan+"')";
    final String mag5="INSERT INTO Magasin (nom_magasin,image_magasin) VALUES('Lidl','"+R.drawable.lidl+"')";
    final String mag6="INSERT INTO Magasin (nom_magasin,image_magasin) VALUES('Casino','"+R.drawable.casino+"')";

    final String vendeur1="INSERT INTO Vendeur (id_produit,id_magasin,prix,unite,rayon,promotion) VALUES(1,1,'5','30','Boulangerie','5')";
    final String vendeur2="INSERT INTO Vendeur (id_produit,id_magasin,prix,unite,rayon,promotion) VALUES(2,2,'35','40','Chocolaterie','0')";
    final String vendeur3="INSERT INTO Vendeur (id_produit,id_magasin,prix,unite,rayon,promotion) VALUES(3,3,'35','0','Lays','10')";

    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public void cleaner(SQLiteDatabase db){
        db.execSQL("DROP TABLE " + TABLE_VEND + ";");
        db.execSQL("DROP TABLE " + TABLE_LISTE + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_MAGASIN + ";");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PRODUIT);
        db.execSQL(CREATE_TABLE_VEND);
        db.execSQL(CREATE_TABLE_LISTE);
        db.execSQL(CREATE_TABLE_MAGASIN);
        db.execSQL(prod1);
        db.execSQL(prod2);
        db.execSQL(prod3);
        db.execSQL(mag1);
        db.execSQL(mag2);
        db.execSQL(mag3);
        db.execSQL(mag4);
        db.execSQL(mag5);
        db.execSQL(mag6);
        db.execSQL(vendeur1);
        db.execSQL(vendeur2);
        db.execSQL(vendeur3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_VEND + ";");
        db.execSQL("DROP TABLE " + TABLE_LISTE + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_MAGASIN + ";");
        onCreate(db);
    }

    private final String MY_QUERY = "SELECT categorie, nom_produit, code_produit, prix, unite, rayon, promotion FROM Produit join Vendeur using(id_produit) join Magasin using(id_magasin)";
    public List<Produit> createProduits() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Produit> liste = new LinkedList<>();
        Cursor res = db.rawQuery(MY_QUERY, new String[]{});
        res.moveToFirst();
        while (!res.isAfterLast()) {
            Produit p = new Produit();
            p.setCategorie("Catégorie : "+res.getString(0));
            p.setNom(res.getString(1));
            p.setCodeBarre(res.getString(2));
            if(res.getString(4).equals("0")){
                p.setQuantite("Rupture de stock ");
            }
            else{
                p.setQuantite("En stock : " + res.getString(4) + " unités");
                p.setEmplacement("Au rayon : "+res.getString(5));
                p.setPrix(res.getString(3)+" €");
                if(res.getString(6).equals("0")){
                    p.setPromotion("Aucune promotion");
                }else{
                    p.setPromotion("Promotion de : " + res.getString(6) + " %");
                }
            }
            liste.add(p);
            res.moveToNext();
        }
        return liste;
    }

    private final String MY_QUERY2 = "SELECT nom_magasin,image_magasin FROM Magasin";
    public List<Magasin> createMagasins() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Magasin> liste2 = new LinkedList<>();
        Cursor res = db.rawQuery(MY_QUERY2, new String[]{});
        res.moveToFirst();
        while (!res.isAfterLast()) {
            Magasin m = new Magasin();
            m.setMagasin("Magasin "+res.getString(0));
            m.setImage(res.getInt(1));
            liste2.add(m);
            res.moveToNext();
        }
        return liste2;
    }


}
