 package com.karakurt.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et = findViewById(R.id.editTextText);
         findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Routing MainActivity2
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("mesaj",et.getText().toString());
                startActivity(i);
            }
        });
    }
}