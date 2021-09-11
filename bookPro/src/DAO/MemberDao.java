package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import util.DBConnection;

public class MemberDao {
	
	//1. 테이블에 삽입
	public int MemberInsert(Member member){
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPass());
			pstmt.setString(4,  member.getBirthday());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getTel());
			pstmt.setString(7, member.getEmail());		
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		return 0;
	}
	
	//2. 테이블에 있는 값 리스트로 저장
	public List<Member> memberList(){
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		List<Member> li = new ArrayList<Member>();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Member member = new Member();
					member.setMemberid(rs.getString("memberid"));
					member.setName(rs.getString("name"));
					member.setPass(rs.getString("pass"));
					member.setBirthday(rs.getString("birthday"));
					member.setGender(rs.getString("gender"));
					member.setTel(rs.getString("tel"));
					member.setEmail(rs.getString("email"));
					li.add(member);
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(con, pstmt, null);
			} return li;
		}
	
	//sql테이블에 삽입된 값 member.java에 set
	public Member selectOne(String memberid) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid=?";
		Member member = new Member();
		
		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, memberid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					member.setMemberid(rs.getString("memberid"));
					member.setPass(rs.getString("pass"));
					member.setName(rs.getString("name"));
					member.setBirthday(rs.getString("birthday"));
					member.setGender(rs.getString("gender"));
					member.setTel(rs.getString("tel"));
					member.setEmail(rs.getString("email"));
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(con, pstmt, rs);
			}
		    System.out.println(member);
			return member; 
	}
	
	
	public int MemberUpdate(Member member) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update member set name=?, gender=?, birthday=?,"+
		"tel=?, email =? where memberid=? and pass=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getGender());
			pstmt.setString(3,  member.getBirthday());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getMemberid());
			pstmt.setString(7, member.getPass());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, null);
		}
		return 0;
	}
		
	public int MemberDelete(String memberid, String pass) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from member where memberid=? and pass=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberid);
			pstmt.setString(2, pass);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, null);
		} return 0;
	}
}