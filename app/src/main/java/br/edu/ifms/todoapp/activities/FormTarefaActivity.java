package br.edu.ifms.todoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.MaskFilter;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.ifms.todoapp.R;
import br.edu.ifms.todoapp.dao.TarefaDAO;
import br.edu.ifms.todoapp.model.Tarefa;

public class FormTarefaActivity extends AppCompatActivity {
    private Button botaoSalvar;
    private EditText campoDescricao;
    private DatePicker campoData;
    private TarefaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Nova Tarefa");
        setContentView(R.layout.activity_form_tarefa);
        inicializarDAO();
        inicializarReferencias();
        inicializarAcoes();
    }

    private void inicializarDAO(){
        dao = new TarefaDAO(getBaseContext());
    }

    private void inicializarReferencias(){
        botaoSalvar = findViewById(R.id.activity_form_tarefa_botao_salvar);
        campoDescricao = findViewById(R.id.activity_form_tarefa_campo_descricao);
        campoData = findViewById(R.id.activity_form_tarefa_campo_data);
    }

    private void inicializarAcoes(){
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tarefa tarefa = new Tarefa();
                StringBuilder builder = new StringBuilder();

                builder.append(campoData.getDayOfMonth());
                builder.append("/");
                builder.append(campoData.getMonth()+1);
                builder.append("/");
                builder.append(campoData.getYear());

                tarefa.setDescricao(campoDescricao.getText().toString());
                tarefa.setData(builder.toString());
                dao.addTarefa(tarefa);
                Toast toast = Toast.makeText(FormTarefaActivity.this,"Salvo!",Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
    }
}
