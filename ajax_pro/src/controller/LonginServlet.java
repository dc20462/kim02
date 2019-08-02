package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * Servlet implementation class LonginServlet
 */
@WebServlet("*.do")
public class LonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LonginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request,response);
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		MemberDAO dao=MemberDAO.getInstance();
		int result=dao.login(id, pw);
		PrintWriter out=response.getWriter();
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	 
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		if(command.equals("/idchk.do")) {
			System.out.println("aaabbbb");
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			MemberDAO dao=MemberDAO.getInstance();
			int result=dao.login(id, pw);
			HttpSession session=request.getSession();
			if(result==1) {
				session.setAttribute("id",id);
			}
			PrintWriter out=response.getWriter();
			out.println(result);
		}else if(command.contentEquals("/logout.do")) {
			HttpSession session=request.getSession();
			session.invalidate();
		}
	}

}
