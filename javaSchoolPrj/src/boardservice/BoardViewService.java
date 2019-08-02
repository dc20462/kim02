package boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;

public class BoardViewService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno=Integer.parseInt(request.getParameter("bno"));
        int page=Integer.parseInt(request.getParameter("page"));
		BoardDAO bDao=BoardDAO.getInstance();
		
		Board board=bDao.getBoard(bno);
		if(board !=null) {
			bDao.read_count_update(bno);
		}
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/board/view.jsp")
		.forward(request, response);
	}

}
