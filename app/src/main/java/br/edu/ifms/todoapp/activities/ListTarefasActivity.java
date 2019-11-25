package br.edu.ifms.todoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.edu.ifms.todoapp.R;
import br.edu.ifms.todoapp.adapters.TarefaAdapter;
import br.edu.ifms.todoapp.dao.TarefaDAO;

public class ListTarefasActivity extends AppCompatActivity {
    private FloatingActionButton botaoNovaTarefa;
    private Button botaoFeito;
    private ListView listView;
    private TarefaAdapter adapter;
    private TarefaDAO dao;
    private AppCompatActivity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Tarefas");
        setContentView(R.layout.activity_list_tarefas);
        inicializarRefencias();
        inicializarAcoes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setTarefas(dao.getTarefas());
    }

    private void inicializarRefencias() {
        botaoNovaTarefa = findViewById(R.id.activity_list_tarefas_botao_nova_tarefa);
        botaoFeito = findViewById(R.id.activity_list_tarefas_item_botao_feito);
        listView = findViewById(R.id.activity_list_tarefas_list_view);
        adapter = new TarefaAdapter(this);
        dao = new TarefaDAO(getBaseContext());
        listView.setAdapter(adapter);
    }

    private void inicializarAcoes() {
        botaoNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTarefasActivity.this, FormTarefaActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                botaoFeito.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText( ListTarefasActivity.this, "Apertado", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
