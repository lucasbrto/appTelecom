package com.example.apptelecom;

public class Cadastro {

    private long _id;
    private String nome;
    private int ra;

    public Cadastro(long _id, String nome, int ra){
        this._id= _id;
        this.nome=nome;
        this.ra = ra;
    }

    public int getRa() {return ra;}

    public void setRa(int ra) {this.ra = ra;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public long get_id() {return _id;}

    public void set_id(long _id) {this._id = _id;}

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "RA :" + ra +"\n";

    }
}
