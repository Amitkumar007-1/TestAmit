package com.example2.writerpad;



import java.util.List;

import Models.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("posts")
    Call<List<User>> getUsers();
}
