package com.example.planets;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] planetNames = getResources().getStringArray(R.array.planet_names);
        String[] planetDescriptions = getResources().getStringArray(R.array.planet_descriptions);

        int[] planetImages = {
                R.drawable.mercurio,
                R.drawable.venus,
                R.drawable.tierra,
                R.drawable.marte,
                R.drawable.jupiter,
                R.drawable.saturno,
                R.drawable.urano,
                R.drawable.neptuno
        };

        PlanetAdapter adapter = new PlanetAdapter(planetNames, planetDescriptions, planetImages);
        recyclerView.setAdapter(adapter);
    }
}

