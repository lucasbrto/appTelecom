package com.example.apptelecom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vai pra tela do FPGA
        Button btFpga = findViewById(R.id.botaoFpga);
        btFpga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int2 = new Intent("VAIFPGA");
                startActivity(Int2);
            }
        });

        //Vai pra tela de Microcontroladores
        Button btMicro = findViewById(R.id.botaoMicro);
        btMicro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int4 = new Intent("VAIMICRO");
                startActivity(Int4);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
