package com.example.arist.listedecourses;

import android.media.Image;

/**
 * Created by arist on 07/03/2017.
 */

public class Magasin {
    private String Magasin;
    private int Image;

    public Magasin(){

    }

    public Magasin(String magasin, int image) {
        Magasin = magasin;
        Image = image;
    }

    public String getMagasin() {
        return Magasin;
    }

    public void setMagasin(String magasin) {
        Magasin = magasin;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
