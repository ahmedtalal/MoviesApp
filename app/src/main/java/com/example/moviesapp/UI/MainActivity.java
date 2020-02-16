package com.example.moviesapp.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.Adapters.PostsAdapter;
import com.example.moviesapp.PojoModel.Posts;
import com.example.moviesapp.R;
import com.example.moviesapp.ViewModels.PostViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.post_toolbar_id)
    Toolbar postToolbarId;
    @BindView(R.id.posts_recycler_id)
    RecyclerView postsRecyclerId;

    PostViewModel postViewModel ;
    PostsAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class) ;
        LinearLayoutManager manager =  new LinearLayoutManager(MainActivity.this , LinearLayoutManager.VERTICAL , false) ;
        manager.setStackFromEnd(false);
        postsRecyclerId.setLayoutManager(manager);
        postViewModel.retrievePosts();

        postViewModel.postMutableLiveData.observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                adapter =  new PostsAdapter(posts , getApplicationContext()) ;
                postsRecyclerId.setAdapter(adapter);
            }
        });
    }
}
