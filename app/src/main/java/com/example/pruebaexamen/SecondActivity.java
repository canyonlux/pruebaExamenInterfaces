package com.example.pruebaexamen;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Configurar TextView con fuente personalizada
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.salty_oceano);
        textViewTitle.setTypeface(typeface);

        // Configurar ChipGroup con los Chips
        ChipGroup chipGroup = findViewById(R.id.chipGroup);
        chipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            Chip chip = findViewById(checkedId);
            if (chip != null) {
                Toast.makeText(SecondActivity.this, chip.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar Spinner
        Spinner spinnerExperiences = findViewById(R.id.spinnerExperiences);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.experience_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExperiences.setAdapter(adapter);

        // Configurar FloatingActionButton para volver a MainActivity
        FloatingActionButton fabBack = findViewById(R.id.fab_back);
        fabBack.setOnClickListener(view -> finish());
    }
}
