package com.gtc.user.service;


import com.gtc.user.entities.UserEntity;

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
}
