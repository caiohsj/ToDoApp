package br.edu.ifms.todoapp.model;

import java.util.Date;

public class Tarefa {
    private long id;
    private String descricao;
    private String data;
    private int feito;

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFeito(int feito) {
        this.feito = feito;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getFeito() {
        return feito;
    }

    public String getData() {
        return data;
    }
}
