package br.edu.ifsuldeminas.mch.tarefas.model.db;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;

public class TaskDAO {

    private static final String COLLECTION = "tasks";
    private static final String DESCRIPTION = "description";
    private static final String ACTIVE = "active";
    private static final String DATE_CHANGED = "date_changed";
    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private DAOObserver observer;

    public TaskDAO(DAOObserver observer) {
        this.observer = observer;
    }

    public boolean save(Task task) {

        Map<String, Object> taskAsMap = taskToMap(task);
        firestore.collection(COLLECTION).add(taskAsMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                observer.saveOk();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                observer.saveErro();
            }
        });

        return true;
    }

    private Map<String, Object> taskToMap(Task task) {
        Map<String, Object> map = new HashMap<>();
        map.put(DESCRIPTION, task.getDescription());
        map.put(ACTIVE, task.isActive());
        map.put(DATE_CHANGED, task.getDateChanged());

        return map;
    }

    public void loadTasks() {
        firestore.collection(COLLECTION).orderBy(DATE_CHANGED, Query.Direction.ASCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<QuerySnapshot> taskSnap) {

                //Código carga dos dados...

                if (taskSnap.isSuccessful()) {
                    List<Task> tasks = new ArrayList<>();
                    for (QueryDocumentSnapshot doc : taskSnap.getResult()) {
                        String id = doc.getId();
                        String description = doc.get(DESCRIPTION, String.class);
                        Boolean active = doc.get(ACTIVE, Boolean.class);

                        Task task = new Task(id, description);
                        tasks.add(task);
                    }

                    observer.loadOk(tasks);
                } else {
                    // Não há tarefas no banco...
                    observer.loadErro();
                }
            }
        });

    }

    public void delete(Task task) {

        firestore.collection(COLLECTION).document(task.getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                observer.deleteOk();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                observer.deleteErro();
            }
        });
    }

    public void update(Task task) {
        Map<String, Object> taskAsMap = taskToMap(task);

        firestore.collection(COLLECTION).document(task.getId()).update(taskAsMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                observer.updateOk();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                observer.updateErro();
            }
        });

    }
}
