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
	
	//1. mainȭ�� ���
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/view/main.jsp";
	}
	
	//2. ȸ������ �������� ����
	public String memberInput(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		return "/view/member/memberInput.jsp";
	}
	
	
	//3. ȸ������ ó��
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
		
		System.out.println(num + "�� �����.");
		request.setAttribute("member", m);
		if(num != 1) {
			request.setAttribute("url", "/book/memberInput");
			request.setAttribute("msg", "ȸ�����Կ� �����Ͽ����ϴ�");
			
		}else {
			request.setAttribute("url", "/book/loginForm");
			request.setAttribute("msg", "ȸ�����Կ� �����Ͽ����ϴ�");
		}
		return "/view/alert.jsp";	
	}
	
	
	
	//4. �α��� �������� ����
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/view/member/loginForm.jsp";
	}
	
	//5. �α��� ó��
	public String loginPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("memberid");
		String pass = request.getParameter("pass");
		MemberMybatisDao dao = new MemberMybatisDao();
		Member member = dao.selectOne(id);
		
		String msg = "���̵� Ȯ���ϼ���";
		String url = "/view/loginForm.jsp";
		
		if(member != null) {
			if(pass.equals(member.getPass())) {
				request.getSession().setAttribute("login", id);
				msg=member.getName() + "���� �α��� �ϼ̽��ϴ�.";
				url = "book/main";
		}else {
				msg="��й�ȣ�� Ȯ���ϼ���.";
				url = "book/loginForm";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	//�α׾ƿ�
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		return "/view/main.jsp";
	}
	
	
	//�������Ʈ 
	
	public String memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 2)
		MemberMybatisDao dao = new MemberMybatisDao();
		String id = (String) request.getSession().getAttribute("login");
		String msg = "ȸ�������� Ȯ�� �� �� �����ϴ�";
		String url = "member/loginForm";
		if (id != null && id.equals("admin")) {
			List<Member> mlist = dao.memberList();
			// 4) jsp �����ִ� �ڷḦ �����°�
			request.setAttribute("mlist", mlist);
			// 5) view (jsp) : el , jstl
			return "/view/member/memberList.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";

	}
	
	
	
	//ȸ�� ����
	
	public String memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userid = request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("login");
		MemberMybatisDao dao = new MemberMybatisDao();
		String msg = "ȸ�������� Ȯ�� �� �� �����ϴ�";
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
		String msg = "ȸ�������� Ȯ�� �� �� �����ϴ�";
		String url = "member/loginForm";
		if (id != null) { // login �Ǿ�����
			if (id.equals("admin")) { // login id�� admin
				Member member = dao.selectOne(userid);
				request.setAttribute("member", member);
				return "/view/member/memberUpdate.jsp";
			} else { // admin �� �ƴ� ����
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
	
		String msg = "���� �� �� �����ϴ�";
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
			msg="�����Ǿ����ϴ� ";
			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	public String memberDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userid = request.getParameter("userid");
		String id = (String) request.getSession().getAttribute("login");
		MemberMybatisDao dao = new MemberMybatisDao();
		String msg = "ȸ�������� Ȯ�� �� �� �����ϴ�";
		String url = "member/loginForm";
		if(id !=null) { //login �Ǿ�����
			if(id.equals("admin")) {
			Member member = dao.selectOne(userid);
			request.setAttribute("member", member);
 			return "/view/member/deleteForm.jsp";
		} else{ // admin�� �ƴ� ����
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
		String msg = "Ż�� �� �� �����ϴ�";
		String url = "book/main";
		int num = 0;
		if(id!=null) {
			if(id.equals("admin")) {
				num = dao.MemberDelete(userid, pass); 
				url = "book/memberList";
			} else {
				num = dao.MemberDelete(id, pass);
				request.getSession().invalidate(); //�Ϲ� ������ ��� ���� �� �α׾ƿ�
				url = "book/main";
			}
		}
		System.out.println(num);
		if(num==1) {msg="Ż�� �Ͽ����ϴ�.";}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	//����Ʈ�� ȭ�� ����
	public String siteMap(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/view/member/siteMap.jsp";
	
	}
	
}