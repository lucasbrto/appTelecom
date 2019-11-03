package com.example.apptelecom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExibeCadastros extends AppCompatActivity {

    private ListView minhaLista;
    private ArrayAdapter mAdapter;
    private ArrayList<Cadastro> exibeLista;
    private CadastroDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_cadastros);

        //Cria uma list view para exibir os cadastros do banco
        db = new CadastroDB(this);
        minhaLista = (ListView) findViewById(R.id.listViewXML);
        exibeLista = db.findALL();

        //cria um adapter para gerenciar a exibição de cada item da lista
        mAdapter = new ArrayAdapter<Cadastro>(this, android.R.layout.simple_list_item_1, exibeLista);
        minhaLista.setAdapter(mAdapter);
    }
}
