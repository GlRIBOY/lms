package kr.giri.example.todolist.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.giri.example.common.DataSources;
import kr.giri.example.todolist.mapper.TodolistMapper;
import kr.giri.example.todolist.service.TodolistService;
import kr.giri.example.todolist.service.TodolistVO;

public class TodolistServiceImpl implements TodolistService {
private SqlSession sqlSession = DataSources.getInstance().openSession(true);
private TodolistMapper map = sqlSession.getMapper(TodolistMapper.class);
	@Override
	public boolean addTodo(TodolistVO vo) {
		return map.insert(vo)==1;
	}

	@Override
	public boolean delTodo(int todoId) {
		// TODO Auto-generated method stub
		return map.delete(todoId)==1;
	}

	@Override
	public List<TodolistVO> todoList() {
		return map.selectList();
	}

}
