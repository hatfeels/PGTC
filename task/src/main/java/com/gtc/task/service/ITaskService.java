package com.gtc.task.service;

import com.gtc.task.entities.Task;

import java.util.List;

public interface ITaskService {

    List<Task> findAll();

    List<Long> findAllIdTaskByIdUser(Long idUser);

    Task findById(Long id);

    void save(Task task);

    void delete(Long id);

    List<Task> findAllEditableTask(Long idUser);

    List<Task> findAllOwnTasks(Long idUser);

    List<Task> findAllPublicTask();

    void addEditorToTask(Long idTask, Long idEditor);


}
