package com.example.todowebapp.service;

import com.example.todowebapp.models.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface ITodoService {
    void createNewTodo(Todo todo);
    void confirmFinishTodo(Todo todo);
    Page<Todo> findAllTodoListOrByName(String name, PageRequest page);
    Todo findTodoByName(String nameTodo);
    void deleteAll();
}
