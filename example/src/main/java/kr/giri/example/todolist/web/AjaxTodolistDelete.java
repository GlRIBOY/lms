package kr.giri.example.todolist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.giri.example.todolist.service.TodolistService;
import kr.giri.example.todolist.serviceImpl.TodolistServiceImpl;

/**
 * Servlet implementation class AjaxTodolistDelete
 */
@WebServlet("/jquery/AjaxTodolistDelete.do")
public class AjaxTodolistDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTodolistDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodolistService svc = new TodolistServiceImpl();
		boolean del = svc.delTodo(Integer.parseInt(request.getParameter("todoId")));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(del); 
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
