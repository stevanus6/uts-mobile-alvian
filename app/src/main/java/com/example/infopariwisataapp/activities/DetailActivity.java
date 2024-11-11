package com.example.infopariwisataapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.infopariwisataapp.R;
import com.example.infopariwisataapp.models.TouristSpot;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textName, textLocation, textDescription;
    private Button btnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi komponen layout
        imageView = findViewById(R.id.imageViewDetail);
        textName = findViewById(R.id.textName);
        textLocation = findViewById(R.id.textLocation);
        textDescription = findViewById(R.id.textDescription);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        // Mendapatkan data TouristSpot dari intent
        TouristSpot touristSpot = (TouristSpot) getIntent().getSerializableExtra("TOURIST_SPOT");

        if (touristSpot != null) {
            textName.setText(touristSpot.getName());
            textLocation.setText(touristSpot.getLocation());
            textDescription.setText(touristSpot.getDescription());

            int imageResId = getResources().getIdentifier(
                    touristSpot.getImageName(), "drawable", getPackageName());
            imageView.setImageResource(imageResId != 0 ? imageResId : R.drawable.default_image);
        }

        // Aksi tombol kembali ke MainActivity
        btnBackToMain.setOnClickListener(v -> {
            // Intent untuk kembali ke MainActivity
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent); // Memulai MainActivity
            finish(); // Menutup DetailActivity agar tidak kembali ke sini dengan tombol back
        });
    }
}
