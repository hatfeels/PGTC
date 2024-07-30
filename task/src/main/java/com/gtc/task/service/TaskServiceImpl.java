package com.gtc.task.service;

import com.gtc.task.entities.Task;
import com.gtc.task.persistence.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAllEditableTask(Long idUser) {

        return taskRepository.findAllEditableTask(idUser);
    }

    @Override
    public List<Task> findAllOwnTasks(Long idUser) {
        return taskRepository.findAllOwnTasks(idUser);
    }

    @Override
    public List<Task> findAllPublicTask() {
        return taskRepository.findAllPublicTask();
    }
}
