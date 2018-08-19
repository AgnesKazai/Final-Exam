package com.greenfoxcompany.connectionwithmysql.controllers;

import com.greenfoxcompany.connectionwithmysql.models.Todo;
import com.greenfoxcompany.connectionwithmysql.services.TodoService;
import com.greenfoxcompany.connectionwithmysql.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = {"/", "/list"})
    public String list(Model model) {
        model.addAttribute("todoslist", todoService.getAllTodos());
        return "todoslist";
    }

    @GetMapping(value = "/todo")
    public String listIsActive(@RequestParam(value = "isActive") boolean active, Model model) {
        model.addAttribute("todoslist", todoService.getActiveTodos(active));
        return "todoslist";
    }

    @GetMapping("/add")
    public String createTodo(Model model) {
        model.addAttribute("newTodo", new Todo());
        return "createtodo";
    }

    @PostMapping("/create")
    public String saveTodo(@ModelAttribute Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable(value = "id") Long id) {
        todoService.removeById(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable(value = "id") Long id, Model model) {
        Optional<Todo> todo = todoService.getTodoById(id);
        model.addAttribute("edittodo", todo.get());
        return "editpage";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable(value = "id") Long id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.updateTodo(todo);
        return "redirect:/list";
    }
}
