package com.ergundenizbuyruk.stajyer.Activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.ergundenizbuyruk.stajyer.Adapter.BakimPlanlariAdapter;
import com.ergundenizbuyruk.stajyer.Classes.*;
import com.ergundenizbuyruk.stajyer.R;
import com.ergundenizbuyruk.stajyer.databinding.ActivityOgrenciAnaSayfaBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class OgrenciAnaSayfa extends AppCompatActivity {

    private ActivityOgrenciAnaSayfaBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<BakimPlani> bakimPlaniArrayList;
    private String ePosta;
    private BakimPlanlariAdapter bakimPlanlariAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOgrenciAnaSayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        ePosta = user.getEmail();

        bakimPlaniArrayList = new ArrayList<>();
        getBakimPlani();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bakimPlanlariAdapter = new BakimPlanlariAdapter(bakimPlaniArrayList);
        binding.recyclerView.setAdapter(bakimPlanlariAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_ogrenci, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.bakim_plani_ekle) {
            // Bakim planı dolduracagi aktiviteye gitsin.

            Intent intentToBakimPlani = new Intent(getApplicationContext(), BakimPlaniActivity.class);
            intentToBakimPlani.putExtra("ePosta", ePosta);
            startActivity(intentToBakimPlani);

        } else if (item.getItemId() == R.id.ogrenci_cikis) {

            auth.signOut();

            Intent intentToMain = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentToMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getBakimPlani() {
        firebaseFirestore
                .collection("Ogrenciler/" + ePosta + "/BakimPlanlari")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(),
                                    error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }

                        if (value != null) {
                            for (DocumentSnapshot snapshot : value.getDocuments()) {
                                Map<String, Object> data = snapshot.getData();

                                String hastaAdi = (String) data.get("hastaAdi");
                                String hastaCinsiyet = (String) data.get("hastaCinsiyet");
                                String hastaMedeniDurum = (String) data.get("hastaMedeniDurum");
                                String hastaMeslegi =  (String) data.get("hastaMeslegi");
                                String hastaYatisTarihi =  (String) data.get("hastaYatisTarihi");
                                String hastaGeldigiYer = (String) data.get("hastaGeldigiYer");
                                String hastaTibbiTani = (String) data.get("hastaTibbiTani");
                                String hastaYas = (String) data.get("hastaYas");

                                BakimPlani bakimPlani = new BakimPlani(hastaAdi, hastaCinsiyet,
                                        hastaMedeniDurum, hastaMeslegi,
                                        hastaYatisTarihi, hastaGeldigiYer,
                                        hastaTibbiTani, hastaYas);

                                bakimPlaniArrayList.add(bakimPlani);
                            }
                            bakimPlanlariAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}