package com.example.taskapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title) {
        if (!title.isBlank()) {
            tasks.add(new Task(title));
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        tasks.removeIf(t -> t.getId() == id);
        return "redirect:/";
    }
}
