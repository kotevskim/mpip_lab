package com.example.martin.mpip_lab;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import io.reactivex.subjects.PublishSubject;

/**
 * Created by martin on 10/31/17.
 */

public class SimpleRvAdapter extends RecyclerView.Adapter<SimpleRvAdapter.ViewHolder> {
    private String[] dataSource;

    private final PublishSubject<String> onClickSubject = PublishSubject.create();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(TextView itemView) {
            super(itemView);
            mTextView = itemView;
        }
    }

    public SimpleRvAdapter(String[] dataArgs) {
        dataSource = dataArgs;
    }

    @Override
    public SimpleRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = new TextView(parent.getContext());
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SimpleRvAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }
}
