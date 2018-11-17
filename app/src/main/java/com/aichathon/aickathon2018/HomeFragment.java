package com.aichathon.aickathon2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends android.app.Fragment {

    private TextView profile_name;
    private TextView your_colour;
    private TextView your_style;
    private User user;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        try {
//            InputStream inputStream = getActivity().getAssets().open("user1.json");
//            Reader reader = new InputStreamReader(inputStream, "UTF-8");
//            user = new Gson().fromJson(reader, User.class);
//            Log.d("JSON", user.top_colors[0]);
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//        //Name
//        profile_name = (TextView) view.findViewById(R.id.profile_name);
//        profile_name.setText(user.name);
//
//        //Top 3 colors
//        String[] colours = user.top_colors;
//        String your_colours = "Your colours:\n";
//        for(String s: colours){
//            your_colours += (s + "\n");
//        }
//        your_colour = (TextView) view.findViewById(R.id.your_colour);
//        your_colour.setText(your_colours);
//
//        //Top 3 style
//        String[] styles = user.top_styles;
//        String your_styles = "Your styles:\n";
//        for(String s: styles){
//            your_styles += (s + "\n");
//        }
//        your_style = (TextView) view.findViewById(R.id.your_style);
//        your_style.setText(your_styles);

        return view;
    }

}
