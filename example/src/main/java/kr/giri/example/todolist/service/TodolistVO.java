package kr.giri.example.todolist.service;

import java.util.Date;

import lombok.Data;
@Data
public class TodolistVO {
private int todoId;
private String todoContent;
private Date todoDate;
}
