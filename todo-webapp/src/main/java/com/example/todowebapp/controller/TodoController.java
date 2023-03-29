package com.example.todowebapp.controller;

import com.example.todowebapp.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.todowebapp.service.ITodoService;

import javax.validation.Valid;
import java.sql.Date;

@RestController
public class TodoController {
    @Autowired
    private ITodoService itodoService;

    @GetMapping("/todolist")
    public ModelAndView todoList(@RequestParam(defaultValue = "") String nameTodoList, @RequestParam(defaultValue = "0") int page) {
        Page<Todo> listTodosPage = itodoService.findAllTodoListOrByName(nameTodoList, PageRequest.of(page, 5));
        Todo todo = new Todo();
        ModelAndView modelAndView = new ModelAndView("Todo")
                .addObject("listTodosPage", listTodosPage)
                .addObject("todo", todo);
        return modelAndView;
    }

    @PostMapping("/new-todo")
    public ModelAndView newTodo(@Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("Todo");
            return modelAndView;
        }
        itodoService.createNewTodo(todo);
        ModelAndView modelAndView = new ModelAndView("redirect:/todolist");
        return modelAndView;
    }

    @GetMapping("checkconfirm")
    public ModelAndView checkConfirm(String nameTodo, RedirectAttributes redirectAttributes) {
        Todo confirmTodo = itodoService.findTodoByName(nameTodo);
        itodoService.confirmFinishTodo(confirmTodo);
        String sms = "Congratulation you !!!";
        redirectAttributes.addFlashAttribute("sms", sms);
        ModelAndView modelAndView = new ModelAndView("redirect:/todolist");
        return modelAndView;
    }
}
