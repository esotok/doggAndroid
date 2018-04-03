package com.example.capacitacion7.doggbreedandroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by capacitacion7 on 16-03-18.
 */

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.ViewHolder> {

    private Breed[] breeds;
    private AdapterView.OnItemClickListener onItemClickListener;
    public BreedAdapter(AdapterView.OnItemClickListener onItemClickListener, Breed[] breeds) {
        this.onItemClickListener = onItemClickListener;
        this.breeds = breeds;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_breeds, parent, false);

        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.textViewNameBreed.setText(breeds[position].getLast_price().toString());

        holder.textViewNameBreed.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onItemClickListener.onItemClick(null, view, position, view.getId());
            }
        });
    }

    @Override public int getItemCount() {
        //return breeds.length;
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNameBreed;

        public ViewHolder(View itemView) {

            super(itemView);
            textViewNameBreed = itemView.findViewById(R.id.textViewNameBreed);
        }
    }
}
