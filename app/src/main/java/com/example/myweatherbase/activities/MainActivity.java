package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Ciudades;
import com.example.myweatherbase.activities.model.Root;


public class MainActivity extends AppCompatActivity{

    private ImageView imagenCiudad;
    private Spinner spinnerCiudades;
    private Button buttonPrevision;
    private Root root;
    private Ciudades ciudad;
    private ImageButton tema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenCiudad = findViewById(R.id.imageCiudad);
        spinnerCiudades = findViewById(R.id.spinnerCiudades);
        buttonPrevision = findViewById(R.id.buttonPrevision);
        imagenCiudad = findViewById(R.id.imageCiudad);
        tema = findViewById(R.id.imageButtonLuna);

        ArrayAdapter<Ciudades> adaptadorSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Ciudades.values());
        spinnerCiudades.setAdapter(adaptadorSpinner);

        spinnerCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                ciudad = (Ciudades)adapterView.getSelectedItem();
                imagenCiudad.setImageResource(ciudad.getDrawableImage());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonPrevision.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityCity.class);
            intent.putExtra("Ciudad", ciudad);
            startActivity(intent);
        });
    }

}