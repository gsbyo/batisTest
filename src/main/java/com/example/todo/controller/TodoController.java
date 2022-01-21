package com.example.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.todo.service.TodoService;
import com.example.todo.vo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    
    @GetMapping("/test")
    public ModelAndView test() throws Exception{
       ModelAndView mv = new ModelAndView();

       List<Todo> todos = todoService.selectTodoList();
       mv.addObject("list", todos);

       mv.setViewName("test");
       return mv;
    }

      
    @PostMapping("/test")
    public void Todo(Todo todo) throws Exception{
        todoService.insertTodo(todo);
    }

    @DeleteMapping("/test")
    public String Todo_Del(HttpServletRequest req) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
       
        todoService.deleteTodo(id);

        return "success";
    }

    @PutMapping("/test")
    public String Todo_Edit(Todo todo) throws Exception{

        if(todo.getDay() == ""){
            return "fail";
        }
        
        todoService.updateTodo(todo);

        return "success";
    }
    
    
}
