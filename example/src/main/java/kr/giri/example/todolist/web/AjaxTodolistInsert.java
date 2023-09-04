package kr.giri.example.todolist.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * Servlet implementation class AjaxTodolistInsert
 */
@WebServlet("/jquery/AjaxTodolistInsert.do")
public class AjaxTodolistInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTodolistInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todoContent = request.getParameter("todoContent");
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		System.out.println(todoContent);
		Date todoDate = null;
		try {
			todoDate = sdf.parse(request.getParameter("todoDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		TodolistVO vo = new TodolistVO();
		vo.setTodoContent(todoContent);
		vo.setTodoDate(todoDate);
		
		TodolistService svc = new TodolistServiceImpl();
		
		boolean add = svc.addTodo(vo);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(add); 
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
