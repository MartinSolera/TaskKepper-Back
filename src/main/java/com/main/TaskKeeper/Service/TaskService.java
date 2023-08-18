package com.main.TaskKeeper.Service;
import com.main.TaskKeeper.Model.Task;
import com.main.TaskKeeper.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAll(){
        taskRepository.deleteAll();
    }




}
