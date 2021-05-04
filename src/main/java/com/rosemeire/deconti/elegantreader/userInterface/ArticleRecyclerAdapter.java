package com.rosemeire.deconti.elegantreader.userInterface;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.rosemeire.deconti.elegantreader.R;
import com.rosemeire.deconti.elegantreader.database.ArticleLoader;

/* ************************************************************************************************/
/* **** Recycler view adapter
/* ************************************************************************************************/

class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private final ImageLoader imageLoader;
    private final Cursor cursor;
    private final ArticleClickListener articleClickListener;

    public interface ArticleClickListener {
        void onArticleClicked(long itemId);
    }

    ArticleRecyclerAdapter(ImageLoader imageLoader, Cursor cursor, ArticleClickListener articleClickListener) {
        this.imageLoader = imageLoader;
        this.cursor = cursor;
        this.articleClickListener = articleClickListener;
    }

    @Override
    public long getItemId(int position) {
        cursor.moveToPosition(position);
        return cursor.getLong(ArticleLoader.Query._ID);
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.list_item_article, parent, false);
        return new ArticleViewHolder(view, imageLoader,
                adapterPosition -> articleClickListener.onArticleClicked(getItemId(adapterPosition)));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.bind(cursor);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
}
