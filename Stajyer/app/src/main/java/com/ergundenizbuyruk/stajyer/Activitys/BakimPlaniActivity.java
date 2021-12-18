package com.ergundenizbuyruk.stajyer.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ergundenizbuyruk.stajyer.Classes.BakimPlani;
import com.ergundenizbuyruk.stajyer.R;
import com.ergundenizbuyruk.stajyer.databinding.ActivityBakimPlaniBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BakimPlaniActivity extends AppCompatActivity {

    private ActivityBakimPlaniBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth auth;
    private FirebaseUser user;

    private String ePosta;

    private BakimPlani bakimPlani;
    private String hastaAdi;
    private String hastaCinsiyet;
    private String hastaMedeniDurum;
    private String hastaMeslegi;
    private String hastaYatisTarihi;
    private String hastaGeldigiYer;
    private String hastaTibbiTani;
    private String hastaYas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBakimPlaniBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        firebaseFirestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        ePosta = user.getEmail();

        binding.kaydetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextleriAl();

                bakimPlani = new BakimPlani(hastaAdi, hastaCinsiyet, hastaMedeniDurum,
                        hastaMeslegi, hastaYatisTarihi,
                        hastaGeldigiYer, hastaTibbiTani, hastaYas);

                firebaseFirestore
                        .collection("Ogrenciler/" + ePosta + "/BakimPlanlari")
                        .add(bakimPlani).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),
                                R.string.bakim_plani_eklendi, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), OgrenciAnaSayfa.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),
                                e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void editTextleriAl() {
        hastaAdi = binding.hastaAdiEditText.getText().toString();
        hastaCinsiyet = binding.hastaCinsyetEditText.getText().toString();
        hastaMedeniDurum = binding.hastaMedeniDurumEditText.getText().toString();
        hastaMeslegi = binding.hastaMeslegiEditText.getText().toString();
        hastaYatisTarihi = binding.yatisTarihiEditText.getText().toString();
        hastaGeldigiYer = binding.hastaGeldigiYerEditText.getText().toString();
        hastaTibbiTani = binding.hastaTibbiTaniEditText.getText().toString();
        hastaYas = binding.hastaYasiEditText.getText().toString();
    }
}