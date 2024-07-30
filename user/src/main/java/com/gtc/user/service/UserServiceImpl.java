package com.gtc.user.service;

import com.gtc.user.entities.UserEntity;
import com.gtc.user.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

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
        return (List<UserEntity>) userRepository.findOwnerByIdTask(idTask);
    }

    //busca todos los editores de una tarea
    @Override
    public List<UserEntity> findEditorsByIdTask(Long idTask) {
        return (List<UserEntity>) userRepository.findEditorsByTaskId(idTask);
    }
}
