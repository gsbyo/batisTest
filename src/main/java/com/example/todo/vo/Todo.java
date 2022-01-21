package com.example.todo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class Todo {

    private int id;
    private String day;
    private String work;

}
