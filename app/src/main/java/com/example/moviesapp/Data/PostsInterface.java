package com.example.moviesapp.Data;

import com.example.moviesapp.PojoModel.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {

    @GET("posts")
    public Call<List<Posts>> getPosts() ;
}
