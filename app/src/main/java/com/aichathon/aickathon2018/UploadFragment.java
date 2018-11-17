package com.aichathon.aickathon2018;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class UploadFragment extends android.app.Fragment {

    private static final int IMAGE_REQUEST = 1;
    private String currentImagePath = null;
    private Button upload_button;
    private Button capture_button;

    public UploadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_album, container, false);
        capture_button = (Button) view.findViewById(R.id.capture_button);
        capture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage(v);
            }
        });

        return view;
    }

    public void captureImage(View view){

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getActivity().getPackageManager())!=null){
            File imageFile=null;
            try{
                imageFile = getImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(imageFile!=null){
                Uri imageUri = FileProvider.getUriForFile(getActivity(),"com.example.android.fileprovider", imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(cameraIntent, IMAGE_REQUEST);
            }
        }

    }

    public void displayImage(View view){
        Intent intent = new Intent(getActivity(), DisplayImage.class);
        intent.putExtra("image_path", currentImagePath);
        startActivity(intent);


    }


    private File getImageFile() throws IOException{
        String timestamp = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(new Date());
        String imageName = "jpg" + timestamp +"_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File imageFile = File.createTempFile(imageName, ".jpg",storageDir);
        currentImagePath = imageFile.getAbsolutePath();
        return imageFile;
    }


}
