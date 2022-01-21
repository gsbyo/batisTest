package com.example.todo.service;

import java.util.List;

import com.example.todo.mapper.TodoMapper;
import com.example.todo.vo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<Todo> selectTodoList() throws Exception{
        return todoMapper.selectTodoList();
    }

    @Override
    public void insertTodo(Todo todo) throws Exception{
        todoMapper.insertTodo(todo);
    }

    @Override
    public void deleteTodo(int id) throws Exception{
        todoMapper.deleteTodo(id);
    }

    @Override 
    public void updateTodo(Todo todo) throws Exception{
        todoMapper.updateTodo(todo);
    }
    
}
