package com.ergundenizbuyruk.stajyer.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.ergundenizbuyruk.stajyer.Classes.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.ergundenizbuyruk.stajyer.R;
import com.ergundenizbuyruk.stajyer.databinding.FragmentOgretmenKayitBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class OgretmenKayitFragment extends Fragment {

    private FragmentOgretmenKayitBinding binding;
    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseStorage firebaseStorage;
    private Ogretmen ogretmen;

    public OgretmenKayitFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOgretmenKayitBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        Button kayitOlButonu = view.findViewById(R.id.kayitOlButonu);
        kayitOlButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adSoyad = binding.adSoyadEditText.getText().toString();
                String tcNo = binding.tcEditText.getText().toString();
                String eMail = binding.epostaEditText.getText().toString();
                String sifre = binding.sifreEditText.getText().toString();

                // e-posta veya email bos olamaz o sebeple basta kontrol et.
                if (eMail.equals("") || sifre.equals("")
                        || adSoyad.equals("") || tcNo.equals("")) {
                    Toast.makeText(getContext(), R.string.email_veya_sifre_bos_toasti,
                            Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(eMail, sifre)//Kullaniciyi kaydet.
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {

                                    ogretmen = new Ogretmen(adSoyad, tcNo, eMail, sifre, null);
                                    firebaseFirestore.collection("Ogretmenler")
                                            .document(eMail)
                                            .set(ogretmen)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            //Basarili olursa toast mesaji goster ve bastaki giris fragmentine don.
                                            Toast.makeText(getContext(),
                                                    R.string.ogretmen_basarili_kayit_yapildi, Toast.LENGTH_SHORT).show();
                                            GirisFragmentaGit(v);
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Basarisiz olursa kullanicinin anlayabilecegi dilden Toast mesaji goster.
                                            Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Basarisiz olursa kullanicinin anlayabilecegi dilden Toast mesaji goster.
                            Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
    public void GirisFragmentaGit(View view) {
        NavDirections action = OgretmenKayitFragmentDirections.actionOgretmenKayitFragmentToGirisFragment();
        Navigation.findNavController(view).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}