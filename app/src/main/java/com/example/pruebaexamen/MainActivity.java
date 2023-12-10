package com.example.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Importación correcta para Toolbar
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LandscapeItemAdapter adapter;
    private List<LandscapeItem> landscapeItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Necesitas tener una instancia de androidx Toolbar para esto

        recyclerView = findViewById(R.id.recyclerView);
        landscapeItems = getLandscapeItems(); // Implementa este método para obtener datos
        adapter = new LandscapeItemAdapter(this, landscapeItems);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // Ajusta el número de columnas si es necesario
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // Intent para iniciar SecondActivity
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }

    private List<LandscapeItem> getLandscapeItems() {
        List<LandscapeItem> items = new ArrayList<>();
        items.add(new LandscapeItem(R.drawable.image1, "Landscape 1"));
        items.add(new LandscapeItem(R.drawable.image2, "Landscape 2"));
        items.add(new LandscapeItem(R.drawable.image3, "Landscape 3"));
        items.add(new LandscapeItem(R.drawable.image4, "Landscape 4"));
        items.add(new LandscapeItem(R.drawable.image5, "Landscape 5"));
        items.add(new LandscapeItem(R.drawable.image6, "Landscape 6"));
        items.add(new LandscapeItem(R.drawable.image7, "Landscape 7"));
        items.add(new LandscapeItem(R.drawable.image8, "Landscape 8"));
        items.add(new LandscapeItem(R.drawable.image9, "Landscape 9"));


        return items;
    }

}
