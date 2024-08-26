package br.edu.ifsuldeminas.mch.tarefas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;
import br.edu.ifsuldeminas.mch.tarefas.model.db.DAOObserver;
import br.edu.ifsuldeminas.mch.tarefas.model.db.TaskDAO;

public class MainActivity extends AppCompatActivity implements DAOObserver {

    private FloatingActionButton fab;
    private ListView todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoList = findViewById(R.id.todo_list);
        registerForContextMenu(todoList);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForm = new Intent(
                        MainActivity.this,
                        FormActivity.class);

                startActivity(intentForm);
            }
        });

        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l) {

                Task task = (Task) todoList.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this,
                        FormActivity.class);
                intent.putExtra("tarefa", task);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        updateTasks();
    }

    private void updateTasks() {
        TaskDAO dao = new TaskDAO(this);
        dao.loadTasks();

        // Iniciar um loading de espera ...
    }

    @Override
    public void loadOk(List<Task> tasks) {
        ArrayAdapter<Task> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        todoList.setAdapter(arrayAdapter);
        //Finalizar loading de espera...
    }

    @Override
    public void loadErro() {
        Toast.makeText(this, "Erro ao carregar dados", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        //        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem itemDelete = menu.add("Deletar tarefa");
        MenuItem itemFinish = menu.add("Finalizar tarefa");

        itemDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo itemClicado =
                        (AdapterView.AdapterContextMenuInfo) menuInfo;

                Task task = (Task)
                        todoList.getItemAtPosition(itemClicado.position);

                TaskDAO dao = new TaskDAO(MainActivity.this);
                dao.delete(task);

                updateTasks();

//                Toast t = Toast.makeText(MainActivity.this,
//                        "Tarefa excluída com sucesso!",
//                        Toast.LENGTH_SHORT);
//
//                t.show();

                return true;
            }
        });
    }

    @Override
    public void deleteOk() {
        Toast t = Toast.makeText(MainActivity.this, "Tarefa excluída com sucesso!", Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public void deleteErro() {
        Toast t = Toast.makeText(MainActivity.this, "Tarefa não pode ser excluída!", Toast.LENGTH_LONG);
        t.show();
    }

}