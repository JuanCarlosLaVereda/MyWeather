package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<List> lista;
    private View.OnClickListener onClickListener;

    public AdaptadorRecyclerView(Context context, ArrayList<List> lista){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.simple_element, parent, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + lista.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, holder.imagenIcon);
        Date date = new Date((long) lista.get(position).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateDay = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateHour = new SimpleDateFormat("HH:mm");
        holder.textDia.setText(dateDayOfWeek.format(date));
        holder.textFecha.setText(dateDay.format(date));
        holder.textHora.setText(dateHour.format(date));
        holder.textCielo.setText(lista.get(position).weather.get(0).description);
        holder.textTemperatura.setText(lista.get(position).main.temp + "º");
        holder.textMaxTemp.setText(lista.get(position).main.temp_max + "º");
        holder.textMinTemp.setText(lista.get(position).main.temp_min + "º");
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagenIcon;
        private TextView textDia, textFecha, textHora, textCielo, textTemperatura, textMaxTemp, textMinTemp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenIcon = itemView.findViewById(R.id.imageIcon);
            textDia = itemView.findViewById(R.id.textDia);
            textFecha = itemView.findViewById(R.id.textFecha);
            textHora = itemView.findViewById(R.id.textHora);
            textCielo = itemView.findViewById(R.id.textCielo);
            textTemperatura = itemView.findViewById(R.id.textTemperatura);
            textMaxTemp = itemView.findViewById(R.id.textMaxTemp);
            textMinTemp = itemView.findViewById(R.id.textMinTemp);
        }
    }
}
