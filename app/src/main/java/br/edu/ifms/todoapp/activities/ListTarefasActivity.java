package br.edu.ifms.todoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.edu.ifms.todoapp.R;

public class ListTarefasActivity extends AppCompatActivity {
    private FloatingActionButton botaoNovaTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Tarefas");
        setContentView(R.layout.activity_list_tarefas);
        inicializarRefencias();
        inicializarAcoes();
    }

    private void inicializarRefencias() {
        botaoNovaTarefa = findViewById(R.id.activity_list_tarefas_botao_nova_tarefa);
    }

    private void inicializarAcoes() {
        botaoNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTarefasActivity.this, FormTarefaActivity.class);
                startActivity(intent);
            }
        });
    }
}
