package com.main.TaskKeeper.Repository;

import com.main.TaskKeeper.Model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
}
