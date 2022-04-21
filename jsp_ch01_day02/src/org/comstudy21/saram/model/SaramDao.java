package org.comstudy21.saram.model;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.saram.dbcp.JdbcUtil;
/*
create table saram(
no number not null,
name varchar2(20) not null,
phone varchar2(15),
email varchar2(50)
)
 */
public class SaramDao {
	final String SQL_INSERT = "insert into saram values((select max(nvl(no,0))+1 from saram), ?, ?, ?)";
	final String SQL_SELECT_ALL = "SELECT * FROM SARAM ORDER BY NO";
	final String SQL_SELECT_NO = "SELECT * FROM SARAM WHERE NO=?";
	final String SQL_SELECT_NAME = "SELECT * FROM SARAM WHERE NAME=?";
	final String SQL_UPDATE = "UPDATE SARAM SET NAME=?, PHONE=?, EMAIL=? WHERE NO=?";
	final String SQL_DELETE = "DELETE FROM SARAM WHERE NO=?";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void insert(SaramDto dto) {
		//System.out.println("입력 사람" + dto.getName());
		//System.out.println("입력 폰번호" + dto.getPhone());
		//System.out.println("입력 이메일" + dto.getEmail());
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getPhone());
			stmt.setString(3, dto.getEmail());
			
			int cnt = stmt.executeUpdate();
			if(cnt> 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}
	public List<SaramDto> selectAll() {
		ArrayList<SaramDto> list = new ArrayList<SaramDto>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int no  = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				list.add(new SaramDto(no, name, phone, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return list;
	}
	public SaramDto selectByNo(String no) {
		SaramDto dto = new SaramDto();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_NO);
			stmt.setString(1, no);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs.next()) {
				dto.setNo(Integer.parseInt(rs.getString("no")));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, stmt, rs);
		
		return dto;
	}
	public SaramDto update(SaramDto dto) {
		SaramDto resultDto = new SaramDto();
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getPhone());
			stmt.setString(3, dto.getEmail());
			stmt.setInt(4, dto.getNo());
			ResultSet rs = stmt.executeQuery();
			int cnt = stmt.executeUpdate();
			
			resultDto.setName(rs.getString("name"));
			resultDto.setPhone(rs.getString("phone"));
			resultDto.setEmail(rs.getString("email"));
			
			if(cnt>0)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, stmt, rs);
		
		return resultDto;
		
	}
	public void delete(SaramDto dto) {
		
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, dto.getNo());
			// ResultSet rs = stmt.executeQuery();
			int cnt = stmt.executeUpdate();
			
			
			if(cnt>0)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, stmt, rs);
	}
	public SaramDto selectByName(SaramDto dto) {
		
		return null;
	}
}
