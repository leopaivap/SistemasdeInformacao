package br.edu.ifsuldeminas.mch.tarefas.model.db;

import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;

public interface DAOObserver {

    default void loadOk(List<Task> tasks) {
    }

    default void loadErro() {
    }

    default void saveOk() {
    }

    default void saveErro() {
    }

    default void updateOk() {
    }

    default void updateErro() {
    }

    default void deleteOk() {
    }

    default void deleteErro() {
    }


}
