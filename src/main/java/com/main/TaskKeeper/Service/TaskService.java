package com.main.TaskKeeper.Service;

import com.main.TaskKeeper.Exceptions.ResourceNotFoundException;
import com.main.TaskKeeper.Model.Task;
import com.main.TaskKeeper.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @DeleteMapping("/tasks/deleteAll")
    public void deleteAll(){
        taskRepository.deleteAll();
    }


}
