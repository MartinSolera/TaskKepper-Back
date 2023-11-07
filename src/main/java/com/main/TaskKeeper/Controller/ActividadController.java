package com.main.TaskKeeper.Controller;

import com.main.TaskKeeper.Model.Actividad;
import com.main.TaskKeeper.Repository.ActividadRepository;
import com.main.TaskKeeper.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/act")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private ActividadService actividadService;

    @GetMapping("/actividad")
    public List<Actividad> listAllActividades(){
        return actividadService.listAllActividades();
    }

    @PostMapping("/createactividad")
    public Actividad saveActividad(@RequestBody Actividad actividad) {
        return actividadService.saveActividad(actividad);
    }

    @DeleteMapping("actividad/{id}")
    public void deleteActividad(@PathVariable Long id){
        actividadService.deleteActividad(id);
    }



}
