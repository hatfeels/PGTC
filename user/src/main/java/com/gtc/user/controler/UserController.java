package com.gtc.user.controler;

import com.gtc.user.entities.UserEntity;
import com.gtc.user.service.IUserService;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //agregar sistema de amigos

    @Autowired
    private IUserService userService;

    //guarda un usuario nuevo
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserEntity user){
        userService.save(user);
    }

    //actualiza un usuario. consumir desde ms-task
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@PathVariable Long id, @RequestBody UserEntity user) throws HttpResponseException {
        if (Objects.equals(id, user.getId())) {
            userService.save(user);
        } else {
            throw new HttpResponseException(403, "don't authorized");
        }
    }

    //Busca todos los usuarios
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    //Busca todos los editores de una tarea. consumir desde ms-task
    @GetMapping("/search/editors/{idTask}")
    public ResponseEntity<?> getEditorsByTaskId(@PathVariable Long idTask){
        System.out.println(idTask);
        return ResponseEntity.ok(userService.findEditorsByIdTask(idTask));
    }

    //Busca al creador de una tarea. consumir desde ms-task
    @GetMapping("/search/owner/{idTask}")
    public ResponseEntity<?> getTaskOwner(@PathVariable Long idTask){
        System.out.println(idTask);
        return  ResponseEntity.ok(userService.findByIdTask(idTask));
    }

    //Buscar un usuario especifico
    @GetMapping("/search/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

}

