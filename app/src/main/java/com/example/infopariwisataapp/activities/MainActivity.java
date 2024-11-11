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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        touristSpots = new ArrayList<>();
        touristSpots.add(new TouristSpot("Gunung Bromo", "Malang, Jawa Timur", "gunung_bromo",
                "Gunung Bromo adalah gunung berapi aktif yang terletak di Taman Nasional Bromo Tengger Semeru, Jawa Timur. Gunung ini memiliki ketinggian 2.329 meter di atas permukaan laut dan menjadi salah satu destinasi wisata alam yang paling terkenal di Indonesia. Dikenal karena pemandangan matahari terbitnya yang memukau, wisatawan dapat menikmati keindahan lautan pasir yang luas di kaki gunung. " +
                        "Setiap tahun, masyarakat Tengger mengadakan Upacara Kasada, yaitu ritual pemujaan kepada Dewa Bromo dengan cara melemparkan hasil bumi ke dalam kawah Bromo. Tradisi ini sangat dihormati oleh masyarakat sekitar dan menjadi daya tarik tersendiri bagi wisatawan yang ingin menyaksikan acara budaya yang langka ini. Suasana magis ini juga menarik banyak wisatawan yang ingin merasakan ketenangan dan keindahan alam, serta menikmati berbagai kegiatan seperti trekking, berkeliling dengan kuda, atau berkemah di kawasan ini. " +
                        "Selain itu, Bromo juga terkenal dengan kawahnya yang mengeluarkan asap putih yang khas, menciptakan pemandangan dramatis yang sangat cocok untuk fotografi alam. Keindahan pemandangan ini menjadi latar belakang yang sempurna bagi para fotografer dan petualang yang datang untuk menikmati alam Indonesia yang masih murni dan asri."));

        touristSpots.add(new TouristSpot("Pantai Pink", "Lombok, Nusa Tenggara Barat", "pantai_pink",
                "Pantai Pink adalah salah satu pantai di dunia yang memiliki pasir berwarna pink. Pantai ini terletak di Desa Sekaroh, Lombok, dan dikenal karena pasirnya yang berwarna pink yang terbentuk dari campuran pasir putih dan serpihan karang merah. Keunikan pantai ini menarik perhatian banyak wisatawan domestik maupun mancanegara, menjadikannya destinasi wisata yang semakin populer. " +
                        "Pantai Pink dikelilingi oleh bukit-bukit hijau yang memberikan pemandangan alam yang spektakuler. Selain menikmati keindahan pantai dengan pasir pink yang eksotis, pengunjung juga bisa menikmati aktivitas snorkeling dan diving, karena perairan sekitar pantai ini memiliki terumbu karang yang masih terjaga keindahannya. Selain itu, pantai ini juga menjadi tempat yang sempurna bagi mereka yang ingin bersantai, berjalan di sepanjang bibir pantai, atau menikmati pemandangan matahari terbenam yang memukau. " +
                        "Pantai Pink juga tidak terlalu ramai, sehingga cocok bagi mereka yang mencari tempat yang lebih tenang dan alami. Keindahan alam yang masih terjaga dan suasana yang damai membuat Pantai Pink menjadi salah satu destinasi wajib bagi para pecinta alam yang ingin menikmati keindahan alam Lombok."));

        touristSpots.add(new TouristSpot("Pantai Gondang Merak", "Jawa Timur", "pantai_gondang_merak",
                "Pantai Gondang Merak terletak di pesisir selatan Jawa Timur. Pantai ini dikenal karena suasananya yang tenang dan alami, membuatnya menjadi tempat yang ideal bagi mereka yang ingin menjauh dari keramaian dan menikmati keindahan alam yang damai. Pasir putih yang lembut, ombak yang tidak terlalu besar, dan laut yang jernih menjadikannya tempat yang sempurna untuk berbagai kegiatan air seperti berenang dan bermain air. " +
                        "Di sekitar pantai, pengunjung dapat menikmati pemandangan alam yang indah, dengan latar belakang perbukitan hijau yang menyegarkan mata. Lokasi yang relatif terpencil membuat Pantai Gondang Merak menjadi tempat yang sempurna untuk bersantai dan menikmati ketenangan. Selain itu, pantai ini juga menawarkan pemandangan matahari terbenam yang sangat indah, yang bisa dinikmati oleh para pengunjung yang datang pada sore hari. " +
                        "Dengan kedamaian yang dimilikinya, Pantai Gondang Merak adalah tempat yang sangat cocok untuk berlibur bersama keluarga, teman, atau pasangan, untuk menikmati keindahan alam Indonesia yang sangat memikat."));

        touristSpots.add(new TouristSpot("Kedung Tumpang", "Tulungagung, Jawa Timur", "kedung_tumpang",
                "Kedung Tumpang adalah sebuah tempat wisata alam yang terletak di Tulungagung, Jawa Timur. Kedung Tumpang terkenal karena memiliki kolam alami yang terbentuk di antara bebatuan besar yang mengalirkan air dari sungai. Kolam-kolam ini memiliki air yang sangat jernih dan berwarna biru kehijauan, menciptakan pemandangan yang memukau bagi setiap pengunjung yang datang. " +
                        "Selain itu, tempat ini juga terkenal karena suasananya yang sangat tenang dan damai, jauh dari keramaian, menjadikannya tempat yang sempurna untuk bersantai, berendam, atau menikmati keindahan alam. Kedung Tumpang juga dikenal sebagai tempat yang instagramable, banyak pengunjung yang datang untuk berfoto di sekitar kolam alami dengan latar belakang alam yang indah. " +
                        "Keindahan alam yang masih alami dan terjaga membuat Kedung Tumpang menjadi tujuan wisata yang semakin populer, terutama bagi mereka yang mencari tempat yang lebih damai dan tidak terlalu ramai."));

        touristSpots.add(new TouristSpot("Pantai Goa Cina", "Malang, Jawa Timur", "pantai_goa_cina",
                "Pantai Goa Cina merupakan pantai yang terletak di pesisir selatan Malang, Jawa Timur. Pantai ini terkenal dengan pemandangan alamnya yang memukau, pasir putih yang lembut, dan air laut yang jernih. Nama Goa Cina diambil dari sebuah gua yang berada di dekat pantai, yang dipercaya sebagai tempat bertapa oleh masyarakat sekitar. Gua ini memiliki keindahan yang unik dan menjadi salah satu daya tarik bagi wisatawan yang datang. " +
                        "Pantai ini juga memiliki ombak yang cukup besar, menjadikannya tempat yang cocok untuk surfing bagi mereka yang menyukai olahraga air. Selain itu, Pantai Goa Cina juga menawarkan pemandangan matahari terbenam yang sangat indah, dengan latar belakang laut yang luas. Tidak hanya menikmati keindahan alamnya, pengunjung juga bisa menikmati cerita legenda lokal yang menyertainya, membuat pengalaman di pantai ini semakin berkesan."));

        touristSpots.add(new TouristSpot("Curug Lawe", "Semarang, Jawa Tengah", "curug_lawe",
                "Curug Lawe adalah air terjun yang terletak di kawasan Semarang, Jawa Tengah. Curug ini dikenal dengan keindahan alamnya yang memukau, dengan air yang jatuh dari ketinggian sekitar 30 meter. Dikelilingi oleh hutan tropis yang lebat, Curug Lawe menawarkan pemandangan alam yang sangat asri dan tenang. " +
                        "Keindahan alamnya yang masih alami membuat air terjun ini menjadi tempat yang sangat cocok bagi pengunjung yang ingin merasakan ketenangan dan kedamaian. Untuk mencapai air terjun ini, pengunjung harus melewati jalur trekking yang menantang, namun setelah sampai, keindahan air terjun dan alam sekitar akan membuat segala usaha yang dikeluarkan terasa sepadan. " +
                        "Selain menikmati pemandangan, pengunjung juga bisa berfoto di sekitar air terjun atau menikmati udara segar yang sangat menyegarkan. Curug Lawe adalah tempat yang sempurna untuk menikmati wisata alam dan berpetualang di alam bebas."));

        touristSpots.add(new TouristSpot("Bukit Moko", "Bandung, Jawa Barat", "bukit_moko",
                "Bukit Moko adalah destinasi wisata yang terletak di Bandung, Jawa Barat, dan terkenal dengan pemandangan indah Kota Bandung dari ketinggian. Bukit ini menjadi tempat favorit bagi para wisatawan yang ingin menikmati pemandangan malam kota yang memukau. Di malam hari, lampu-lampu kota Bandung yang berkelap-kelip terlihat sangat indah, memberikan pengalaman yang sangat romantis. " +
                        "Bukit Moko juga menawarkan suasana yang sejuk dan nyaman, dengan udara pegunungan yang segar. Banyak pengunjung datang untuk menikmati udara segar sambil menikmati pemandangan alam yang menakjubkan. Bukit Moko juga terkenal dengan keberadaan tempat-tempat makan yang menyajikan berbagai jenis makanan enak, cocok untuk dinikmati bersama teman atau keluarga. Selain itu, Bukit Moko juga menjadi tempat yang populer bagi mereka yang ingin berkemah atau sekadar menikmati pemandangan alam di sore hari."));

        touristSpots.add(new TouristSpot("Candi Borobudur", "Magelang, Jawa Tengah", "candi_borobudur",
                "Candi Borobudur adalah candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah. Candi ini dibangun pada abad ke-9 dan merupakan salah satu situs warisan dunia UNESCO yang paling terkenal. Candi Borobudur memiliki sembilan tingkat, masing-masing berisi ukiran-ukiran yang menggambarkan ajaran-ajaran Buddha. Setiap patung dan relief di candi ini memiliki makna filosofis yang mendalam, menjadikannya sebagai tempat ziarah spiritual dan juga destinasi wisata budaya yang sangat penting. " +
                        "Selain keindahan arsitektur dan keunikannya, Candi Borobudur juga menawarkan pemandangan yang sangat indah. Dari puncak candi, pengunjung bisa menikmati pemandangan Gunung Merapi yang mengesankan. Setiap tahun, Candi Borobudur menjadi tuan rumah bagi perayaan Waisak, yang menarik ribuan wisatawan dari berbagai belahan dunia."));

        touristSpots.add(new TouristSpot("Taman Sari", "Yogyakarta, DIY", "taman_sari",
                "Taman Sari adalah bekas taman istana Kesultanan Yogyakarta yang terletak di Yogyakarta. Dikenal juga dengan sebutan Istana Air, Taman Sari dibangun pada abad ke-18 oleh Sultan Hamengkubuwono I sebagai tempat rekreasi, meditasi, dan bahkan tempat perlindungan bagi keluarga kerajaan. Taman ini terdiri dari berbagai bangunan indah, kolam air, dan kanal yang mengalirkan air dari sumber alami. " +
                        "Keindahan arsitektur Taman Sari yang khas Jawa ini menjadikannya tempat yang sangat menarik untuk dijelajahi, dengan banyak pengunjung datang untuk menikmati suasana tenang dan damai sambil mempelajari sejarah Kesultanan Yogyakarta. Salah satu bagian yang paling terkenal adalah kolam-kolam besar yang dulunya digunakan oleh keluarga kerajaan untuk bersantai."));

        touristSpots.add(new TouristSpot("Danau Toba", "Sumatera Utara", "danau_toba",
                "Danau Toba adalah danau vulkanik terbesar di Indonesia dan Asia Tenggara, serta salah satu danau terbesar di dunia. Terletak di ketinggian sekitar 900 meter di atas permukaan laut, Danau Toba terbentuk akibat letusan besar yang terjadi sekitar 75.000 tahun yang lalu. Letusan tersebut menciptakan kaldera besar yang kini menjadi danau yang indah dengan pulau Samosir di tengahnya. " +
                        "Danau Toba tidak hanya terkenal karena keindahan alamnya, tetapi juga karena budaya Batak yang kaya yang berkembang di sekitar danau. Pengunjung dapat menikmati keindahan alam, serta mempelajari sejarah dan tradisi masyarakat Batak, yang dapat ditemukan di berbagai desa yang mengelilingi danau. Aktivitas yang dapat dilakukan di Danau Toba antara lain berlayar, berenang, serta menikmati wisata kuliner khas Batak. Pulau Samosir, yang berada di tengah danau, menawarkan pengalaman yang unik dengan berbagai situs budaya dan alam yang sangat menarik."));





        filteredList = new ArrayList<>(touristSpots);

        // Setup Adapter
        adapter = new TouristSpotAdapter(filteredList, spot -> {
            Log.d(TAG, "Item clicked: " + spot.getName());
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("TOURIST_SPOT", spot); // Mengirim objek touristSpot
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        // Setup SearchView
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
                // Memeriksa apakah nama tempat wisata atau lokasi mengandung query
                if (spot.getName().toLowerCase().contains(query.toLowerCase()) ||
                        spot.getLocation().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(spot);
                }
            }
        }
        adapter.notifyDataSetChanged(); // Memberi tahu adapter untuk memperbarui tampilan
    }
}
