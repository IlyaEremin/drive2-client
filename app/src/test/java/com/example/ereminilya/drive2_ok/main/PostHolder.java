package com.example.ereminilya.drive2_ok.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ereminilya.drive2_ok.R;
import com.example.ereminilya.drive2_ok.models.Post;

/**
 * Created by ereminilya on 15/11/16.
 */
public class PostHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView  textView;

    public PostHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    public void show(Post post) {
        Glide.with(itemView.getContext()).load(post.getPhotos().get(0).getImages()
            .get(0).getUrl())
            .into(imageView);
        textView.setText(post.getText());
    }

}