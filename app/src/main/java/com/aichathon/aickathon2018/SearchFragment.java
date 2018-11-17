package com.aichathon.aickathon2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends android.app.Fragment {

    private ImageButton cameraVector;
    private ImageView uploadVector;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        // Inflate the layout for this fragment
        cameraVector = (ImageButton) view.findViewById(R.id.cameraVector);
        cameraVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CLICK", "Clicked!");
            }
        });
        return view;
    }


}
