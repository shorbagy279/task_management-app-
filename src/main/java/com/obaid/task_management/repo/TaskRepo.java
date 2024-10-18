package com.obaid.task_management.repo;

import com.obaid.task_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}
