package com.example.arist.listedecourses;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ServeurFragment extends Fragment {

    public ServeurFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_serveur, container, false);

        Button btnCheckFalAction = (Button) v.findViewById(R.id.boutonServeur);
        btnCheckFalAction.setOnClickListener((View.OnClickListener) this);
        return v;
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
       /* switch(v.getId()){

            case R.id.boutonServeur :
                EditText email = (EditText)getActivity().findViewById();
                EditText password = (EditText)getActivity().findViewById();
                String emailValide = email.getText().toString();
                String passwordValide = password.getText().toString();

        }*/
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Connexion");
    }

}
