package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.comstudy21.jdbcutil.JdbcUtil;

public class MemberDao {
	final String SQL_INSERT = "insert into member2 values(seq_no.NEXTVAL, ?, ?, ?, ?)";
	final String SQL_SELECT_ALL = "SELECT * FROM member2";
	final String SQL_SELECT_NO = "SELECT * FROM member2 WHERE NO=?";
	final String SQL_SELECT_ID = "SELECT * FROM member2 WHERE ID=?";
	final String SQL_UPDATE = "UPDATE member2 SET ID=?, PW=?, EMAIL=?, REGIDATE=? WHERE NO=?";
	final String SQL_DELETE = "DELETE FROM member2 WHERE NO=?";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	public ArrayList<MemberDto> selectAll() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// 리스트에는 dto를 담아줄거임
				// rs는 쿼리의 결과물을 가져오니까 컬럼명 쓰는걸 명심
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String regidate = rs.getString("regidate");
				
				list.add(new MemberDto(no, id, pw, email, regidate));
			}
			
			// 조회를 하는데 커밋은 필요없음.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, stmt, rs);
		return list;
	}
	
	public void insert(MemberDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getEmail());
			stmt.setString(4, dto.getRegidate());
			
			int cnt = stmt.executeUpdate();
			if(cnt>0)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn);
		JdbcUtil.close(stmt);
	}
	
	public MemberDto selectByNo(String no_str) {
		MemberDto dto = new MemberDto();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_NO);
			stmt.setString(1, no_str);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setEmail(rs.getString("email"));
				dto.setRegidate(rs.getString("regidate"));
			}
			
			JdbcUtil.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dto;
	}
	
	public void update(MemberDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getEmail());
			stmt.setString(4, dto.getRegidate());
			stmt.setInt(5, dto.getNo());
			
			int cnt = stmt.executeUpdate();
			if(cnt>0)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn);
		JdbcUtil.close(stmt);
	}
	
	public void delete(String no_str) {
		// 번호 입력 받아서 삭제.
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, no_str);
			int cnt = stmt.executeUpdate();
			
			if(cnt>0)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn);
		JdbcUtil.close(stmt);
	}
	
	//joinMember : 회원가입 
		public boolean joinMember(MemberDto dto) { 
			//① 접속 
			conn = JdbcUtil.getConnection();
			
			//③ try-catch 블록 작성 후 PreapareStatement 설정 
			try { 
				stmt = conn.prepareStatement(SQL_INSERT); 
				stmt.setString(1, dto.getId()); 
				stmt.setString(2, dto.getPw()); 
				stmt.setString(3, dto.getEmail()); 
				stmt.setString(4, dto.getRegidate()); 

				int cnt = stmt.executeUpdate(); 
				if(cnt != 0) { 
					return true; 
				} 
			} catch (Exception e) { 
				e.printStackTrace(); 
				System.out.println("joinMember() Exception!!!"); 
			} 
			return false; 
		} //joinMember() 
		
		//isMember : 회원 여부 
		public int isMember(MemberDto dto) { 
			conn = JdbcUtil.getConnection(); 
			String sql = "SELECT PW FROM MEMBER2 WHERE ID = ?"; 
			int result = -1; 
			try { 
				stmt = conn.prepareStatement(sql); 
				stmt.setString(1, dto.getId()); 
				rs = stmt.executeQuery(); 
				if(rs.next()) { 
					//아이디 존재 
					if(rs.getString("member_pw").equals(dto.getPw())) { 
						result = 1; //비밀번호 일치 
					} else { 
						result = 0; //비밀번호 불일치 
					} 
				} else { 
					//아이디가 존재하지 않는다
					result = -1; 
				} 
			} catch (Exception e) { 
				e.printStackTrace(); 
				System.out.println("isMember() Exception!!!"); 
			} 
			return result; 
		} //isMember()
}
