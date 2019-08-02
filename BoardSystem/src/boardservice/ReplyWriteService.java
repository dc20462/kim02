package boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Reply;

public class ReplyWriteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
		Reply reply=new Reply();
		reply.setBno(Integer.parseInt(request.getParameter("bno")));
		reply.setMember_id(request.getParameter("member_id"));
		reply.setContent(request.getParameter("content"));
		BoardDAO dao=BoardDAO.getInstance();
		dao.replyWrite(reply);
		response.sendRedirect("boardView.do?bno="+reply.getBno()+"&page="+page);
	}

}
