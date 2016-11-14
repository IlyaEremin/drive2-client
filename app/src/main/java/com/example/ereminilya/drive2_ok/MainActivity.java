package com.example.ereminilya.drive2_ok;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ereminilya.drive2_ok.main.models.MainResponse;
import com.example.ereminilya.drive2_ok.models.Post;
import com.example.ereminilya.drive2_ok.utils.Deps;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView uiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uiList = (RecyclerView) findViewById(R.id.rv);
        uiList.setLayoutManager(new LinearLayoutManager(this));
        uiList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = 16;
            }
        });

        Deps.providesApi().getMain()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<MainResponse>() {
                @Override public void call(final MainResponse response) {
                    response.makeProperImagesUrls();

                    uiList.setAdapter(new RecyclerView.Adapter<PostHolder>() {

                        @Override
                        public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                            return new PostHolder(LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_post, parent, false));
                        }

                        @Override
                        public void onBindViewHolder(PostHolder holder, int position) {
                            holder.show(response.getTopPosts().get(position));
                        }

                        @Override public int getItemCount() {
                            return response.getTopPosts().size();
                        }
                    });
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {
                    Log.d(TAG, "call() called with: throwable = [" + throwable + "]");
                }
            });
    }

    public static class PostHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView  textView;

        public PostHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
        }

        public void show(Post post) {
            Glide.with(itemView.getContext()).load(post.getPhotos().get(0).getImages().get(0).getUrl())
                .into(imageView);
            textView.setText(post.getText());
        }

    }


}