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
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskRepository taksRepository;

    ///LIST ALL
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tasks")
    public List<Task> listAll(){
        return taksRepository.findAll();
    }

    ///CREAR UNO NUEVO
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task){
        return taksRepository.save(task);
    }

    ///CONSULTAR UNO EN ESPECIFICO POR ID
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se existe la task con el id" + id));
        return ResponseEntity.ok(task);
    }
    ///ELIMINAR UNO POR ID
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taksRepository.deleteById(id);
    }

    ///---------------------------------------------------------------------
    ///---------------------------------------------------------------------

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("task/update")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody Task taskDetails){
        Task task = taksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El valor que intentas actualizar no se encuentra" + id));

        taskDetails.setName(taskDetails.getName());
        taskDetails.setDescription(taskDetails.getDescription());

        Task taskUpdate = taksRepository.save(taskDetails);
        return ResponseEntity.ok(task);
    }

}
