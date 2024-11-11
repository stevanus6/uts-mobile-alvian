package com.example.infopariwisataapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.infopariwisataapp.R;
import com.example.infopariwisataapp.models.TouristSpot;
import java.util.List;

public class TouristSpotAdapter extends RecyclerView.Adapter<TouristSpotAdapter.ViewHolder> {

    private final List<TouristSpot> touristSpots;
    private final OnSpotClickListener listener;

    public TouristSpotAdapter(List<TouristSpot> touristSpots, OnSpotClickListener listener) {
        this.touristSpots = touristSpots;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tourist_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TouristSpot spot = touristSpots.get(position);
        holder.textName.setText(spot.getName());
        holder.textLocation.setText(spot.getLocation());

        int imageResId = holder.itemView.getContext().getResources().getIdentifier(
                spot.getImageName(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageThumbnail.setImageResource(imageResId);

        holder.itemView.setOnClickListener(v -> listener.onSpotClick(spot));
    }

    @Override
    public int getItemCount() {
        return touristSpots.size();
    }

    public interface OnSpotClickListener {
        void onSpotClick(TouristSpot spot);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textLocation;
        ImageView imageThumbnail;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textLocation = itemView.findViewById(R.id.textLocation);
            imageThumbnail = itemView.findViewById(R.id.imageThumbnail);
        }
    }
}
