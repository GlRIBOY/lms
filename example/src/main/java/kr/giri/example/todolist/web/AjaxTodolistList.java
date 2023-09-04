package kr.giri.example.todolist.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.giri.example.todolist.service.TodolistService;
import kr.giri.example.todolist.service.TodolistVO;
import kr.giri.example.todolist.serviceImpl.TodolistServiceImpl;

@WebServlet("/jquery/AjaxTodolistList.do")
public class AjaxTodolistList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxTodolistList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object> map = new HashMap<>();
		
		TodolistService svc = new TodolistServiceImpl();
		List<TodolistVO> list = svc.todoList();
		map.put("data", list);
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
