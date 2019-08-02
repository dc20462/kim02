package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardservice.BoardDeleteService;
import boardservice.BoardListPageService;
import boardservice.BoardListService;
import boardservice.BoardService;
import boardservice.BoardUpdateFormService;
import boardservice.BoardUpdateService;
import boardservice.BoardViewService;
import boardservice.BoardWriteFormService;
import boardservice.BoardWriteService;
import dao.MemberDAO;
import dao.SchoolMemberDAO;
import mainService.MainMemberJoinService;
import mainService.MainMemberUpdateFormService;
import mainService.MainMemberUpdateService;
import mainService.MainService;
import mainService.MainViewService;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("*.main") 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainService service=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getRequestURI());
		doProcess(request,response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		if(command.equals("/idchk.main")) {
			String id=request.getParameter("id");
			SchoolMemberDAO dao=SchoolMemberDAO.getInstance();
			int result=dao.chkId(id);
			System.out.println(result);
			PrintWriter out=response.getWriter();
			out.println(result);
		}else if(command.equals("/login.main")) {
			System.out.println("aaabbbb");
			String id=request.getParameter("id"); 
			String pw=request.getParameter("pw");
			SchoolMemberDAO dao=SchoolMemberDAO.getInstance();
			int result=dao.login(id, pw);
			String name=dao.getUserName(id);
			HttpSession session=request.getSession();
			if(result==1) {   
				session.setAttribute("user_id",id);
				session.setAttribute("user_name",name);
			}
			PrintWriter out=response.getWriter();
			out.println(result);
		}else if(command.contentEquals("/logout.main")) {
			HttpSession session=request.getSession();
			session.invalidate();
			PrintWriter out=response.getWriter();
			out.println(1);
		}else {
			
			if(command.equals("/mainView.main")) {
				service=new MainViewService();
				 
			}else if(command.equals("/join.main")) {
				service=new MainMemberJoinService(); 
			}else if(command.equals("/member_updateFrom.main")) {
				service=new MainMemberUpdateFormService();
			}else if(command.equals("/member_update.main")) {
				service=new MainMemberUpdateService();
			}
				
			service.execute(request, response);
		}
		
		
	
		
			
	}
}
