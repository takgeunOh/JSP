package org.comstudy21.model;

public class MemberDto {
	private int no;
	private String id, pw, email, regidate;
	
	public MemberDto() {
		this(0, "", "", "", "");
	}
	
	public MemberDto(int no, String id, String pw, String email, String regidate) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.regidate = regidate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", id=" + id + ", pw=" + pw + ", email=" + email + ", regidate=" + regidate
				+ "]";
	}
	
	
}
