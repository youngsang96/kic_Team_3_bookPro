package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberMybatisDao;
import model.Member;
import oracle.sql.DATE;

public class BookController extends Action {
	
	//1. main화면 출력
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/view/main.jsp";
	}
	
	//2. 회원가입 페이지로 가기
	public String memberInput(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		return "/view/member/memberInput.jsp";
	}
	
	
	//3. 회원가입 처리
	public String memberInputPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberMybatisDao dao = new MemberMybatisDao();
		Member m = new Member();
		
		
		request.setCharacterEncoding("UTF-8");
		m.setMemberid(request.getParameter("memberid"));
		m.setPass(request.getParameter("pass"));
		m.setName(request.getParameter("name"));
		m.setBirthday(request.getParameter("birthday"));
		m.setGender(request.getParameter("gender"));
		m.setTel(request.getParameter("tel"));
		m.setEmail(request.getParameter("email"));
		int num = dao.MemberInsert(m);
		
		System.out.println(num + "개 저장됨.");
		request.setAttribute("member", m);
		if(num != 1) {
			request.setAttribute("url", "/book/memberInput");
			request.setAttribute("msg", "회원가입에 실패하였습니다");
			
		}else {
			request.setAttribute("url", "/book/loginForm");
			request.setAttribute("msg", "회원가입에 성공하였습니다");
		}
		return "/view/alert.jsp";	
	}
	
	
	
	//4. 로그인 페이지로 가기
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/view/member/loginForm.jsp";
	}
	
	//5. 로그인 처리
	public String loginPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("memberid");
		String pass = request.getParameter("pass");
		MemberMybatisDao dao = new MemberMybatisDao();
		Member member = dao.selectOne(id);
		
		String msg = "아이디를 확인하세요";
		String url = "/view/loginForm.jsp";
		
		if(member != null) {
			if(pass.equals(member.getPass())) {
				request.getSession().setAttribute("login", id);
				msg=member.getName() + "님이 로그인 하셨습니다.";
				url = "book/main";
		}else {
				msg="비밀번호를 확인하세요.";
				url = "book/loginForm";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	//로그아웃
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		return "/view/main.jsp";
	}
	
	
	//멤버리스트 
	
	public String memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 2)
		MemberMybatisDao dao = new MemberMybatisDao();
		String id = (String) request.getSession().getAttribute("login");
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		if (id != null && id.equals("admin")) {
			List<Member> mlist = dao.memberList();
			// 4) jsp 보여주는 자료를 보내는것
			request.setAttribute("mlist", mlist);
			// 5) view (jsp) : el , jstl
			return "/view/member/memberList.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";

	}
	
	
	
	//회원 정보
	
	public String memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userid = request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("login");
		MemberMybatisDao dao = new MemberMybatisDao();
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		
		if (id != null) {
			if (id.equals("admin")) {
				Member member = dao.selectOne(userid);
				request.setAttribute("member", member);
				return "/view/member/memberInfo.jsp";
			} else {
				Member member = dao.selectOne(id);
				request.setAttribute("member", member);
				return "/view/member/memberInfo.jsp";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 2)
		String userid = request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("login");
		MemberMybatisDao dao = new MemberMybatisDao();
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		if (id != null) { // login 되어있음
			if (id.equals("admin")) { // login id가 admin
				Member member = dao.selectOne(userid);
				request.setAttribute("member", member);
				return "/view/member/memberUpdate.jsp";
			} else { // admin 이 아닌 유저
				Member member = dao.selectOne(id);
				request.setAttribute("member", member);
				return "/view/member/memberUpdate.jsp";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	public String memberUpdatePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("login");
		Member mem = new Member();
		MemberMybatisDao dao = new MemberMybatisDao();
		mem.setName(request.getParameter("name"));
		mem.setPass(request.getParameter("pass"));
		mem.setBirthday(request.getParameter("birthday"));
		mem.setGender(request.getParameter("gender"));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
	
		String msg = "수정 할 수 없습니다";
		String url = "member/main";
		int num = 0;
		if (id != null) {
			if (id.equals("admin")) {
				mem.setMemberid(userid);
				url = "book/memberList";
			} else {
				mem.setMemberid(id);
				url = "book/memberInfo";
			}
			num = dao.MemberUpdate(mem);
		}
		
		System.out.println(num);
		if (num==1) {
			msg="수정되었습니다 ";
			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	public String memberDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userid = request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("login");
		MemberMybatisDao dao = new MemberMybatisDao();
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		if(id !=null) { //login 되어있음
			if(id.equals("admin")) {
			Member member = dao.selectOne(userid);
			request.setAttribute("member", member);
 			return "/view/member/deleteForm.jsp";
		} else{ // admin이 아닌 유저
			Member member = dao.selectOne(id);
			request.setAttribute("member", member);
			return "/view/member/deleteForm.jsp";
			}
		}		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);		
		return "/view/alert.jsp";
	}
	public String memberDeletePro(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String id = (String) request.getSession().getAttribute("login");
		MemberMybatisDao dao = new MemberMybatisDao();
		String msg = "탈퇴 할 수 없습니다";
		String url = "book/main";
		int num = 0;
		if(id!=null) {
			if(id.equals("admin")) {
				num = dao.MemberDelete(userid, pass); 
				url = "book/memberList";
			} else {
				num = dao.MemberDelete(id, pass);
				request.getSession().invalidate(); //일반 유저일 경우 삭제 후 로그아웃
				url = "book/main";
			}
		}
		System.out.println(num);
		if(num==1) {msg="탈퇴 하였습니다.";}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	//사이트맵 화면 띄우기
	public String siteMap(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/view/member/siteMap.jsp";
	
	}
	
}