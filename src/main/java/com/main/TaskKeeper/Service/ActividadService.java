package com.main.TaskKeeper.Service;

import com.main.TaskKeeper.Model.Actividad;
import com.main.TaskKeeper.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;


    private static LocalDate today = LocalDate.now();


    public List<Actividad> listAllActividades(){
        return actividadRepository.findAll();
    }

    public Actividad saveActividad(@RequestBody Actividad actividad){
        return actividadRepository.save(actividad);
    }

    public void deleteActividad(@PathVariable Long id){
        actividadRepository.deleteById(id);
    }

    public LocalDate getFechaInicio(@PathVariable Long id){
        LocalDate fechaInicio = null;
        Optional<Actividad> actividad = actividadRepository.findById(id);

        if (actividad != null){
            fechaInicio = actividad.get().getFechaInicio();
        }

        return fechaInicio;
    }

    ///---------------------

    public Long calculateWithOutEndDate (@PathVariable LocalDate fecha){
        long diferenciaFechas = ChronoUnit.DAYS.between(fecha, today);
        return diferenciaFechas;
    }

}


