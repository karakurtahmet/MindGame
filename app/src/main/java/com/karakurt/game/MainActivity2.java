package com.karakurt.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;

import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    int sonKart = 0;
    int skor = 0;
    int hata = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();

        final String s = i.getStringExtra("mesaj");
        TextView v = findViewById(R.id.textView2);
        v.setText("Başarılar "+s);
        GridLayout gl = findViewById(R.id.kartlar);
        kart kartlar[] = new kart[16];
        for (int j = 1; j <= 16; j++) {
            kartlar[j-1]= new kart(this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k = (kart) v;
                    k.cevir();
                    if(sonKart>0){
                        final kart k2 = findViewById(sonKart);

                        if(k2.onPlanID==k.onPlanID&&k2.getId()!=k.getId()){
                            //eslestiler
                            k2.cevrilebilir=false;
                            k.cevrilebilir=false;
                            skor++;
                            TextView tvSkor = findViewById(R.id.Skor);
                            tvSkor.setText("Skor : "+skor);
                            if(skor==8){
                                Intent j = new Intent(MainActivity2.this, MainActivity3.class);
                                j.putExtra("skor",skor);
                                j.putExtra("hata",hata);
                                j.putExtra("isim",s);
                                startActivity(j);
                            }
                        }
                        else{
                            //eslesmedi
                            Handler h= new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();
                                }
                            },500);
                            TextView tvHata = findViewById(R.id.Hata);
                            hata++;
                            tvHata.setText("Hata : "+hata);

                            sonKart=0;
                        }
                    }
                    else {
                        sonKart=k.getId();
                    }
                }
            });
        }

        for (int j = 0; j < 16 ; j++) {
            int rg = (int)(Math.random()*16);
            kart k = kartlar[rg];
            kartlar[rg] = kartlar[j];
            kartlar[j] = k;
        }

        for (int j = 0; j < 16 ; j++) {
            gl.addView(kartlar[j]);
        }


    }
}