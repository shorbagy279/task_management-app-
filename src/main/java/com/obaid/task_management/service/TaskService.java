package com.obaid.task_management.service;

import com.obaid.task_management.entity.Task;
import com.obaid.task_management.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    //Create a new task with title, description, priority, and due date.
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    //Read all tasks, with the option to filter by priority or due date
    public List<Task> readAll() {
        return taskRepo.findAll();
    }

    //Read by ID
    public Task readById(Integer id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found task with id " + id));
    }


    //Update task details such as status or description.
    public Task updateTask(Integer id, Task updatedTask) {
        Optional<Task> now = taskRepo.findById(id);
        if (now.isPresent()) {
            Task toUpdate = (Task) now.get();
            toUpdate.setCatrgory(updatedTask.getCatrgory());
            toUpdate.setDescription(updatedTask.getDescription());
            toUpdate.setPriotrity(updatedTask.getPriotrity());
            toUpdate.setStatus(updatedTask.getStatus());
            toUpdate.setTitle(updatedTask.getTitle());
            toUpdate.setDueDate(updatedTask.getDueDate());
            return taskRepo.save(toUpdate);

        }
        else
        {
            throw new RuntimeException("Not founded task with id" + id);
        }
    }

    //Delete a task.
    public boolean deleteTask(Task forDeleted) {
        if (taskRepo.existsById(forDeleted.getId())) {
            taskRepo.delete(forDeleted);
            return true;
        } else {
            throw new RuntimeException("Task not found for deletion with id " + forDeleted.getId());
        }
    }

}
