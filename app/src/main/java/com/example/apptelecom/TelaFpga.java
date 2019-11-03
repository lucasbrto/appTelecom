package com.example.apptelecom;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaFpga extends AppCompatActivity {

    EditText textNome;
    EditText textRa;
    private CadastroDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fpga);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btDSFPGA = findViewById(R.id.botaoDSFPGA);
        Button btEmp = findViewById(R.id.btEmp);
        Button btDev = findViewById(R.id.btDev);
        textNome = findViewById(R.id.nomeXML);
        textRa = findViewById(R.id.raXML);
        db = new CadastroDB(this);


        btDSFPGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               try {
                    Intent OpenBrowseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.intel.com/content/dam/www/programmable/us/en/pdfs/literature/ds/ds_cyc.pdf"));
                    startActivity(OpenBrowseIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Download Falhou", Toast.LENGTH_LONG).show();

                }
            }
        });

        btEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textNome.getText().length() == 0 || textRa.getText().length() == 0){
                    Toast.makeText(TelaFpga.this, "Por favor preencha todos os campos.", Toast.LENGTH_LONG).show();
                } else {
                    String name = textNome.getText().toString();
                    int ra = Integer.parseInt(textRa.getText().toString());
                    Cadastro aluno = new Cadastro(0, name, ra);
                    long id = db.salvaEmprestimo(aluno);
                    if(id!=-1){
                        Toast.makeText(TelaFpga.this, "Empréstimo Realizado !", Toast.LENGTH_LONG).show();
                    } else{
                        Toast.makeText(TelaFpga.this,"Ops! Não foi possível cadastrar o aluno", Toast.LENGTH_LONG).show();
                    }
                    textNome.setText("");
                    textRa.setText("");

                }

            }
        });

        btDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textNome.getText().length() == 0){
                    Toast.makeText(TelaFpga.this, "Por favor preencha o nome do aluno.", Toast.LENGTH_LONG).show();
                } else {
                    int count = db.apagaEmprestimo(textNome.getText().toString());
                    if (count == 0) {
                        Toast.makeText(TelaFpga.this, "Cadastro inexistente.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(TelaFpga.this, "Fpga Devolvido !", Toast.LENGTH_LONG).show();
                    }
                    textNome.setText("");
                    textRa.setText("");
                }
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
        if (id == R.id.action_settings) { //caso selecione o item do menu, vai para a lista de cadastros feitos
            Intent Int5 = new Intent(TelaFpga.this, ExibeCadastros.class);
            startActivity(Int5);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
