package com.ergundenizbuyruk.stajyer;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OgretmenGirisFragment extends Fragment {

    public OgretmenGirisFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ogretmen_giris, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button girisButonu = view.findViewById(R.id.girisButonu);
        Button kayitOlaGitButonu = view.findViewById(R.id.kayitOlaGitButonu);

        girisButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girisYap(v);
            }
        });

        kayitOlaGitButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitOlaGit(v);
            }
        });

    }
    public void girisYap(View view) {
        Intent intent = new Intent(view.getContext(), OgretmenAnaSayfa.class);
        startActivity(intent);
    }

    public void kayitOlaGit(View view) {
        NavDirections action = OgretmenGirisFragmentDirections.actionOgretmenGirisFragmentToOgretmenKayitFragment();
        Navigation.findNavController(view).navigate(action);
    }
}