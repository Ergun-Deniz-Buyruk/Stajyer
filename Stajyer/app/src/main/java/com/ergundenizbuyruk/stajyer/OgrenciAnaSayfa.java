package com.ergundenizbuyruk.stajyer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OgrenciAnaSayfa extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_ana_sayfa);

        auth = FirebaseAuth.getInstance();
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
        } else if (item.getItemId() == R.id.ogrenci_cikis) {

            auth.signOut();

            Intent intentToMain = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentToMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}