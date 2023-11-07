package com.main.TaskKeeper.Service;

import com.main.TaskKeeper.Model.Actividad;
import com.main.TaskKeeper.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> listAllActividades(){
        return actividadRepository.findAll();
    }

    public Actividad saveActividad(@RequestBody Actividad actividad){
        return actividadRepository.save(actividad);
    }

    public void deleteActividad(@PathVariable Long id){
        actividadRepository.deleteById(id);
    }

}


