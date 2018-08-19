package com.greenfoxcompany.connectionwithmysql.services;

import com.greenfoxcompany.connectionwithmysql.models.Todo;
import com.greenfoxcompany.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public List<Todo> getActiveTodos(boolean active) {
        List<Todo> todos = new ArrayList<>();
        if (active == true) {
            todoRepository.findByDoneFalse().forEach(todos::add);
        } else {
            todoRepository.findByDoneTrue().forEach(todos::add);
        }
        return todos;
    }

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void removeById(Long id) {
        todoRepository.deleteById(id);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
