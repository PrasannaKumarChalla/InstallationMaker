package com.example.s521942.constellationmaker.Viewer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.s521942.constellationmaker.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewerFragment extends Fragment implements View.OnClickListener {

Button clear;
    public ViewerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_viewer, container, false);
        return v;
    }


    @Override
    public void onClick(View v) {

    }
}
