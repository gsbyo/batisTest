package com.example.todo.mapper;

import java.util.List;

import com.example.todo.vo.Todo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    
    List<Todo> selectTodoList() throws Exception;
    void insertTodo(Todo todo) throws Exception;
    void deleteTodo(int id) throws Exception;
    void updateTodo(Todo todo) throws Exception;


}
