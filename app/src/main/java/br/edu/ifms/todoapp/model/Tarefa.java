package br.edu.ifms.todoapp.model;

import java.util.Date;

public class Tarefa {
    private long id;
    private String descricao;
    private Date data;
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

    public void setData(Date data) {
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

    public Date getData() {
        return data;
    }
}
