package com.bignerdranch.android.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;

    // access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder (View atv) {
            super(atv);                 // ??? почему нужна ссылка на родительский объект
            this.mTextView = (TextView) atv.findViewById(R.id.textView);
            // this.mTextView = atv; ??? не сработало как в документации
        }
    }

    // provide a suitable constructor
    public MyAdapter (String [] mDataset) {
        this.mDataset = mDataset;
    }

    // сначала запрашивается общее количество объектов в массиве
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // create new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Creaye a new view
        View v = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.my_card_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // replace the context of a view
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // get element from DataSet
        // replace the Content of the view with that element
        holder.mTextView.setText(mDataset[position]);
    }
}