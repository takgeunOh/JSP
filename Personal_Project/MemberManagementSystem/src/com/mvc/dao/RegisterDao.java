package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.comstudy21.jdbcutil.JdbcUtil;

import com.mvc.bean.RegisterBean;

public class RegisterDao {
	public String authorizeRegister(RegisterBean registerBean) {
		int no = registerBean.getNo();
		String id = registerBean.getId();
		String pw = registerBean.getPw();
		String email = registerBean.getEmail();
		String regidate = registerBean.getRegidate();
		System.out.println(id);
		System.out.println(pw);
		System.out.println(email);
		System.out.println(regidate);
		
		try {
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into member2 values (?,?,?,?,?)");
			stmt.setInt(1, no);
			stmt.setString(2, id);
			stmt.setString(3, pw);
			stmt.setString(4, email);
			stmt.setString(5, regidate);
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
			return "SUCESS REGISTER";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "FAIL REGISTER";
	}
}
