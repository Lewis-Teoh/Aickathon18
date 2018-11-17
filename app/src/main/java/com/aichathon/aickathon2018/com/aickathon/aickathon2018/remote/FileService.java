package com.aichathon.aickathon2018.com.aickathon.aickathon2018.remote;

import com.aichathon.aickathon2018.com.aickathon.aickathon2018.model.Person;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface FileService {
    @FormUrlEncoded
    @POST("newphoto")
    Call<Person> newphoto(@Field("user_id") int user_id, @Field("img_data") String img_data);

    @FormUrlEncoded
    @POST("getuser")
    Call<Person> getuser(@Field("user_id") int user_id);
}