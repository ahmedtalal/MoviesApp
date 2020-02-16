package com.example.moviesapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.PojoModel.Posts;
import com.example.moviesapp.R;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
   private List<Posts> postItems  ;
   private Context context ;

    public PostsAdapter(List<Posts> postItems, Context context) {
        this.postItems = postItems;
        this.context = context;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.posts_list , parent , false) ;
        PostsViewHolder viewHolder =  new PostsViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        Posts posts = postItems.get(position) ;
        holder.userTvID.setText(posts.getId());
        holder.titleTvID.setText(posts.getTitle());
        holder.bodyTvID.setText(posts.getBody());
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder{

        TextView userTvID , titleTvID , bodyTvID ;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            userTvID = itemView.findViewById(R.id.postSIDTV_id) ;
            titleTvID = itemView.findViewById(R.id.postsTitleTV_id) ;
            bodyTvID = itemView.findViewById(R.id.postSBodyTV_id) ;
        }
    }
}
