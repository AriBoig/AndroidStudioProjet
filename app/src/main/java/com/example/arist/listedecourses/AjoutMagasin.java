package com.example.arist.listedecourses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AjoutMagasin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_magasin);
    }


    public void onClickAjoutMagasin(View view) {
        Intent retour = new Intent();
        TextView zone = (TextView) findViewById(R.id.zone);
        retour.putExtra("NOM_MAGASIN", zone.getText().toString());
        setResult(Activity.RESULT_OK,retour);
        finish();
    }
}
