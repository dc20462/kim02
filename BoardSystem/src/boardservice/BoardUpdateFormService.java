package boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;

public class BoardUpdateFormService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=Integer.parseInt(request.getParameter("page"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		BoardDAO bDao=BoardDAO.getInstance();
		Board board=bDao.getBoard(bno);
		System.out.println("!!!!!!!"+board);
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		request.getRequestDispatcher("board/update.jsp")
		.forward(request, response);
	}

}
