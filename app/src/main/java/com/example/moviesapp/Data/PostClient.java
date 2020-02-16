package com.example.moviesapp.Data;

import com.example.moviesapp.PojoModel.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class PostClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/" ;
    private PostsInterface postsInterface ;
    private static PostClient client ;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;
        postsInterface = retrofit.create(PostsInterface.class) ;
    }

    public static PostClient getInstance(){
        if (client == null){
            client =  new PostClient() ;
        }
        return client ;
    }

    public Call<List<Posts>> getPosts(){
        return postsInterface.getPosts() ;
    }
}
