package com.karakurt.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tv = findViewById(R.id.textView3);
        Intent i = getIntent();
        String isim = i.getStringExtra("isim");
        int skor = i.getIntExtra("skor",0);
        int hata = i.getIntExtra("hata",0);
        tv.setText("Tebrikler "+isim+"\n"+"Skorunuz: "+skor+ "\n"+"Hata Sayısı : "+hata);
        findViewById(R.id.again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}