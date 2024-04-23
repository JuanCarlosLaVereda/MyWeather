package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityMoreInfo extends AppCompatActivity {

    private TextView txtView ;
    private TextView textViewDay;
    private TextView textViewDayOfWeek;
    private ImageView imageView;
    private Button botonVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        Bundle extras = getIntent().getExtras();
        List list = (List)extras.get("Data");


        txtView = findViewById(R.id.txtView);
        textViewDay = findViewById(R.id.textViewDay);
        textViewDayOfWeek = findViewById(R.id.textViewDayOfWeek);
        imageView = findViewById(R.id.imageView);
        botonVolver = findViewById(R.id.buttonVolverMoreInfo);

        txtView.setText(list.weather.get(0).description);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + list.weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

        Date date = new Date((long)list.dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
        textViewDayOfWeek.setText(dateDayOfWeek.format(date));
        textViewDay.setText(dateDay.format(date));

        botonVolver.setOnClickListener(view -> {
            finish();
        });

    }

}
