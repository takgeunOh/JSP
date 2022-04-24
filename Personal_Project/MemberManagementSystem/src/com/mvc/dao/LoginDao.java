package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.comstudy21.jdbcutil.JdbcUtil;

import com.mvc.bean.LoginBean;

public class LoginDao {
	public String authorizeLogin(LoginBean loginBean) {
		String id = loginBean.getId();
		String pw = loginBean.getPw();
		
		String dbid="";
		String dbpw="";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareCall("select * from member2 where id=? and pw=?");
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				dbid = rs.getString("id");
				dbpw=rs.getString("pw");
				
				if(id.equals(dbid) && pw.equals(dbpw)) {
					return "SUCCESS LOGIN";
				}
			}
			
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "WRONG ID AND PW";
	}
}
