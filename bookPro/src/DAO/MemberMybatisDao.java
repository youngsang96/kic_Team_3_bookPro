package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnection;
import model.Member;




public class MemberMybatisDao {
	
	private static final String ns = "member.";
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public int MemberInsert(Member member) {
		SqlSession session = MybatisConnection.getConnection();
		
		try {
			session.insert(ns + "memberInsert", member);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		
		return 0;
	}
	
     public List<Member> memberList() {
    	SqlSession session = MybatisConnection.getConnection();
 		 		
 		try {
 			
			return session.selectList(ns + "memberList");
				
		} catch (Exception e) {			
			e.printStackTrace();		
		} finally {
		    MybatisConnection.close(session);		
	    }		
		return null;	
		}
     
     public Member selectOne(String id) {
        SqlSession session = MybatisConnection.getConnection();
        
        try {
			return session.selectOne(ns+"selectOne",id);
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		MybatisConnection.close(session);		
	}
	return null;
	}

     public int  MemberUpdate(Member member) {
    	 SqlSession session = MybatisConnection.getConnection();
 		
 		try {
 			session.update(ns+"memberUpdate",member);
 			return 1;
 		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
 			MybatisConnection.close(session);
 		}
 		return 0;
     }
     
     public int  MemberDelete(String id, String pass) {
    	 SqlSession session = MybatisConnection.getConnection();
 		
 		try {
 			map.clear();
 			map.put("memberid", id);
 			map.put("pass", pass);
 			session.delete(ns+"memberDelete",map);
 			return 1;
 		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
 			MybatisConnection.close(session);
 		}
 		return 0;
     }  
}