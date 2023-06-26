package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tasks")
public class TaskController extends HandleErrorService {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/create_task")
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PatchMapping("/{id}")
    public void patchDoneMethod(
            @PathVariable Long id,
            @Valid @RequestBody Task task
    ){
        if (!task.isDone()) taskRepository.markAsDone(id);
    }

    @PatchMapping("/{id}:mark-as-done")
    public void patchDoneMethod(@PathVariable Long id){
        taskRepository.markAsDone(id);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        taskRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable long id) {
        return (Task) taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @GetMapping("")
    public List<Task> get() {
        return taskRepository.findAll();
    }
}
