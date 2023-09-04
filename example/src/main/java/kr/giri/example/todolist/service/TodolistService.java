package kr.giri.example.todolist.service;

import java.util.List;

public interface TodolistService {
	public boolean addTodo(TodolistVO vo);
	public boolean delTodo(int todoId);
	//public TodolistVO getTodo(int todoId); 
	public List<TodolistVO> todoList();
}
