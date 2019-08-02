package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Board;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO dao=new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	public int getTotalCount() {
		int n=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from board";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				n=rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return n;
	}
	
	public List<Board> getBoardPage(int start, int size){
		List<Board> list=new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//String sql = "select * from board order by bno desc limit?,?"; //mysql
		String sql="select * from "
		+"(select /*+index_desc(BOARD_BNO_IDX)*/ rownum as rn, "
		+"a.bno, a.member_id, a.title, a.content, a.write_date, a.read_count,"
		+ "a.reply_count,a.filename "
		+"from (select * from board order by bno desc) a "
		+"where rownum<=?)b "
		+"where b.rn>=?";
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start+size);
			ps.setInt(2, start+1);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board=new Board();
				board.setBno(rs.getInt("bno"));
				board.setMember_id(rs.getString("member_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(rs.getTimestamp("write_date"));
				board.setRead_count(rs.getInt("read_count"));
				board.setReply_count(rs.getInt("reply_count"));
				board.setFilename(rs.getString("filename"));
				list.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}
	
	public List<Board> getBoardAll(){
		List<Board> list=new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Board board=new Board();
				board.setBno(rs.getInt("bno"));
				board.setMember_id(rs.getString("member_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(rs.getTimestamp("write_date"));
				board.setRead_count(rs.getInt("read_count"));
				board.setReply_count(rs.getInt("reply_count"));
				board.setFilename(rs.getString("filename"));
				list.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}
	
	public void boardWrite(Board board) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into board(bno, member_id, title, content, filename) "
				+ "values(board_seq.nextval,?,?,?,?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getMember_id());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			ps.setString(4, board.getFilename());
			int n = ps.executeUpdate();
			if(n==1) {
				conn.commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public Board getBoard(int bno) {
		Board board=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);

			rs = ps.executeQuery();
			while (rs.next()) {
				board=new Board();
				board.setBno(rs.getInt("bno"));
				board.setMember_id(rs.getString("member_id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWrite_date(rs.getTimestamp("write_date"));
				board.setRead_count(rs.getInt("read_count"));
				board.setReply_count(rs.getInt("reply_count"));
				board.setFilename(rs.getString("filename"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return board;
	}
	public void read_count_update(int bno) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update board set read_count=read_count+1 where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				//conn.commit();
				DBConn.commit(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public void boardUpdate(Board board) {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println(board);
		String sql = "update board set title=?, content=?, filename=? where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1,board.getTitle());
			ps.setString(2,board.getContent());
			ps.setString(3,board.getFilename());
			ps.setInt(4, board.getBno());

			int n = ps.executeUpdate();
			if(n==1) {
				DBConn.commit(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	public void boardDelete(int bno) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from board where bno=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				DBConn.commit(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}

}
