package br.edu.ifms.todoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.edu.ifms.todoapp.R;

public class FormTarefaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Nova Tarefa");
        setContentView(R.layout.activity_form_tarefa);
    }
}
