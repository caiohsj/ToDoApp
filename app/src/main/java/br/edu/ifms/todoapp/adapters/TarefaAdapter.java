package br.edu.ifms.todoapp.adapters;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.edu.ifms.todoapp.R;
import br.edu.ifms.todoapp.model.Tarefa;

public class TarefaAdapter extends BaseAdapter {
    private List<Tarefa> tarefas;
    private AppCompatActivity activity;
    private TextView campoDescricao;
    private TextView campoData;
    private Button botaoFeito;

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public TarefaAdapter(AppCompatActivity activity) {
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
        botaoFeito = view.findViewById(R.id.activity_list_tarefas_item_botao_feito);
        campoDescricao = view.findViewById(R.id.activity_list_tarefas_item_campo_descricao);
        campoData = view.findViewById(R.id.activity_list_tarefas_item_campo_data);

        botaoFeito.setFocusable(false);
        botaoFeito.setClickable(false);

        Tarefa tarefa = tarefas.get(position);

        SimpleDateFormat formatType = new SimpleDateFormat("dd/MM/yyyy");

        Date dataAtual = new Date();
        Date dataTarefa = null;
        try {
            dataTarefa = formatType.parse(tarefa.getData());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        Calendar calendarAtual = Calendar.getInstance();

        calendar.setTime(dataTarefa);

        int diaTarefa = calendar.get(Calendar.DAY_OF_MONTH);
        int semanaTarefa = calendar.get(Calendar.WEEK_OF_MONTH);
        int mesTarefa = calendar.get(Calendar.MONTH);
        int anoTarefa = calendar.get(Calendar.YEAR);

        int diaAtual = calendarAtual.get(Calendar.DAY_OF_MONTH);
        int semanaAtual = calendarAtual.get(Calendar.WEEK_OF_MONTH);
        int mesAtual = calendarAtual.get(Calendar.MONTH);
        int anoAtual = calendarAtual.get(Calendar.YEAR);

        int difDias = diaAtual - diaTarefa;

        char[] a = tarefa.getDescricao().toCharArray();

        String descricao = "";

        if(a.length > 17) {
            for (int i = 0; i < 17; i++) {
                descricao += a[i];
            }
        } else {
            for (int i = 0; i < a.length; i++) {
                descricao += a[i];
            }
        }

        if(a.length > 17)
            descricao += "...";

        campoDescricao.setText("Tarefa "+tarefa.getId()+": "+descricao);
        campoData.setText("Data: ("+tarefa.getData()+")");

        //Se a tarefa é para a semana atual
        if(anoAtual == anoTarefa && mesAtual == mesTarefa && semanaAtual == semanaTarefa)
            view.setBackgroundColor(Color.parseColor("yellow"));

        //Se a tarefa está atrasada
        if(mesAtual == mesTarefa && anoAtual == anoTarefa && difDias > 0)
            view.setBackgroundColor(Color.parseColor("red"));

        //Se a tarefa foi marcada com 'feita', então é exibida como verde
        if(tarefa.getFeito() == 1) {
            view.setBackgroundColor(Color.parseColor("green"));
            botaoFeito.setVisibility(View.INVISIBLE);
        }

        return view;
    }


}
