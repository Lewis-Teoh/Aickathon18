package com.aichathon.aickathon2018;


import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.aichathon.aickathon2018.com.aichathon.aickathon2018.remote.APIUtils;
import com.aichathon.aickathon2018.com.aichathon.aickathon2018.remote.FileService;
import com.aichathon.aickathon2018.com.aichathon.aickathon2018.model.FileInfo;
import com.squareup.okhttp.MultipartBuilder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;


import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class UploadFragment extends android.app.Fragment {
    FileService fileService;
    Button btnChooseFile;
    Button btnUpload;
    String imagePath;
    Uri imageUri;


    public UploadFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = null;
        view = inflater.inflate(R.layout.fragment_upload, container, false);
        btnChooseFile = (Button) view.findViewById(R.id.btnChooseFile);
        btnUpload = (Button) view.findViewById(R.id.btnUpload);
        fileService = APIUtils.getFileService();

        btnChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,0);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Bitmap bm = null;
                try {
                    bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                String data = android.util.Base64.encodeToString(stream.toByteArray(),android.util.Base64.DEFAULT);
                Call<FileInfo> call = fileService.newphoto(0,data);
                call.enqueue(new Callback<FileInfo>() {
                    @Override
                    public void onResponse(Call<FileInfo> call, Response<FileInfo> response) {
                        Log.i("success",response.code()+" "+response.message());
                        Toast.makeText(getActivity(), "in response", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<FileInfo> call, Throwable t) {
                        Log.i("failed",t.getMessage()+" "+t.getCause());
                    }
                });
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode==RESULT_OK){
            if(data==null){
                Toast.makeText(getActivity(),"Unable to choose image!",Toast.LENGTH_SHORT).show();
                return;

            }
            imageUri = data.getData();
            imagePath = getImagePath(imageUri);
            Log.i("post",imagePath.toString());

        }
    }

    public String getImagePath(Uri selectedImage) {
        Cursor cursor = getActivity().getContentResolver().query(selectedImage, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
        cursor.moveToFirst();

        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        String selectedImagePath = cursor.getString(idx);
        cursor.close();

        return selectedImagePath;
    }


}
