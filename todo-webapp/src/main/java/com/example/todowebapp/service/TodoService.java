package com.example.todowebapp.service;

import com.example.todowebapp.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.todowebapp.repository.ITodoRepository;

@Service
public class TodoService implements ITodoService {
    @Autowired
    private ITodoRepository itodoRepository;

    @Override
    public void createNewTodo(Todo todo) {
        todo.setCheckConfirm(0l);
        itodoRepository.save(todo);
    }

    @Override
    public void confirmFinishTodo(Todo todo) {
        todo.setCheckConfirm(1l);
        itodoRepository.save(todo);
    }

    @Override
    public Page<Todo> findAllTodoListOrByName(String name, PageRequest pageRequest) {
        return itodoRepository.findAllTodoListOrByname(name, pageRequest);
    }


    @Override
    public Todo findTodoByName(String nameTodo) {
        return itodoRepository.findById(nameTodo).get();
    }
}
