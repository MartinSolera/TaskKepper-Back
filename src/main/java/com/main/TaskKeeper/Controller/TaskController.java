package com.main.TaskKeeper.Controller;

import com.main.TaskKeeper.Exceptions.ResourceNotFoundException;
import com.main.TaskKeeper.Model.Task;
import com.main.TaskKeeper.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    @Autowired
    private TaskRepository taksRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tasks")
    public List<Task> listAll(){
        return taksRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task){
        return taksRepository.save(task);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se existe la task con el id" + id));
        return ResponseEntity.ok(task);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taksRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/tasks/deleteAll")
    public void deleteAll(){
        taksRepository.deleteAll();
    }



}
