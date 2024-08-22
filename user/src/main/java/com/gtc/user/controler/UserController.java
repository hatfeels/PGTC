package com.gtc.user.controler;

import com.gtc.user.dto.TaskDTO;
import com.gtc.user.entities.UserEntity;
import com.gtc.user.service.IUserService;
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
    public void createUser(@RequestBody UserEntity user) {
        userService.save(user);
    }

    //Busca todos los usuarios
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    //Buscar un usuario especifico
    @GetMapping("/search/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    //endpoints q consumen el MS-task

    //Busca las tareas de un editor
    @GetMapping("/search-task-by-editor/{idUser}")
    public ResponseEntity<?> findTaskByIdEditor(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.findTaskByIdEditor(idUser));
    }

    //Busca las tareas que creo un usuario
    @GetMapping("/search-task-by-owner/{idUser}")
    public ResponseEntity<?> findTaskByIdOwner(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.findTaskByIdOwner(idUser));
    }

    // creea una tarea
    @PostMapping("/create-task/{idUser}")
    public void createTask(@RequestBody TaskDTO task, @PathVariable Long idUser) {
        userService.createTask(task, idUser);
    }

    // sumar editor a una tarea
    @PutMapping("/add-editor/{idTask}")
    public void addEditorToTask(@PathVariable Long idTask, @RequestBody Long idEditor) {
        userService.addEditorToTask(idTask, idEditor);
    }

    // endpoints q consume MS-task

    //Busca todos los editores de una tarea. consumir desde ms-task
    @GetMapping("/search/editors/{idTask}")
    public ResponseEntity<?> getEditorsByTaskId(@PathVariable Long idTask) {
        System.out.println(idTask);
        return ResponseEntity.ok(userService.findEditorsByIdTask(idTask));
    }

    //Busca al creador de una tarea. consumir desde ms-task
    @GetMapping("/search/owner/{idTask}")
    public ResponseEntity<?> getTaskOwner(@PathVariable Long idTask) {
        System.out.println(idTask);
        return ResponseEntity.ok(userService.findByIdTask(idTask));
    }

    //actualiza un usuario. consumir desde ms-task DONE
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody UserEntity user) {
        userService.save(user);
    }
}

