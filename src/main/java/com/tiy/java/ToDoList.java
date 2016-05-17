package com.tiy.java;

import javax.persistence.*;

/**
 * Created by Justins PC on 5/17/2016.
 */
@Entity
@Table(name = "todolist")
public class ToDoList {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @Column(nullable = false)
    boolean isdone;

    public ToDoList() {

    }
    public ToDoList(String text, Boolean isdone) {
        this.text = text;
        this.isdone = isdone;
    }

}
