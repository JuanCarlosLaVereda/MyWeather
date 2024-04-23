package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Ciudades;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;

public class ActivityCity extends BaseActivity implements CallInterface, View.OnClickListener{

    private RecyclerView recycler;
    private TextView nombreCiudad;
    private Button botonVolver;
    private Ciudades ciudad;
    private Root root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        recycler = findViewById(R.id.recyclerViewCity);
        nombreCiudad = findViewById(R.id.nombreCiudadActivity);
        botonVolver = findViewById(R.id.botonVolver);

        Bundle extras = getIntent().getExtras();
        ciudad = (Ciudades)extras.get("Ciudad");



        botonVolver.setOnClickListener(view -> {
            finish();
        });

        showProgress();
        executeCall(this);
    }


    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class, "&lat=" + ciudad.getLat()+ "&lon=" + ciudad.getLon());
    }

    @Override
    public void doInUI() {
        hideProgress();
        nombreCiudad.setText(ciudad.getDescription());
        AdaptadorRecyclerView adaptador = new AdaptadorRecyclerView(this, root.list);
        adaptador.setOnClickListener(this);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onClick(View view) {
        List list = root.list.get(recycler.getChildAdapterPosition(view));
        Intent intent = new Intent(this, ActivityMoreInfo.class);
        intent.putExtra("Data", list);
        startActivity(intent);
    }
}
