package com.example.arist.listedecourses;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class MagasinFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    ListView mListView;
    public MagasinFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_magasins, container, false);

        mListView = (ListView) v.findViewById(R.id.listeMagasin);
        BaseDeDonnees obj = new BaseDeDonnees(getContext(),"listeMagasin.db", null, 33);
        List<Magasin> magasin = obj.createMagasins();
        AdaptateurMagasin adapter = new AdaptateurMagasin(getContext(), magasin);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                startActivityForResult(new Intent(view.getContext(),AjoutMagasin.class),90);
                            }
                    });
        mListView.setAdapter(adapter);
        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 90:
                if (resultCode == RESULT_OK) {
                    String res = data.getStringExtra("NOM_MAGASIN");

                    Toast t = Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER,0,-100);
                    t.show();
                }
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Liste de magasins");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(null);
    }
}
