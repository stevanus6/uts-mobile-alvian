package com.example.infopariwisataapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.infopariwisataapp.R;
import com.example.infopariwisataapp.adapters.TouristSpotAdapter;
import com.example.infopariwisataapp.models.TouristSpot;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TouristSpotAdapter adapter;
    private SearchView searchView;
    private List<TouristSpot> touristSpots;
    private List<TouristSpot> filteredList;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewTouristSpots);
        searchView = findViewById(R.id.searchView);

        // Mengatur RecyclerView untuk menampilkan item dalam grid dengan 2 kolom
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Inisialisasi daftar wisata dengan data
        touristSpots = new ArrayList<>();
        touristSpots.add(new TouristSpot("Gunung Bromo", "Malang, Jawa Timur", "gunung_bromo", "Gunung Bromo adalah gunung berapi aktif yang terkenal dengan pemandangan sunrise yang memukau. Terletak di Taman Nasional Bromo Tengger Semeru, wisatawan bisa menikmati pemandangan yang luar biasa di atas lautan pasir yang luas."));
        touristSpots.add(new TouristSpot("Pantai Pink", "Lombok, Nusa Tenggara Barat", "pantai_pink", "Pantai ini dikenal dengan pasirnya yang berwarna pink unik, yang berasal dari serpihan karang merah yang tercampur dengan pasir putih alami. Pantai Pink memberikan pengalaman unik dan pemandangan laut yang indah, menjadikannya destinasi yang wajib dikunjungi di Lombok."));
        touristSpots.add(new TouristSpot("Pantai Gondang Merak", "Jawa Timur", "pantai_gondang_merak", "Pantai Gondang Merak menawarkan suasana yang tenang dan alami, sempurna bagi mereka yang ingin menikmati ketenangan dengan pemandangan alam yang memanjakan mata. Pantai ini memberikan suasana yang menyegarkan, jauh dari keramaian, ideal untuk bersantai."));
        touristSpots.add(new TouristSpot("Kedung Tumpang", "Tulungagung, Jawa Timur", "kedung_tumpang", "Kedung Tumpang adalah objek wisata alam berupa kolam alami yang terbentuk di antara bebatuan besar. Dengan air jernih berwarna biru kehijauan, tempat ini memberikan suasana alam yang damai dan menyenangkan untuk berendam atau sekadar menikmati keindahan alam."));
        touristSpots.add(new TouristSpot("Pantai Goa Cina", "Malang, Jawa Timur", "pantai_goa_cina", "Pantai Goa Cina dikenal dengan keindahan pemandangannya dan ombak yang cukup besar. Pantai ini juga memiliki cerita legenda lokal, yang menambah daya tarik bagi wisatawan yang tertarik dengan sejarah dan budaya lokal."));
        touristSpots.add(new TouristSpot("Curug Lawe", "Semarang, Jawa Tengah", "curug_lawe", "Curug Lawe adalah air terjun yang menawarkan suasana asri dan udara yang sejuk, menjadikannya tempat yang ideal untuk berwisata alam. Air terjun ini berada di tengah hutan yang rimbun, membuatnya terasa lebih eksotis dan menenangkan."));
        touristSpots.add(new TouristSpot("Bukit Moko", "Bandung, Jawa Barat", "bukit_moko", "Bukit Moko adalah destinasi favorit bagi wisatawan yang ingin menikmati pemandangan malam Kota Bandung yang memukau dari ketinggian. Di malam hari, pemandangan kota yang berkelap-kelip terlihat sangat indah, memberikan pengalaman yang romantis dan memikat."));
        touristSpots.add(new TouristSpot("Candi Borobudur", "Magelang, Jawa Tengah", "candi_borobudur", "Sebagai candi Buddha terbesar di dunia, Candi Borobudur adalah situs yang sangat bersejarah dan terkenal di dunia. Setiap ukiran pada candi ini menceritakan kisah-kisah penting dari ajaran Buddha, menjadikannya tujuan wisata yang tak hanya indah, tetapi juga penuh nilai sejarah dan spiritual."));
        touristSpots.add(new TouristSpot("Taman Sari", "Yogyakarta, DIY", "taman_sari", "Taman Sari adalah bekas taman istana Kesultanan Yogyakarta yang dulunya digunakan sebagai tempat rekreasi, meditasi, dan perlindungan bagi keluarga kerajaan. Dengan arsitektur yang indah dan sejarah yang mendalam, tempat ini sangat menarik bagi para pengunjung yang ingin belajar lebih banyak tentang sejarah Jawa."));
        touristSpots.add(new TouristSpot("Danau Toba", "Sumatera Utara", "danau_toba", "Danau Toba adalah danau vulkanik terbesar di Indonesia dan Asia Tenggara, serta salah satu yang terbesar di dunia. Terletak di ketinggian dan dikelilingi oleh pegunungan, danau ini menawarkan pemandangan alam yang luar biasa. Pulau Samosir yang berada di tengah danau ini menambah daya tarik bagi para wisatawan."));


        filteredList = new ArrayList<>(touristSpots);

        adapter = new TouristSpotAdapter(filteredList, spot -> {
            Log.d(TAG, "Item clicked: " + spot.getName());
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("TOURIST_SPOT", spot); // Mengirim objek touristSpot
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        setupSearchView();
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String query) {
        if (query.isEmpty()) {
            filteredList.clear();
            filteredList.addAll(touristSpots);
        } else {
            filteredList.clear();
            for (TouristSpot spot : touristSpots) {
                if (spot.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(spot);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
