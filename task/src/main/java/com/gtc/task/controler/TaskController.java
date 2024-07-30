package com.gtc.task.controler;

import com.gtc.task.entities.Task;
import com.gtc.task.service.ITaskService;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    // agregar sistemas de puntos
    // sistema de comentarios o notas

    @Autowired
    private ITaskService taskService;

    //Crea una tarea. Modificar para q actualize al usuario. publico. consumir desde ms-users
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task){
        taskService.save(task);
    }

    // solo accesible para el administrador
    @GetMapping("/all")
    public ResponseEntity<?> getAllTask(){
        return ResponseEntity.ok(taskService.findAll());
    }

    // accesible sin credenciales
    @GetMapping("/public/all")
    public ResponseEntity<?> getAllPublicTask() {
        return ResponseEntity.ok(taskService.findAllPublicTask());
    }

    //accesible con credenciales
    @GetMapping("/search/{idTask}")
    public ResponseEntity<?> getById(@PathVariable Long idTask){
        return ResponseEntity.ok(taskService.findById(idTask));
    }

    // Editar para limite el acceso solo para el respectivo usuario
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTask(@PathVariable Long id, @RequestBody Task task) throws HttpResponseException {
        if (Objects.equals(id, task.getId())) {
            taskService.save(task);
        } else {
            throw new HttpResponseException(403, "don't authorized");
        }
    }

    //Busca todos los editores de una tarea. consumir desde ms-users
    @GetMapping("/get/editable/{idUser}")
    public ResponseEntity<?> getAllEditableTask(@PathVariable Long idUser){
        return ResponseEntity.ok(taskService.findAllEditableTask(idUser));
    }

    //Busca al creador de una tarea (en un array). consumir desde ms-users
    @GetMapping("/get/own/{idUser}")
    public ResponseEntity<?> getAllOwnTasks(@PathVariable Long idUser){
        return ResponseEntity.ok(taskService.findAllOwnTasks(idUser));
    }
}
