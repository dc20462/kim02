package boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class ReplyDeleteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
		int rno=Integer.parseInt(request.getParameter("rno"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.replyDelete(rno);
		response.sendRedirect("boardView.do?bno="+bno+"&page="+page);
	}

}
