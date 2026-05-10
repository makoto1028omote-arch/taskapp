package com.example.taskapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title) {
        if (!title.isBlank()) {
            taskRepository.save(new Task(title));
        }
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String toggle(@PathVariable Long id) {
        taskRepository.findById(id).ifPresent(task -> {
            task.setDone(!task.isDone());
            taskRepository.save(task);
        });
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
