package boardservice;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.Board;

public class BoardWriteService implements BoardService {

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
		
		board.setMember_id(multi.getParameter("member_id"));
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content")); 
		/*
		 * Enumeration<String> files=multi.getFileNames();
		 * while(files.hasMoreElements()) { String file=files.nextElement();
		 * multi.getFilesystemName(file); }
		 */
		
		board.setFilename(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.boardWrite(board);
		response.sendRedirect("boardList.do");
		
	}

}
