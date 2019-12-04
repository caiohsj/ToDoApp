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

import java.util.List;

import br.edu.ifms.todoapp.R;
import br.edu.ifms.todoapp.adapters.TarefaAdapter;
import br.edu.ifms.todoapp.dao.TarefaDAO;
import br.edu.ifms.todoapp.model.Tarefa;

public class ListTarefasActivity extends AppCompatActivity {
    private FloatingActionButton botaoNovaTarefa;
    private Button botaoFeito;
    private ListView listView;
    private TarefaAdapter adapter;
    private TarefaDAO dao;
    private List<Tarefa> tarefas;
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
        listView.setAdapter(adapter);
        tarefas = dao.getTarefas();
    }

    private void inicializarRefencias() {
        botaoNovaTarefa = findViewById(R.id.activity_list_tarefas_botao_nova_tarefa);
        listView = findViewById(R.id.activity_list_tarefas_list_view);
        adapter = new TarefaAdapter(this);
        dao = new TarefaDAO(getBaseContext());
        listView.setAdapter(adapter);
        tarefas = dao.getTarefas();
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
                final int posicao = position;
                botaoFeito = view.findViewById(R.id.activity_list_tarefas_item_botao_feito);
                botaoFeito.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tarefa tarefa = tarefas.get(posicao);
                        tarefa.setFeito(1);
                        dao.atualizarTarefa(tarefa);
                        adapter.setTarefas(dao.getTarefas());
                        listView.setAdapter(adapter);
                    }
                });
            }
        });
    }

}
