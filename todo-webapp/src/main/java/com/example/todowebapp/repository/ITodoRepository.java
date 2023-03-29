package com.example.todowebapp.repository;

import com.example.todowebapp.models.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITodoRepository extends JpaRepository<Todo,String> {
    @Query(value = "select  * from todo where name_todo like %?%",nativeQuery = true)
    Page<Todo> findAllTodoListOrByname(String name, PageRequest page);
}
