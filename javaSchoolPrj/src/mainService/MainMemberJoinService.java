package mainService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dao.SchoolMemberDAO;
import dto.Member;
import dto.SchoolMember;

public class MainMemberJoinService implements MainService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SchoolMember member=new SchoolMember();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setJumin(request.getParameter("jumin"));
		member.setAddress(request.getParameter("address"));
		member.setTel(request.getParameter("tel"));
		member.setType(request.getParameter("type"));
		SchoolMemberDAO dao=SchoolMemberDAO.getInstance();
		
		if(dao.insertMember(member)==1) {
			System.out.println("join_ok");
			request.setAttribute("msg","success");
		}else {
			System.out.println("join_error");
			request.setAttribute("msg","error");
		}
		request.getRequestDispatcher("/main/mainView.jsp").forward(request, response);
	}

}
