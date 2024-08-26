package br.edu.ifsuldeminas.mch.tarefas;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;
import br.edu.ifsuldeminas.mch.tarefas.model.db.DAOObserver;
import br.edu.ifsuldeminas.mch.tarefas.model.db.TaskDAO;

public class FormActivity extends AppCompatActivity implements DAOObserver {

    private Toolbar toolbar;
    private EditText taskDescription;
    private Task task;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent chooserIntent = getIntent();
        task = (Task) chooserIntent.getSerializableExtra("tarefa");
        if (task != null) {
            TextInputEditText textInputEditText = findViewById(R.id.task_description);
            textInputEditText.setText(task.getDescription());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.save_task: {

                taskDescription = findViewById(R.id.task_description);
                Editable editable = taskDescription.getText();
                String desc = editable != null ? editable.toString() : "";

                if (desc.equals("")) {
                    Toast toast = Toast.makeText(this,
                            "Descição não pode ser vazia!", Toast.LENGTH_LONG);
                    toast.show();

                    return false;
                }

                TaskDAO dao = new TaskDAO(this);
                if (this.task == null) {
                    task = new Task();
                    task.setDescription(desc);
                    dao.save(task);
//                    Toast toast = Toast.makeText(this,
//                            "Tarefa salva com sucesso!", Toast.LENGTH_LONG);
//                    toast.show();
                } else {
                    task.setDescription(desc);
                    dao.update(task);
//                    Toast toast = Toast.makeText(this,
//                            "Tarefa atualizada com sucesso!", Toast.LENGTH_LONG);
//                    toast.show();
                }

                finish();
                break;
            }
        }
        ;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void saveOk() {
        Toast toast = Toast.makeText(this,
                "Tarefa salva com sucesso!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void saveErro() {
        Toast toast = Toast.makeText(this,
                "Tarefa não pode ser salva!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void updateOk() {
        Toast toast = Toast.makeText(this,
                "Tarefa atualizada com sucesso!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void updateErro() {
        Toast toast = Toast.makeText(this,
                "Tarefa não pode ser atualizada!", Toast.LENGTH_LONG);
        toast.show();
    }
}
