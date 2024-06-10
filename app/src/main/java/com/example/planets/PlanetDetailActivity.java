package com.example.planets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PlanetDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);

        ImageView imageViewMain = findViewById(R.id.imageViewMain);
        ImageView imageViewExtra1 = findViewById(R.id.imageViewExtra1);
        ImageView imageViewExtra2 = findViewById(R.id.imageViewExtra2);
        TextView textViewDescriptionDetail = findViewById(R.id.textViewDescriptionDetail);
        Button buttonBackToLogin = findViewById(R.id.buttonBackToLogin);
        Button buttonBackToList = findViewById(R.id.buttonBackToList);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String description = intent.getStringExtra("DESCRIPTION");
        int imageMainResId = getResources().getIdentifier(intent.getStringExtra("IMAGE_MAIN"), "drawable", getPackageName());
        int imageExtra1ResId = getResources().getIdentifier(intent.getStringExtra("IMAGE_EXTRA1"), "drawable", getPackageName());
        int imageExtra2ResId = getResources().getIdentifier(intent.getStringExtra("IMAGE_EXTRA2"), "drawable", getPackageName());

        imageViewMain.setImageResource(imageMainResId);
        imageViewExtra1.setImageResource(imageExtra1ResId);
        imageViewExtra2.setImageResource(imageExtra2ResId);
        textViewDescriptionDetail.setText(description);

        buttonBackToLogin.setOnClickListener(v -> {
            Intent loginIntent = new Intent(PlanetDetailActivity.this, LoginActivity.class);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(loginIntent);
            finish();
        });

        buttonBackToList.setOnClickListener(v -> {
            finish();
        });
    }
}

