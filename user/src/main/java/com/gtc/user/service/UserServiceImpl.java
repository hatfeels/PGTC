package com.gtc.user.service;

import com.gtc.user.client.TaskClient;
import com.gtc.user.dto.TaskDTO;
import com.gtc.user.entities.UserEntity;
import com.gtc.user.http.response.TaskByEditorResponse;
import com.gtc.user.http.response.TaskByOwnerResponse;
import com.gtc.user.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskClient taskClient;

    //busca todos los usuarios
    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    // busca un usuario especifico
    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    //guarda un usuario nuevo o midificado
    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }

    //borra un usuario
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // busca al dueño de una tarea
    @Override
    public List<UserEntity> findByIdTask(Long idTask) {
        return userRepository.findOwnerByIdTask(idTask);
    }

    //busca todos los editores de una tarea
    @Override
    public List<UserEntity> findEditorsByIdTask(Long idTask) {
        return userRepository.findEditorsByTaskId(idTask);
    }

    @Override
    public TaskByEditorResponse findTaskByIdEditor(Long idUser) {

        // consultar user
        UserEntity user = userRepository.findById(idUser).orElseThrow();

        List<TaskDTO> taskDTOList = taskClient.findAllTaskByEditor(idUser);
        return TaskByEditorResponse.builder()
                .name(user.getName())
                .tastDTOList(taskDTOList)
                .build();
    }

    @Override
    public TaskByOwnerResponse findTaskByIdOwner(Long idUser) {
        UserEntity user = userRepository.findById(idUser).orElseThrow();

        List<TaskDTO> taskDTOList = taskClient.findAllTaskByOwner(idUser);
        return TaskByOwnerResponse.builder()
                .name(user.getName())
                .tastDTOList(taskDTOList)
                .build();
    }

    @Override
    public void createTask(TaskDTO task, Long idUser) {
        task.setOwnerId(idUser);
        taskClient.createTask(task);
    }

    @Override
    public void addEditorToTask(Long idTask, Long idEditor) {
        UserEntity editor = userRepository.findById(idEditor).orElseThrow();
        List<Long> taskList = editor.getTaskList();
        taskList.add(idTask);
        editor.setTaskList(taskList);
        userRepository.save(editor);

        taskClient.addEditorToTask(idTask, idEditor);
    }
}
