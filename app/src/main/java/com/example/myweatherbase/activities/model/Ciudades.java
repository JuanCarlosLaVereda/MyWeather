package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.Listable;

import java.io.Serializable;
import java.util.List;

public enum Ciudades implements Serializable, Listable {

    RIBAROJA("39.5455765", "-0.5828705", "Riba-Roja de Turia", R.mipmap.ic_riba_roja_foreground),
    VALENCIA("39.4079343", "-0.5263206", "Valencia", R.mipmap.ic_valencia_foreground),
    MADRID("40.4380986", "-3.8443457", "Madrid", R.mipmap.ic_madrid_foreground),
    LONDRES("51.5274152", "-0.7253687", "Londres", R.mipmap.ic_londres_foreground),
    GRANADA("37.1809891", "-3.6692121", "Granada", R.mipmap.ic_granada_foreground),
    SIERRA_NEVADA("37.0952326", "-3.4022485", "Sierra Nevada", R.mipmap.ic_sierra_nevada_foreground);

    private String lat;
    private String lon;
    private String nombre;
    private int image;

    Ciudades(String lat, String lon, String nombre, int image){
        this.lat = lat;
        this.lon = lon;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public int getDrawableImage(){
        return image;
    }

    @Override
    public String getDescription(){
        return nombre;
    }
}
