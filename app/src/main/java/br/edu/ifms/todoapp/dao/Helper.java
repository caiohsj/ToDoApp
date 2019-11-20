package br.edu.ifms.todoapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public static String DB_NAME = "app_tarefas.db";
    public static Integer VERSION = 1;

    public Helper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableTarefa(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createTableTarefa(SQLiteDatabase db) {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE tarefa(");
        query.append("id INTEGER PRIMARY KEY AUTOINCREMENT,");
        query.append("descricao TEXT,");
        query.append("data TEXT,");
        query.append("feito INTEGER)");
        db.execSQL(query.toString());
    }
}
