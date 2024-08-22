package com.gtc.task.service;

import com.gtc.task.client.UserClient;
import com.gtc.task.dto.UserEntityDTO;
import com.gtc.task.entities.Task;
import com.gtc.task.persistence.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserClient userClient;

    private void userUpdater(Long idUser) {
        UserEntityDTO user = userClient.getUserById(idUser);
        List<Long> taskIds = taskRepository.findAllIdTaskByIdUser(idUser);
        user.setTaskOwn(taskIds);
        userClient.updateUser(user);


    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public List<Long> findAllIdTaskByIdUser(Long idUser) {
        return taskRepository.findAllIdTaskByIdUser(idUser);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
        userUpdater(task.getOwnerId());
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

    @Override
    public void addEditorToTask(Long idTask, Long idEditor) {
        System.out.println(idTask);
        Task task = taskRepository.findById(idTask).orElseThrow();
        System.out.println(task.toString());
        List<Long> newEditors = task.getEditors();
        newEditors.add(idEditor);
        task.setEditors(newEditors);
        taskRepository.save(task);
    }
}
