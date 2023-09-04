package kr.giri.example.todolist.mapper;

import java.util.List;

import kr.giri.example.todolist.service.TodolistVO;

public interface TodolistMapper {
	public int insert(TodolistVO vo);
	public int delete(int todoId);
	//public TodolistVO select(int todoId); 
	public List<TodolistVO> selectList();
}
