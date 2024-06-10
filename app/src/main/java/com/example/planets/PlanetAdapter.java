package com.example.planets;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private final String[] planetNames;
    private final String[] planetDescriptions;
    private final int[] planetImages;

    public PlanetAdapter(String[] planetNames, String[] planetDescriptions, int[] planetImages) {
        this.planetNames = planetNames;
        this.planetDescriptions = planetDescriptions;
        this.planetImages = planetImages;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        String name = planetNames[position];
        String description = planetDescriptions[position];
        int image = planetImages[position];

        holder.textViewName.setText(name);
        holder.imageView.setImageResource(image);

        holder.itemView.setOnClickListener(v -> {
            Context context = holder.itemView.getContext();
            Intent intent = new Intent(context, PlanetDetailActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("DESCRIPTION", description);
            intent.putExtra("IMAGE_MAIN", context.getResources().getStringArray(R.array.planet_images_main)[position]);
            intent.putExtra("IMAGE_EXTRA1", context.getResources().getStringArray(R.array.planet_images_extra1)[position]);
            intent.putExtra("IMAGE_EXTRA2", context.getResources().getStringArray(R.array.planet_images_extra2)[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return planetNames.length;
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
