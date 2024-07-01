package com.gtc.user.service;

import com.gtc.user.entities.User;

import java.util.List;

public interface IUserService {

    // todos los usuarios
    List<User> findAll();

    // busca usuario por ID
    User findById(Long id);

    // crea un usuario
    void save(User user);

    // vusca el dueño de una tarea
    List<User> findByIdTask(Long idTask);

}
