package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/create_task")
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PatchMapping("/tasks/{id}")
    public void patchDoneMethod(@PathVariable Long id, @RequestBody Task task){
        if (task.isDone()) taskRepository.markAsDone(id);
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchDoneMethod(@PathVariable Long id){
        taskRepository.markAsDone(id);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable long id) {//удалить запись по id
        taskRepository.deleteById(id);
    }

    @GetMapping("/tasks/{id}")
    public Task get(@PathVariable long id) {//получить запись по id
        return (Task) taskRepository.findById(id).orElse(null);
    }

    @GetMapping("/tasks")
    public Iterable<Task> get() {//получить все записи
        return taskRepository.findAll();
    }
}
