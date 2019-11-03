package com.example.apptelecom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;

public class CadastroDB extends SQLiteOpenHelper {


    public static final String TAG = "sql";
    public static final String NOME_BANCO = "MeuBancodeDados.db";
    public static final int VERSAO_BANCO = 10;
    public static final String TABLE_NAME = "Emprestimos";
    public static final String COLUNA1 = "nome";
    public static final String COLUNA2 = "ra";

    public CadastroDB(Context context) {
        super(context, NOME_BANCO, null , VERSAO_BANCO);
    }


    private static final String SQL_CREATE_TABLE = //cria a tabela do banco de dados
            "CREATE TABLE "+TABLE_NAME+" ("
                    +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA1 + " TEXT,"
                    + COLUNA2 + " INT )";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE); //inicia a tabela
        Log.d(TAG, "Tabela "+TABLE_NAME+" criada com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long salvaEmprestimo(Cadastro aluno){
        long id = aluno.get_id();
        SQLiteDatabase db =getWritableDatabase(); // abre conexão com o banco de dados
        try{
            ContentValues valores = new ContentValues();
            valores.put(COLUNA1, aluno.getNome());
            valores.put(COLUNA2, aluno.getRa());

           if(id!=0){
                String[] whereArgs = new String[]{String.valueOf(id)};
                int count = db.update(TABLE_NAME, valores,"_id=?", whereArgs);
                return count;
            } else{
                id = db.insert(TABLE_NAME, null, valores); //insere uma nova linha de registro no banco de dados
                return id;
           }
        }
        catch (SQLException e){
            Log.d(TAG,"Falha ao se conectar ao Banco de Dados ");
        }

        finally {
            db.close(); //encerra a comunicação com o bando de dados
        }
        return id;
    }


    public int apagaEmprestimo(String nome){
        SQLiteDatabase db = getWritableDatabase();// abre conexão com o banco de dados
        try{
            int count = db.delete(TABLE_NAME, "nome=?", new String[] {nome}); //delata o registro escolhido do banco de dados
            Log.d(TAG,"Devolveu Fpga: "+ count);
            return count;
        }
        catch (SQLException e){
            Log.d(TAG,"Falha ao se conectar ao Banco de Dados ");
        }
        finally{
            db.close(); // encerra comunicação com o banco de dados
        }
       return 0;
    }

    public ArrayList<Cadastro> findALL() {
        SQLiteDatabase db = getWritableDatabase(); // abre conexão com o banco de dados
        ArrayList<Cadastro> lista = new ArrayList<>(); //cria uma lista para armazenar todos os cadastros registrados no banco de dados
        try {
            Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null); //cria um cursor
            if (c.moveToFirst()) { //seta o cursor para o primeiro registro
                do {
                    long id = c.getLong(c.getColumnIndex("_id"));
                    String nome = c.getString(c.getColumnIndex("nome"));
                    int ra = c.getInt(c.getColumnIndex("ra"));

                    Cadastro currentContact = new Cadastro(id, nome, ra);
                    lista.add(currentContact); //retorna uma lista de todos os cadastros registrados no banco de dados
                } while (c.moveToNext()); //move o cursor para o proximo cadastro da lista
            }
            return lista;
        } finally {
            db.close(); // encerra comunicação com o banco de dados

        }
    }

}
