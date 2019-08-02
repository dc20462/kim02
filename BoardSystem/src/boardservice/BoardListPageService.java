package boardservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.Board;
import dto.PageMaker;

public class BoardListPageService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String spage=request.getParameter("page");
		if(spage==null) {
			spage="1";
		}
		int page=Integer.parseInt(spage);
		BoardDAO bDao=BoardDAO.getInstance();
		int totalCount=bDao.getTotalCount();
		PageMaker pageMaker=new PageMaker(page,totalCount);
		List<Board> boardList=bDao.getBoardPage(pageMaker.getStart(),pageMaker.getPageSize());
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageMaker", pageMaker);
		request.getRequestDispatcher("/board/boardList.jsp")
		.forward(request, response);
	}

}
