package com.example.yemeksiparisokulprojesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SiparislerimActivity extends AppCompatActivity {

    Button btndevam;
    RecyclerView recyclerView;
    List<Siparislerim> siparislist;
    SQLiteDatabase DB;
    String kullaniciadi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparislerim);

        btndevam=findViewById(R.id.btngerisiparis);

        recyclerView=findViewById(R.id.recyViewsiparis);
        DB=this.openOrCreateDatabase("FoodApp",MODE_PRIVATE,null);

        kullaniciadi=UserAuthSign.getInstance().getAuthUserName();
        siparislist=new ArrayList<>();
        Cursor cursor=DB.rawQuery("SELECT * FROM siparislerimm  WHERE kullaniciAdi ='" +kullaniciadi+"'  ", null);

        int foodindex=cursor.getColumnIndex("foods");
        int adresindex=cursor.getColumnIndex("adres");
        int fiyatindex=cursor.getColumnIndex("fiyat");
        int aciklamaindex=cursor.getColumnIndex("aciklama");

        while(cursor.moveToNext()){
            String food=cursor.getString(foodindex);
            String adres=cursor.getString(adresindex);
            String aciklama=cursor.getString(aciklamaindex);
            String fiyat=cursor.getString(fiyatindex);

            siparislist.add(new Siparislerim(food,fiyat,aciklama,adres));

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new SiparisAdapter(getApplicationContext(),siparislist));

        btndevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SiparislerimActivity.this,YiyecekCesitleriActivity.class);
                startActivity(intent);
            }
        });





    }
}