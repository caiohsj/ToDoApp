package br.edu.ifms.todoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.todoapp.model.Tarefa;

public class TarefaDAO {
    private Helper helper;
    private SQLiteDatabase db;
    private static TarefaDAO instance;

    public TarefaDAO(Context context) {
        helper = new Helper(context);
    }

    public void addTarefa(Tarefa tarefa) {
        db = helper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("descricao", tarefa.getDescricao());
        values.put("data", tarefa.getData());
        values.put("feito", 0);

        db.insert("tarefa", null, values);
    }

    public List<Tarefa> getTarefas() {
        db = helper.getWritableDatabase();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM Tarefa ");
        Cursor cursor = db.rawQuery(query.toString(),null);

        List<Tarefa> tarefas = new ArrayList<Tarefa>();

        if(cursor == null){
            return tarefas;
        }


        Tarefa tarefa;
        while(cursor.moveToNext()){
            tarefa = new Tarefa();
            tarefa.setId(cursor.getInt(0));
            tarefa.setDescricao(cursor.getString(1));

            tarefa.setData(cursor.getString(2));


            tarefa.setFeito(cursor.getInt(3));

            tarefas.add(tarefa);
        }
        return tarefas;
    }
}
