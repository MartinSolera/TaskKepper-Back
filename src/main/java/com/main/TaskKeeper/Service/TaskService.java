package com.main.TaskKeeper.Service;
import com.main.TaskKeeper.Model.Task;
import com.main.TaskKeeper.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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

    public Long getDataCalendar(@PathVariable LocalDate fecha){
        LocalDate fechaInicio = fecha;
        LocalDate fechaActual = LocalDate.now();

        long diferenciaFechas = ChronoUnit.DAYS.between(fechaInicio, fechaActual);

        return diferenciaFechas;
    }




}
