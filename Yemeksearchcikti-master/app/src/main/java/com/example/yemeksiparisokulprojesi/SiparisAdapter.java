package com.example.yemeksiparisokulprojesi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiparisAdapter extends RecyclerView.Adapter<SiparisAdapter.ViewHolder> {

    Context context;
    List<Siparislerim> list;

    public SiparisAdapter(Context context, List<Siparislerim> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SiparisAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.siparis_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Siparislerim siparislerim = list.get(position);
        String food=siparislerim.getFood();
        String aciklama=siparislerim.getAciklama();
        String fiyat=siparislerim.getFiyat();
        String adres= siparislerim.getAdres();

        holder.food.setText(food);
        holder.fiyat.setText(fiyat);
        holder.aciklama.setText(aciklama);
        holder.adres.setText(adres);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {

        TextView food,aciklama,fiyat,adres;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            food=itemView.findViewById(R.id.textView2);
            fiyat=itemView.findViewById(R.id.textView3);
            adres=itemView.findViewById(R.id.tv7);
            aciklama=itemView.findViewById(R.id.textview5);

        }
    }

}
