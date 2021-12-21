package com.ergundenizbuyruk.stajyer.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.ergundenizbuyruk.stajyer.Activitys.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.ergundenizbuyruk.stajyer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GirisFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseUser user;

    public GirisFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user != null) {
            AnaSayfayaGit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_giris, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button ogrenciButton = view.findViewById(R.id.ogrenciButonu);
        Button ogretmenButonu = view.findViewById(R.id.ogretmenButonu);

        ogrenciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentOgrenciKayitaGit(v);
            }
        });

        ogretmenButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentOgretmenKayitaGit(v);
            }
        });
    }

    public void fragmentOgrenciKayitaGit(View view) {
        NavDirections action = GirisFragmentDirections.actionGirisFragmentToOgrenciGirisFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void fragmentOgretmenKayitaGit(View view) {
        NavDirections action = GirisFragmentDirections.actionGirisFragmentToOgretmenGirisFragment();
        Navigation.findNavController(view).navigate(action);

    }

    public void AnaSayfayaGit() {
        Intent intent = new Intent(getContext(), OgrenciAnaSayfa.class);
        intent.putExtra("ePosta", user.getEmail());
        startActivity(intent);
        try {
            getActivity().finish();
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}