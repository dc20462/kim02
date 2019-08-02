package mainService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dao.SchoolMemberDAO;
import dto.Member;
import dto.SchoolMember;

public class MainMemberUpdateFormService implements MainService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SchoolMemberDAO dao=SchoolMemberDAO.getInstance();
		String id=(String)   session.getParameter("id");
		Member member=dao.getMember(id);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/member/update.jsp").forward(request, response);
	}

}
