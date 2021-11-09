package com.ergundenizbuyruk.stajyer;

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

public class OgrenciKayitFragment extends Fragment {

    public OgrenciKayitFragment() {
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
        return inflater.inflate(R.layout.fragment_ogrenci_kayit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button kayitOlButonu = view.findViewById(R.id.kayitOlButonu);
        kayitOlButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GirisFragmentaGit(v);
            }
        });
    }

    public void GirisFragmentaGit(View view) {
        NavDirections action = OgrenciKayitFragmentDirections
                .actionOgrenciKayitFragmentToGirisFragment();
        Navigation.findNavController(view).navigate(action);
    }
}