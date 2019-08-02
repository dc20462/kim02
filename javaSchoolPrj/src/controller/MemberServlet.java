package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;
import service.MemberDeleteService;
import service.MemberJoinFormService;
import service.MemberJoinService;
import service.MemberListService;
import service.MemberUpdateFormService;
import service.MemberUpdateService;
import service.Service;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Service service=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String command=request.getParameter("command");
		
		if(command.equals("list")) {
			service=new MemberListService();
		}else if(command.equals("joinForm")) {
			service=new MemberJoinFormService();
		}else if(command.equals("join")) {
			service=new MemberJoinService();
		}else if(command.equals("updateForm")) {
			service=new MemberUpdateFormService();
		}else if(command.equals("update")) {
			service=new MemberUpdateService();
		}else if(command.equals("delete")) {
			service=new MemberDeleteService();
		}
		service.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
