package com.main.TaskKeeper.Repository;

import com.main.TaskKeeper.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
