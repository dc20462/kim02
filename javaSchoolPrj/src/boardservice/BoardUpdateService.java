package boardservice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.Board;

public class BoardUpdateService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Board board=new Board();
		String saveFolder="/upload";
		int maxSize=5*1024*1024;
		ServletContext context=request.getServletContext();
		String realFolder=context.getRealPath(saveFolder);
		System.out.println("realFolder:"+realFolder);
		MultipartRequest multi=new MultipartRequest(
				request,
				realFolder,
				maxSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		board.setBno(Integer.parseInt(multi.getParameter("bno")));
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		String filename=multi.getFilesystemName("filename");
		
		if(filename==null) {
			board.setFilename(multi.getParameter("nonMakeImg"));
		}else{
			board.setFilename(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		}
		String page=multi.getParameter("page");
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.boardUpdate(board);
		response.sendRedirect("boardList.do?page="+page);
	}

}
