package boardservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;

public class BoardListService implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO bDao=BoardDAO.getInstance();
		List<Board> boardList=bDao.getBoardAll();
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/board/boardList.jsp")
		.forward(request, response);
	}

}
