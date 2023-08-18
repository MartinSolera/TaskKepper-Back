package com.main.TaskKeeper.Controller;

import com.main.TaskKeeper.Model.Task;
import com.main.TaskKeeper.Repository.TaskRepository;
import com.main.TaskKeeper.Service.TaskService;
import com.main.TaskKeeper.Util.ListarPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    @Autowired
    private TaskRepository taksRepository;

    @Autowired
    private TaskService taskService;

    @Autowired ListarPDF listarPDF;


    @GetMapping("/tasks")
    public List<Task> listAll(){
        return taskService.listAll();
    }

    @GetMapping("/tasksPDF")
    public ModelAndView listAllTasks() {
        List<Task> tasks = taskService.listAll();
        ModelAndView modelAndView = new ModelAndView(new ListarPDF());
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    /*
    @DeleteMapping("/tasks/deleteAll")
    public void deleteAll(){
        taskService.deleteAll();
    }
    */


}
