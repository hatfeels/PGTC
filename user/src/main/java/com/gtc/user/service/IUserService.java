package com.gtc.user.service;


import com.gtc.user.dto.TaskDTO;
import com.gtc.user.entities.UserEntity;
import com.gtc.user.http.response.TaskByEditorResponse;
import com.gtc.user.http.response.TaskByOwnerResponse;

import java.util.List;

public interface IUserService {

    // todos los usuarios
    List<UserEntity> findAll();

    // busca usuario por ID
    UserEntity findById(Long id);

    // crea/modificar un usuario
    void save(UserEntity user);

    // borra un usuario
    void delete(Long id);

    // busca el dueño de una tarea
    List<UserEntity> findByIdTask(Long idTask);

    // busca los editores de una tarea
    List<UserEntity> findEditorsByIdTask(Long idTask);

    // Respuestas personalizadas

    //Busca las tareas de un editor
    TaskByEditorResponse findTaskByIdEditor(Long idUser);

    //Busca las tareas que creo un usuario
    TaskByOwnerResponse findTaskByIdOwner(Long idUser);

    //Crea una tarea
    void createTask(TaskDTO task, Long idUser);

    //Suma un editor a una tarea
    void addEditorToTask(Long idTask, Long idEditor);
}
