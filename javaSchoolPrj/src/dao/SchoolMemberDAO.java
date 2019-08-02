package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.SchoolMember;

public class SchoolMemberDAO {
	private SchoolMemberDAO() {}
	private static SchoolMemberDAO mDao=new SchoolMemberDAO();
	public static SchoolMemberDAO getInstance() {
		return mDao;
	}
	
	public int insertMember(SchoolMember member) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into tbl_member values(?,?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2,member.getPw());
			ps.setString(3,member.getName());
			ps.setString(4,member.getJumin());
			ps.setString(5,member.getAddress());
			ps.setString(6,member.getTel());
			ps.setString(7,member.getType());
			
			n = ps.executeUpdate();
			if(n==1) {
				DBConn.commit(conn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return n;
	}
	public List<SchoolMember> getMameberAll(){
		List<SchoolMember> list=new ArrayList<SchoolMember>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_member";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SchoolMember member=new SchoolMember();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setJumin(rs.getString("jumin"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));
				member.setType(rs.getString("Type"));
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
	public SchoolMember getMember(String id) {
		SchoolMember member=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				member=new SchoolMember();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setJumin(rs.getString("jumin"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));
				member.setType(rs.getString("Type"));
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
	public void update(SchoolMember member) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tbl_member set pw=?,jumin=?,address=?,tel=?,type=? where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getJumin());
			ps.setString(3, member.getAddress());
			ps.setString(4, member.getTel());
			ps.setString(5, member.getType());
			ps.setString(6, member.getId());
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
		String sql = "delete from tbl_member where id=?";
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
	
	public int chkId(String id) {
		int n=-1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				n=1;
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
	
	public int login(String id, String pw) {
		int result=-1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from tbl_member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbPw=rs.getString(1);
				if(pw.equals(dbPw)) {
					result=1;
				}else {
					result=0;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return result;
	}
	
	public String getUserName(String id) {
		String name="";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_member where id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return name;
	}
}
