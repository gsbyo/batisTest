package com.example.todo.service;

import java.util.List;

import com.example.todo.vo.Todo;



public interface TodoService {
    
    List<Todo> selectTodoList() throws Exception;

    void insertTodo(Todo todo) throws Exception;

    void deleteTodo(int id) throws Exception;

    void updateTodo(Todo todo) throws Exception;

}
