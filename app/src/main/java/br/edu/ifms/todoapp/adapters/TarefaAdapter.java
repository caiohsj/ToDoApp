package br.edu.ifms.todoapp.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.todoapp.R;
import br.edu.ifms.todoapp.model.Tarefa;

public class TarefaAdapter extends BaseAdapter {
    private List<Tarefa> tarefas;
    private AppCompatActivity activity;

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    TarefaAdapter(AppCompatActivity activity) {
        this.activity = activity;
        this.tarefas = new ArrayList<Tarefa>();
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tarefas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_list_tarefas_item, parent, false);
        SimpleDateFormat formatType = new SimpleDateFormat("dd/MM/yyyy");

        TextView campoDescricao = view.findViewById(R.id.activity_list_tarefas_item_campo_descricao);
        TextView campoData = view.findViewById(R.id.activity_list_tarefas_item_campo_data);

        Tarefa tarefa = tarefas.get(position);

        campoDescricao.setText("ID: "+tarefa.getId()+" "+tarefa.getDescricao());
        campoData.setText(formatType.format(tarefa.getData()));

        return view;
    }
}