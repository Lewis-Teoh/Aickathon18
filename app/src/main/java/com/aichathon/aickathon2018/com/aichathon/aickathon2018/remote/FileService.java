package com.aichathon.aickathon2018.com.aichathon.aickathon2018.remote;

import com.aichathon.aickathon2018.com.aichathon.aickathon2018.model.Person;

import java.io.File;

import okhttp3.RequestBody;
import retrofit2.Call;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface FileService {
    @FormUrlEncoded
    @POST("newphoto")
    Call<Person> newphoto(@Field("user_id") int user_id, @Field("img_data") String img_data);

}

