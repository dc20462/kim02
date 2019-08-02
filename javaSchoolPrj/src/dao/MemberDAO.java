package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO mDao=new MemberDAO();
	public static MemberDAO getInstance() {
		return mDao;
	}
	
	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member values(?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2,member.getPw());
			ps.setString(3,member.getName());
			ps.setString(4,member.getGender());
			ps.setString(5,member.getAddr());
			ps.setString(6,member.getTel());

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
	public List<Member> getMameberAll(){
		List<Member> list=new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Member member=new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
				list.add(member);
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
	public Member getMember(String id) {
		Member member=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				member=new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return member;		
	}
	public void update(Member member) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member set pw=?,gender=?,addr=?,tel=? where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getGender());
			ps.setString(3, member.getAddr());
			ps.setString(4, member.getTel());
			ps.setString(5, member.getId());
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
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
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

}
