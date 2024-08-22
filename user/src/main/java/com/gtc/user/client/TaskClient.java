package com.gtc.user.client;

import com.gtc.user.dto.TaskDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gtc-user", url = "localhost:8080/api/task")
public interface TaskClient {

    //Busca las tareas de un editor
    @GetMapping("/get/editable/{idUser}")
    List<TaskDTO> findAllTaskByEditor(@PathVariable Long idUser);

    //Busca las tareas que creo un usuario
    @GetMapping("/get/own/{idUser}")
    List<TaskDTO> findAllTaskByOwner(@PathVariable Long idUser);

    //Crear una tarea
    @PostMapping("/create")
    void createTask(@RequestBody TaskDTO task);

    @PutMapping("/update/editor/{idTask}")
    void addEditorToTask(@PathVariable Long idTask, @RequestBody Long idEditor);

}
