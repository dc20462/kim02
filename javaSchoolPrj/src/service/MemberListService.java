package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO dao=MemberDAO.getInstance();
		List<Member> memberList=dao.getMameberAll();
		request.setAttribute("memberList", memberList);
		request.getRequestDispatcher("/member/list.jsp").forward(request, response);
	}

}
