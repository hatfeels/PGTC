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


    //Crea una tarea. Modificar para q actualize al usuario. publico. consumir desde ms-users DONE
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task) {

        taskService.save(task);
    }

    // solo accesible para el administrador
    @GetMapping("/all")
    public ResponseEntity<?> getAllTask() {
        return ResponseEntity.ok(taskService.findAll());
    }

    // accesible sin credenciales
    @GetMapping("/public/all")
    public ResponseEntity<?> getAllPublicTask() {
        return ResponseEntity.ok(taskService.findAllPublicTask());
    }

    //accesible con credenciales
    @GetMapping("/search/{idTask}")
    public ResponseEntity<?> getById(@PathVariable Long idTask) {
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

    //Busca todas las tareas de un editor. consumir desde ms-users DONE
    @GetMapping("/get/editable/{idUser}")
    public ResponseEntity<?> getAllEditableTask(@PathVariable Long idUser) {
        return ResponseEntity.ok(taskService.findAllEditableTask(idUser));
    }

    //Busca las tareas que creo un usuario (en un array). consumir desde ms-users DONE
    @GetMapping("/get/own/{idUser}")
    public ResponseEntity<?> getAllOwnTasks(@PathVariable Long idUser) {
        return ResponseEntity.ok(taskService.findAllOwnTasks(idUser));
    }

    @PutMapping("/update/editor/{idTask}")
    public void addEditorToTask(@PathVariable Long idTask, @RequestBody Long idEditor) {
        taskService.addEditorToTask(idTask, idEditor);
    }
}
