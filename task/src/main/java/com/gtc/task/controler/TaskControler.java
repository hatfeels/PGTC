package com.gtc.task.controler;

import com.gtc.task.entities.Task;
import com.gtc.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskControler {

    @Autowired
    private ITaskService taskService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task){
        taskService.save(task);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTask(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/search/{idTask}")
    public ResponseEntity<?> getById(@PathVariable Long idTask){
        return ResponseEntity.ok(taskService.findById(idTask));
    }
}
