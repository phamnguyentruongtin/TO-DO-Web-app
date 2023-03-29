package com.example.todowebapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @NotNull(message = "Field can not be null")
    @Column(name = "nameTodo")
    private String nameOfTodo;
    @Column(name = "check_confirm")
    private Long checkConfirm;
    private String deadLine;

    public Todo(String nameOfTodo, Long checkConfirm, String deadLine) {
        this.nameOfTodo = nameOfTodo;
        this.checkConfirm = checkConfirm;
        this.deadLine = deadLine;
    }

    public String getNameOfTodo() {
        return nameOfTodo;
    }

    public void setNameOfTodo(String nameOfTodo) {
        this.nameOfTodo = nameOfTodo;
    }

    public Long getCheckConfirm() {
        return checkConfirm;
    }

    public void setCheckConfirm(Long checkConfirm) {
        this.checkConfirm = checkConfirm;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public Todo() {
    }
}
