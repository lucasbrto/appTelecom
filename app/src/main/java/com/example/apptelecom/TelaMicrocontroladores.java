package com.example.apptelecom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaMicrocontroladores extends AppCompatActivity {

    Button btDSArduino;
    Button btDSFreedom;
    Button btInfosArduino;
    Button btInfosFreedom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_microcontroladores);

        btDSArduino = findViewById(R.id.btDSArduino);
        btDSFreedom = findViewById(R.id.btDSFreedom);
        btInfosArduino = findViewById(R.id.btInfosArduino);
        btInfosFreedom = findViewById(R.id.btInfosFreedom);

        btDSArduino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMicrocontroladores.this, WebViewArduino.class);
                startActivity(intent);
            }
        });

        btDSFreedom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMicrocontroladores.this, WebViewFreedom.class);
                startActivity(intent);
            }
        });

        btInfosArduino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMicrocontroladores.this, VideoArduino.class);
                startActivity(intent);
            }
        });

        btInfosFreedom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMicrocontroladores.this, VideoFreedom.class);
                startActivity(intent);
            }
        });
    }
}
